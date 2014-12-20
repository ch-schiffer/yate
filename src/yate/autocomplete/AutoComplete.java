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
 * Diese Klasse steuert die automatische Vervollständigung von bereits im Text
 * verwendeten Wörtern. Vorschläge werden vorgeblendet und können vervollständigt
 * werden. Außerdem können mehrere Treffer durchnavigiert werden, falls vorhanden.
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
    private int currentIndex = 0;
    private int position = 0;
    private int wordBegin = 0;
    private int currentCompleteLength = 0;
    
    /**
     * Erstellt eine neue Instanz der Klasse
     * @param textPane TextPane, dessen Text verwaltet werden soll
     * @param autoCompleteManager AutoCompleteManager, der die Vorschläge sammelt
     */
    public AutoComplete(JTextPane textPane, AutoCompleteManager autoCompleteManager) {
        this.textPane = textPane;
        this.autoCompleteManager = autoCompleteManager;
    }
    
    /**
     * Nicht genutzt
     * @param ev Nicht genutzt
     */
    @Override
    public void changedUpdate(DocumentEvent ev) { }
    
    /**
     * Nicht genutzt
     * @param ev Nicht genutzt
     */
    @Override
    public void removeUpdate(DocumentEvent ev) { }
    
    /**
     * Diese Funktion wird ausgeführt, wenn der Text geändert wird
     * @param ev Informationen über das Event
     */
    @Override
    public void insertUpdate(DocumentEvent ev) {
        if (ev.getLength() != 1) return;    //Dokument leer

        //Position im Text feststellen
        position = ev.getOffset();

        //Text ermitteln
        String content;
        try {
            content = textPane.getText(0, position + 1);
        } catch (BadLocationException e) {
            return;
        }
        
        // Wortanfang suchen
        wordBegin = 0;
        for (wordBegin = position; wordBegin > 0; wordBegin--) {
            if (!Character.isLetter(content.charAt(wordBegin))) {
                break;
            }
        }
        
        //Nur Wörter mit min 2 Zeichen betrachten
        if (position - wordBegin < 2) return;
        
        currentIndex = 0;
        currentCompleteLength = 0;
        
        //Vorschläge aus dem AutoCompleteManager abholen
        keywords = new ArrayList<>(autoCompleteManager.getSuggestions());
        
        String prefix = content.substring(wordBegin + 1);
        currentResults.clear();
        
        //Wörter finden, die dem eingegebenen Wortanfang entsprechen
        for (String word : keywords) {
            if (word.startsWith(prefix)) {
                currentResults.add(word);
            }
        }
        
        if (currentIndex < currentResults.size()) {
            String match = currentResults.get(currentIndex);
            String completion = match.substring(position - wordBegin);
            SwingUtilities.invokeLater(new CompletionTask(completion, position+1));
        } else {
            mode = Mode.INSERT;
        }
    }
    
    /**
     * Diese Aktion vervollständgt entweder die Eingabe, oder verwirft diese,
     * wenn nichts vorgeblendet wurde
     */
    public class CommitAction extends AbstractAction {
        
        @Override
        public void actionPerformed(ActionEvent ev) {
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
    
    /**
     * Diese Aktion blendet den vorherigen Vorschlag in der Liste vor. Ist der 
     * Anfang der Vorschlagsliste erreicht, wird mit dem letzten Element 
     * fortgefahren
     */
    public class SelectPrevAction extends AbstractAction {
        
        /**
         * Führt die Aktion aus
         * @param e Nicht genutzt
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentResults.size() > 0) {
                if (currentIndex == 0) currentIndex = currentResults.size()-1;
                else currentIndex = (currentIndex-1) % currentResults.size();
                String match = currentResults.get(currentIndex);
                // Treffer gefunden
                String completion = match.substring(position - wordBegin);
                SwingUtilities.invokeLater(new CompletionTask(completion, position+1));
            }
        }
    }
    
    /**
     * Diese Aktion blendet den nächsten Vorschlag in der Liste vor. Ist das 
     * Ende der Vorschlagsliste erreicht, wird mit dem ersten Element 
     * fortgefahren
     */
    public class SelectNextAction extends AbstractAction {
        
        /**
         * Führt die Aktion aus
         * @param e Nicht genutzt
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentResults.size() > 0) {
                currentIndex = (currentIndex+1) % currentResults.size();
                String match = currentResults.get(currentIndex);
                // Treffer gefunden
                String completion = match.substring(position - wordBegin);
                SwingUtilities.invokeLater(new CompletionTask(completion, position+1));
            }
        }
    }
    
    /**
     * Dient zum Vorblenden des aktuellen Vorschlags in dem angebundenen JTextPane
     */
    private class CompletionTask implements Runnable {
        private final String completion;
        private final int position;
        
        CompletionTask(String completion, int position) {
            this.completion = completion;
            this.position = position;
        }
        
        /**
         * Führt die Aktion aus
         */
        @Override
        public void run() {
            try {
                if (currentCompleteLength > 0) {
                    textPane.getDocument().remove(position, currentCompleteLength);
                }
                currentCompleteLength = completion.length();
                textPane.getDocument().insertString(position, completion, null);
                textPane.setCaretPosition(position + currentCompleteLength);
                textPane.moveCaretPosition(position);
                mode = Mode.COMPLETION;
                
            } catch (BadLocationException ex) {
            }
        }
    }
}
