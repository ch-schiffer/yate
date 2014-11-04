package yate.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Laurin
 */
public class CenterBoxModel {

    private static final Logger logger = Logger.getLogger(CenterBoxModel.class.getName());

    //Die Zeilennummern
    private int lineNumbers;
    //Document der zugehoerigen CenterBoxView;
    Document document;

    public CenterBoxModel(Document document) {
        this.document = document;
        updateLineNumbers();
    }

    private void calculateLineNumbers(String text) {
        this.lineNumbers = text.length() - text.replace("\n", "").length() + 1;
    }

    public void updateLineNumbers() {
        try {
            calculateLineNumbers(document.getText(0, document.getLength()));
        } catch (BadLocationException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public int getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(int lineNumbers) {
        this.lineNumbers = lineNumbers;
    }

}
