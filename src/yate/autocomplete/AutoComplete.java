/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.autocomplete;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Christian
 */

public class AutoComplete implements DocumentListener {
    
    private static enum Mode {
        INSERT,
        COMPLETION
    };
    
    private final JTextPane textPane;
    private List<String> keywords;
    private Mode mode = Mode.INSERT;
    private final AutoCompleteManager autoCompleteManager;
    
    public AutoComplete(JTextPane textField, AutoCompleteManager autoCompleteManager) {
        this.textPane = textField;
        this.autoCompleteManager = autoCompleteManager;
    }
    
    @Override
    public void changedUpdate(DocumentEvent ev) { }
    
    @Override
    public void removeUpdate(DocumentEvent ev) { }
    
    @Override
    public void insertUpdate(DocumentEvent ev) {
        if (ev.getLength() != 1)
            return;
        
        int pos = ev.getOffset();
        String content;
        try {
            content = textPane.getText(0, pos + 1);
        } catch (BadLocationException e) {
            return;
        }
        
        // Wortanfang suchen
        int w;
        for (w = pos; w >= 0; w--) {
            if (!Character.isLetter(content.charAt(w))) {
                break;
            }
        }
        
        //Nur Wörter mit min 2 Zeichen betrachten
        if (pos - w < 2)
            return;
        
        keywords = new ArrayList<>(autoCompleteManager.getSuggestions());
        
        String prefix = content.substring(w + 1);
        int n = Collections.binarySearch(keywords, prefix);
        if (n < 0 && -n <= keywords.size()) {
            String match = keywords.get(-n - 1);
            if (match.startsWith(prefix)) {
                // Treffer gefunden
                String completion = match.substring(pos - w);
                SwingUtilities.invokeLater(new CompletionTask(completion, pos+1));
            }
        } else {
            mode = Mode.INSERT;
        }
    }
    
    public class CommitAction extends AbstractAction {
        
        @Override
        public void actionPerformed(ActionEvent ev) {
            if (mode == Mode.COMPLETION) {
                int pos = textPane.getSelectionEnd();
                StringBuilder sb = new StringBuilder(textPane.getText());
                sb.insert(pos, " ");
                textPane.setText(sb.toString());
                textPane.setCaretPosition(pos + 1);
                mode = Mode.INSERT;
            } else {
                textPane.replaceSelection("\t");
            }
        }
    }
    
    private class CompletionTask implements Runnable {
        private final String completion;
        private final int position;
        
        CompletionTask(String completion, int position) {
            this.completion = completion;
            this.position = position;
        }
        
        public void run() {
            try {
                textPane.getDocument().insertString(position, completion, null);
                textPane.setCaretPosition(position + completion.length());
                textPane.moveCaretPosition(position);
                mode = Mode.COMPLETION;
                
            } catch (BadLocationException ex) {
            }
        }
    }
    
}
