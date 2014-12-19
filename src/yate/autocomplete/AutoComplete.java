/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.autocomplete;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
    private final ArrayList<String> currentResults = new ArrayList<>();
    private boolean inCompleteMode = false;
    private int currentIndex = 0;
    
    public AutoComplete(JTextPane textField, AutoCompleteManager autoCompleteManager) {
        this.textPane = textField;
        this.autoCompleteManager = autoCompleteManager;
    }
    
    @Override
    public void changedUpdate(DocumentEvent ev) { }
    
    @Override
    public void removeUpdate(DocumentEvent ev) { }
    
    private int position = 0;
    private int wordBegin = 0;
    
    @Override
    public void insertUpdate(DocumentEvent ev) {
        keywords = new ArrayList<>(autoCompleteManager.getSuggestions());
        String prefix = getCurrentWord(ev);
        currentResults.clear();
        //Nach einem neuen Suchlauf auf den ersten Vorschlag positionieren
        currentIndex = 0;
        for (String word : keywords) {
            if (word.startsWith(prefix)) {
                currentResults.add(word);
            }
        }
        if (currentResults.size() > 0) {
            inCompleteMode = true;
            String match = currentResults.get(currentIndex);
            // Treffer gefunden
            String completion = match.substring(position - wordBegin);
            SwingUtilities.invokeLater(new CompletionTask(completion, position+1));
        }
        else {
            mode = Mode.INSERT;
        }
    }
    
    private String getCurrentWord(DocumentEvent ev) {
        if (ev.getLength() != 1)
            return "";
        
        position = ev.getOffset();
        String content;
        try {
            content = textPane.getText(0, position + 1);
        } catch (BadLocationException e) {
            return "";
        }
        
        // Wortanfang suchen        
        for (wordBegin = position; wordBegin >= 0; wordBegin--) {
            if (!Character.isLetter(content.charAt(wordBegin))) {
                break;
            }
        }
        
        //Nur Wörter mit min 2 Zeichen betrachten
        if (wordBegin >= 0 && position - wordBegin < 2)
            return content.substring(wordBegin + 1);
        return "";
    }
    
    public class CommitAction extends AbstractAction {
        
        @Override
        public void actionPerformed(ActionEvent ev) {
            inCompleteMode = false;
            if (mode == Mode.COMPLETION) {
                int pos = textPane.getSelectionEnd();
                String sb = textPane.getText();
                textPane.setText(sb);
                textPane.setCaretPosition(pos);
                mode = Mode.INSERT;
            } else {
                textPane.replaceSelection("\t");
            }
        }
    }
    
    public class SelectNextAction extends AbstractAction {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (inCompleteMode && currentResults.size() > 0) {
                currentIndex = (currentIndex+1) % currentResults.size();
                String match = currentResults.get(currentIndex);
                // Treffer gefunden
                String completion = match.substring(position - wordBegin);
                SwingUtilities.invokeLater(new CompletionTask(completion, position+1));
            }
        }
    }
    
    public class SelectPrevAction extends AbstractAction {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (inCompleteMode && currentResults.size() > 0) {
                currentIndex = (currentIndex+1) % currentResults.size();
                String match = currentResults.get(currentIndex);
                // Treffer gefunden
                String completion = match.substring(position - wordBegin);
                SwingUtilities.invokeLater(new CompletionTask(completion, position+1));
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
        
        @Override
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
