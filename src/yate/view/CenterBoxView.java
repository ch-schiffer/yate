package yate.view;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author Laurin
 */
public class CenterBoxView extends javax.swing.JPanel implements View{

    private ArrayList<JLabel> lines = new ArrayList<JLabel>();
    private HashMap<String,JComponent> components;

    /**
     * Creates new form CenterBox
     */
    public CenterBoxView() {
        initComponents();
        components = new HashMap<>();
        setLines(1);
        addComponentsToHashMap();
    }
    
    
    private void addComponentsToHashMap()
    {
        
    }
    
    
  @Override
    public JComponent getComponent(String Name) {
        return components.get(Name);
    }

    public void setLines(int lineCount) {

        lines.clear();

        String s = "";

        for (int i = 1; i <= lineCount; i++) {
            s += "" + i + "\n";
        }

        jTextPane1.setText(s);
    }

    public Document getEditorPaneDocument() {
        return jEditorPane1.getDocument();
    }

    public void addDocumentUpdateListener(DocumentListener listener) {
        jEditorPane1.getDocument().addDocumentListener(listener);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextPane1 = new javax.swing.JTextPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(30, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(30, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(30, 300));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jTextPane1.setEnabled(false);
        jTextPane1.setFocusable(false);
        jPanel1.add(jTextPane1);

        jPanel2.add(jPanel1, java.awt.BorderLayout.LINE_START);
        jPanel2.add(jEditorPane1, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(jPanel2);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables


}
