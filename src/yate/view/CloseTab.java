package yate.view;

import yate.listener.MainFrame.TabCloseListener;

/**
 *
 * @author Laurin
 */
public class CloseTab extends javax.swing.JPanel {

    /**
     * Creates new form CloseTab
     *
     * @param titel
     * @param l
     */
    public CloseTab(String titel, TabCloseListener l) {
        initComponents();
        jL_titel.setText(titel);
        jB_close.addActionListener(l);
    }

    public void setTitle(String title) {
        jL_titel.setText(title);
    }

    public String getTitle() {
        return jL_titel.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_titel = new javax.swing.JLabel();
        jB_close = new javax.swing.JButton();

        jL_titel.setText("titel");
        add(jL_titel);

        jB_close.setText("X");
        jB_close.setBorder(null);
        jB_close.setBorderPainted(false);
        jB_close.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(jB_close);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_close;
    private javax.swing.JLabel jL_titel;
    // End of variables declaration//GEN-END:variables
}
