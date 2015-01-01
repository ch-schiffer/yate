package yate.model;

import javax.swing.DefaultListModel;
import yate.project.File;
import yate.project.Project;

/**
 *
 * @author Laurin
 */
public class ProjectMenuModel {
    
    //Das Projekt mit all seinen Daten.
    private Project project;
    //Diese Liste ist das model der JList in ProjectView.
    //Nur Änderungen in der dml werden sichtbar sein.
    private DefaultListModel<File> dlm;
    
    
    /**
     * Der Konstruktor für das ProjectMenuModel übertragt alle Einträge aus der File Liste aus dem Projekt in die dlm.
     * @param project Eine Project Instanz, die nicht null sein darf.
     */
    public ProjectMenuModel(Project project) {
        this.project = project;
        this.dlm = new DefaultListModel<>();
        
        sync();
    }
    /**
     * Getter für den Projektnamen.
     * Ruft getName() vom aktuellen project auf.
     * @return Projektname Der aktuelle Name des Projekts.
     */
    public String getProjectName() {
        return project.getName();
    }
    /**
     * Setter für den Projektnamen.
     * Ruft setName() vom aktuellen project auf.
     * @param projectName Der neue Name des Projekts.
     */
    public void setProjectName(String projectName) {
        this.project.setName(projectName);
    }
    /**
     * Fügt eine Datein zu der Liste in project und der dlm hinzu.
     * @param file Eine Datei.
     */
    public void addFile(File file) {
        if (!project.getFiles().contains(file)){
            project.addFile(file);
            dlm.addElement(file);
        }
    }
    /**
     * Löscht eine Datei aus der Lsite des Projekts.
     * @param file Die zu löschende Datei.
     */
    public void removeFile(File file) {
        project.removeFile(file);
        dlm.removeElement(file);
    }
    /**
     * Eine Funktion um das aktuelle Projekt zu wechseln.
     * Die dlm wird entsprechend Synchronisiert.
     * @param project Das neue Projekt.
     */
    public void setProject(Project project) {
        this.project = project;
        sync();
    }
    /**
     * Gibt das DefaultListModel zurück.
     * @return Das dlm.
     */
    public DefaultListModel<File> getDlm() {
        return dlm;
    }
    /**
     * Synchronisiert die ArrayList aus project mit der dlm.
     * Die dlm wird dabei kommplett geleert.
     */
    private void sync ()
    {
        dlm.clear();
        for (File f:project.getFiles())
        {
            dlm.addElement(f);
        }
    }
}
