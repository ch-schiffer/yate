package yate.model;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import yate.syntax.general.SyntaxToken;
import yate.syntax.java.JavaLanguage;

/**
 *
 * @author Laurin
 */
public class CenterBoxModel {

    /*
    *-*-*-*-* TEST CHS *-*-*-*-*
    */
    JavaLanguage javaLanguage = new JavaLanguage();
    /*
    *-*-*-*-* TEST CHS *-*-*-*-*
    */

    //Document der zugehoerigen CenterBoxView;
    StyledDocument document;

    public CenterBoxModel(StyledDocument document) {
        this.document = document;
    }

    public void setColor(Color c, int start, int length) {
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setForeground(sas, c);
        document.setCharacterAttributes(start, length, sas, false);
    }
    
    /*
    *-*-*-*-* TEST CHS *-*-*-*-*
    */
    public void analyseSyntax()
    {
        String text;
        try {
            text = document.getText(0, document.getLength());
        }
        catch(BadLocationException ex)
        {
            return;
        }
        
        ArrayList<SyntaxToken> tokens = javaLanguage.analyzeSyntax(text);
        for (SyntaxToken token : tokens) {
            setColor(Color.red, token.getStart(), token.getLength());
        }        
    }
    /*
    *-*-*-*-* TEST CHS *-*-*-*-*
    */
}
