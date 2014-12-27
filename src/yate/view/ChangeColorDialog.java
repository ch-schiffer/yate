package yate.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Laurin
 */
public class ChangeColorDialog extends javax.swing.JDialog {

    /**
     * Erstellen der View. Die Position wird relativ zum Parent gesetzt. Der
     * eigene CellRenderer "SimpleCellRenderer" wird auf die Liste gesetzt. Das
     * Vorschaupanel des Colors wird ebenfalls überschrieben.
     *
     * @param parent
     */
    public ChangeColorDialog(java.awt.Frame parent) {
        //Aufruf des parent Konstruktor.
        super(parent, true);
        //Javax.Swing Komponenten erstellen.
        initComponents();
        //Position setzen.
        this.setLocationRelativeTo(parent);
        //Den eigenen CellRenderer laden.
        jL_list.setCellRenderer(new SimpleCellRenderer());
        //Das Vorschaupanel überschreiben.
        jCC_colorChooser.setPreviewPanel(new JPanel());
    }

    /**
     * Getter für die gerade im ColorChooser gewählten Farbe.
     *
     * @return gewählte Color
     */
    public Color getChosenColor() {
        return jCC_colorChooser.getColor();
    }

    /**
     * Repaint auf die Lsite aufrufen.
     */
    public void repaintList() {
        jL_list.repaint();
    }

    /**
     * Farbe des ColorChooser setzen.
     *
     * @param c eine Color
     */
    public void setChoserColor(Color c) {
        jCC_colorChooser.setColor(c);
    }

    /**
     * Gibt den Index der JList zurück.
     *
     * @return Index
     */
    public int getSelectedIndex() {
        return jL_list.getSelectedIndex();
    }

    /**
     * Das DefaultListModel setzen.
     *
     * @param dlm DefaultListModel
     */
    public void setDefaultListModel(DefaultListModel dlm) {
        jL_list.setModel(dlm);
        if (dlm != null && dlm.size() > 0) {
            jL_list.setSelectedIndex(0);
        }
    }

    //Listener
    /**
     * Listener für den CancelButton.
     *
     * @param l ActionListener
     */
    public void addCancelButtonListener(ActionListener l) {
        jB_cancel.addActionListener(l);
    }

    /**
     * Listener für den ConfirmButton.
     *
     * @param l ActionListener
     */
    public void addConfirmButtonListener(ActionListener l) {
        jB_oK.addActionListener(l);
    }

    /**
     * Listener für die Liste.
     *
     * @param l ListSelectionListener
     */
    public void addSelectedItemChangedListener(ListSelectionListener l) {
        jL_list.addListSelectionListener(l);
    }

    /**
     * Listener für den ColorChooser.
     *
     * @param l ChangeListener
     */
    public void addColorChangedListener(ChangeListener l) {
        jCC_colorChooser.getSelectionModel().addChangeListener(l);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jB_oK = new javax.swing.JButton();
        jB_cancel = new javax.swing.JButton();
        jCC_colorChooser = new javax.swing.JColorChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jL_list = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Farben Bearbeiten");
        setModal(true);

        jB_oK.setText("OK");
        jPanel1.add(jB_oK);

        jB_cancel.setText("Abbrechen");
        jPanel1.add(jB_cancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jCC_colorChooser, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(130, 131));

        jScrollPane1.setViewportView(jL_list);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_cancel;
    private javax.swing.JButton jB_oK;
    private javax.swing.JColorChooser jCC_colorChooser;
    private javax.swing.JList jL_list;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
