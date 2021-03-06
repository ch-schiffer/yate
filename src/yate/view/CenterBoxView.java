package yate.view;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;
import yate.autocomplete.AutoComplete;
import yate.autocomplete.AutoCompleteManager;
import yate.listener.CenterBox.DocumentUpdateAction;
import yate.listener.CenterBox.IndentAction;

/**
 * Die CenterBoxView ist die View, die in den TabedPane Angezeigt wird. Sie
 * enthält alle Komponenten zum zeigen des Texts.
 *
 * @author Laurin
 */
public class CenterBoxView extends javax.swing.JPanel {

    private static final String COMMIT_ACTION = "commit";
    private static final String SELECT_NEXT_ACTION = "next";
    private static final String SELECT_PREV_ACTION = "prev";

    /**
     * Neue Instanz der CenterBox erstellen. Erstellt die Komponenten und setzt
     * die TabStops.
     */
    public CenterBoxView() {
        initComponents();
        TextLineNumberComponent tln = new TextLineNumberComponent(jTP_text);
        tln.setUpdateFont(true);
        jScrollPane1.setRowHeaderView(tln);

        TabStop[] tabs = new TabStop[100];
        for (int i = 0; i < tabs.length; i++) {
            tabs[i] = new TabStop(30 + 30 * i, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
        }

        TabSet tabset = new TabSet(tabs);

        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
                StyleConstants.TabSet, tabset);
        jTP_text.setParagraphAttributes(aset, false);
    }

    /**
     * Getter für das StyledDocument.
     *
     * @return Das StyledDocument
     */
    public StyledDocument getStyledDocument() {
        return this.jTP_text.getStyledDocument();
    }

    /**
     * Setter für den Font.
     *
     * @param font FontArt
     * @param size Größe
     */
    public void setFont(String font, int size) {
        jTP_text.setFont(new Font(font, 0, size));
    }
    //Listener

    /**
     * Fügt den Listener für das Update hinzu.
     *
     * @param l DocumentUpdateAction
     */
    public void addDocumentUpdateAction(DocumentUpdateAction l) {
        jTP_text.getDocument().addDocumentListener(l);
    }

    /**
     * Fügt den Listener für das Update hinzu. Legt die Mappings für die
     * Autovervollständigung fest.
     *
     * @param autoCompleteManager AutoCompleteManager
     */
    public void addAutoCompleteListener(AutoCompleteManager autoCompleteManager) {
        //Mappings für die Autovervollständigung festlegen
        AutoComplete autoComplete = new AutoComplete(jTP_text, autoCompleteManager);
        jTP_text.getDocument().addDocumentListener(autoComplete);
        jTP_text.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), COMMIT_ACTION);
        jTP_text.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
        jTP_text.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.ALT_DOWN_MASK), SELECT_NEXT_ACTION);
        jTP_text.getActionMap().put(SELECT_NEXT_ACTION, autoComplete.new SelectNextAction());
        jTP_text.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.ALT_DOWN_MASK), SELECT_PREV_ACTION);
        jTP_text.getActionMap().put(SELECT_PREV_ACTION, autoComplete.new SelectPrevAction());
    }

    /**
     * Fügt die IdentAction hinzu.
     *
     * @param action IndentAction
     * @param identifier String
     */
    public void addIndentAction(IndentAction action, String identifier) {
        jTP_text.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK), identifier);
        jTP_text.getActionMap().put(identifier, action);
    }

    /**
     * Fügt den Listener für den Viewport hinzu.
     *
     * @param l ChangeListener
     */
    public void addViewPortChangeListener(ChangeListener l) {
        jScrollPane1.getViewport().addChangeListener(l);
    }

    /**
     * Fügt den Listener für das Caret hinzu.
     *
     * @param l CaretListener
     */
    public void addCaretListener(CaretListener l) {
        jTP_text.addCaretListener(l);
    }

    /**
     * Fokusiert den Text des Elements
     */
    public void focusElement() {
        //17.11.14 CHS
        jTP_text.requestFocus();
    }

    /**
     * Setzt den Text des Felds
     *
     * @param text Text
     */
    public void setText(String text) {
        //30.11.14 CAR
        jTP_text.setText(text);
    }

    /**
     * Getter für das JTextPane
     *
     * @return jTP_text
     */
    public JTextPane getTextPane() {
        return jTP_text;
    }

    /**
     * Setter für die Position des Carets.
     *
     * @param position
     */
    public void setCaretPosition(int position) {
        SwingUtilities.invokeLater(new SetCaret(position));
    }

    /**
     * Getter für die aktuelle Caret Position.
     *
     * @return CaretPosition
     */
    public int getCurrentCaretPosition() {
        return jTP_text.getCaretPosition();
    }

    private class SetCaret implements Runnable {

        private final int position;

        public SetCaret(int position) {
            this.position = position;
        }

        @Override
        public void run() {
            if (position < jTP_text.getText().length()) {
                jTP_text.setCaretPosition(position);
                jTP_text.moveCaretPosition(position);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTP_text = new javax.swing.JTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setViewportView(jTP_text);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTP_text;
    // End of variables declaration//GEN-END:variables

}
