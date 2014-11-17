package yate.model;
import java.awt.Color;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import yate.listener.CenterBox.DocumentUpdateAction;
import yate.syntax.general.*;
import yate.syntax.java.JavaLanguage;


/**
 *
 * @author Laurin
 */
public class CenterBoxModel {

    /*
    *-*-*-*-* TEST CHS *-*-*-*-*
    */
    JavaLanguage language = new JavaLanguage();
    /*
    *-*-*-*-* TEST CHS *-*-*-*-*
    */

    /**
     * Document der zugehoerigen CenterBoxView;
     */
    private StyledDocument document;
    
    /**
     * Dient zur intervallbasierten Speicherung der Syntaxtokens.
     * So kann in konstanter Zeit abgefragt werden, welchem Tokentyp ein Element
     * angehört.
     */
    private final NavigableMap<Integer,SyntaxToken> syntaxMap = new TreeMap<>();

    /**
     * Testmap, wird durch den ColorManager ersetzt
     */
    private final HashMap<String,Color> testColorMap = new HashMap<>();
    
    private int bracerIndex = 0;
    
    public CenterBoxModel(StyledDocument document) {
        this.document = document;

        testColorMap.put("JavaComment", Color.green);
        testColorMap.put("JavaDataType", Color.orange);
        testColorMap.put("JavaKeyWord", Color.blue);
        testColorMap.put("JavaLiteral", Color.red);
    }

    public void setColor(Color c, int start, int length) {
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setForeground(sas, c);
        document.setCharacterAttributes(start, length, sas, false);
    }
    
    private void clearColors()
    {
        setColor(Color.black, 0, document.getLength());
    }
    
    private final Runnable runHighlightSyntax = new Runnable() {
        @Override
        public void run() {
            //Diser Code wird in einem separaten Thread ausgeführt
            
            //DocumentUpdate abschalten
            DocumentUpdateAction.isEnabled = false;
            String text;
            try {
                //Textlänge ermitteln
                text = document.getText(0, document.getLength());
            }
            catch(BadLocationException ex) {
                return;
            } 
            //Tokens ermitteln und einfärben
            language.analyzeSyntax(text,syntaxMap);
            setSyntaxColors();
            
            //DocumentUpdate wieder einschalten
            DocumentUpdateAction.isEnabled = true;
        }
    };
    
    private void setSyntaxColors()
    {   
        //Standardfarbe einstellen (Schwarz auf weiß)
        clearColors();
        for (SyntaxToken token : syntaxMap.values()) {
                if (testColorMap.containsKey(token.getTokenType().getQualifiedName()))
                {
                    setColor(testColorMap.get(token.getTokenType().getQualifiedName()), token.getStart(), token.getLength());
                }
            }
    }
    
    private final Runnable runHighlightBracers = new Runnable() {
        @Override
        public void run() {            
            if (!(language instanceof IImplementBracerLogic)) return;
            //Diser Code wird in einem separaten Thread ausgeführt
            
            //DocumentUpdate abschalten
            DocumentUpdateAction.isEnabled = false;
            
            setSyntaxColors();
            SyntaxToken token = syntaxMap.get(bracerIndex);
            if (token != null && (token.getTokenType() instanceof ICloseBracer || token.getTokenType() instanceof IOpenBracer))
            {
                SyntaxToken pair = token.getPair();
                if(pair != null)
                {
                    setColor(Color.yellow, token.getStart(), token.getLength());
                    setColor(Color.yellow, pair.getStart(), pair.getLength());
                }
            }
            
            //DocumentUpdate wieder einschalten
            DocumentUpdateAction.isEnabled = true;
        }
    };

    
    public void analyseSyntax()
    {
        //Dieser Code muss invoked werden, da er erst nach der Abhandlung von
        //Events ausgeführt werden darf
        SwingUtilities.invokeLater(runHighlightSyntax);
    }
    
    public void highlightBracers(int position)
    {
        bracerIndex = position;
        SwingUtilities.invokeLater(runHighlightBracers); 
    }
            
}
