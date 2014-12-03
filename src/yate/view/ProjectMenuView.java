package yate.view;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import yate.listener.ProjectMenu.AddToProjectListener;
import yate.listener.ProjectMenu.EditProjectFileListener;
import yate.listener.ProjectMenu.NewProjectListener;
import yate.listener.ProjectMenu.OpenProjectListener;
import yate.listener.ProjectMenu.RemoveFromProjectListener;
import yate.listener.ProjectMenu.SaveProjectListener;
import yate.project.File;

/**
 *
 * @author Laurin
 */
public class ProjectMenuView extends javax.swing.JPanel {

    /**
     * Creates new form SideMenu
     */
    public ProjectMenuView() {
        initComponents();
    }
    
    public void  setListModel(DefaultListModel<File> model)
    {
        jL_files.setModel(model);
    }
    
    public File getSelectedItem()
    {
        return (File) jL_files.getSelectedValue();
    }

    public void setProjectName(String text) {
        jL_projectName.setText(text);
    }

    public ListModel getFileModel() {
        return jL_files.getModel();
    }

    //Listener
    public void addAddToProjectListener(AddToProjectListener l) {
        jB_addFile.addActionListener(l);
    }

    public void addEditProjectFileListener(EditProjectFileListener l) {
        jB_editProject.addActionListener(l);
    }

    public void addNewProjectListener(NewProjectListener l) {
        jB_newProject.addActionListener(l);
    }

    public void addRemoveFromProjectListener(RemoveFromProjectListener l) {
        jB_removeFile.addActionListener(l);
    }
    
   public void addOpenProjectListener(OpenProjectListener l) {
        jB_openProject.addActionListener(l);
    }
   
   public void addSaveProjectListener(SaveProjectListener l) {
        jB_saveProject.addActionListener(l);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jL_files = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jB_addFile = new javax.swing.JButton();
        jB_removeFile = new javax.swing.JButton();
        jB_newProject = new javax.swing.JButton();
        jB_openProject = new javax.swing.JButton();
        jB_editProject = new javax.swing.JButton();
        jB_saveProject = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jL_projectName = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jL_files);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jB_addFile.setText("+");
        jB_addFile.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jB_addFile.setMaximumSize(new java.awt.Dimension(30, 25));
        jB_addFile.setMinimumSize(new java.awt.Dimension(30, 25));
        jB_addFile.setPreferredSize(new java.awt.Dimension(30, 25));
        jPanel1.add(jB_addFile);

        jB_removeFile.setText("-");
        jB_removeFile.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jB_removeFile.setMaximumSize(new java.awt.Dimension(30, 25));
        jB_removeFile.setMinimumSize(new java.awt.Dimension(30, 25));
        jB_removeFile.setPreferredSize(new java.awt.Dimension(30, 25));
        jPanel1.add(jB_removeFile);

        jB_newProject.setText("Neu");
        jPanel1.add(jB_newProject);

        jB_openProject.setText("Öffnen");
        jPanel1.add(jB_openProject);

        jB_editProject.setText("Bearbeiten");
        jPanel1.add(jB_editProject);

        jB_saveProject.setText("Speichern");
        jPanel1.add(jB_saveProject);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        jL_projectName.setText("Projekt Name");
        jPanel2.add(jL_projectName);

        add(jPanel2, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_addFile;
    private javax.swing.JButton jB_editProject;
    private javax.swing.JButton jB_newProject;
    private javax.swing.JButton jB_openProject;
    private javax.swing.JButton jB_removeFile;
    private javax.swing.JButton jB_saveProject;
    private javax.swing.JList jL_files;
    private javax.swing.JLabel jL_projectName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
