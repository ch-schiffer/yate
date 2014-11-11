package yate.model;

import java.awt.Color;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Laurin
 */
public class CenterBoxModel {

    //Document der zugehoerigen CenterBoxView;
    StyledDocument document;

    public CenterBoxModel(Document StyledDocument) {
        this.document = document;
    }

    public void setColor(Color c, int start, int length) {
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setForeground(sas, c);
        document.setCharacterAttributes(start, length, sas, false);
    }
}
