package yate.model;

import javax.swing.DefaultListModel;

/**
 *
 * @author Laurin
 */
public class ProjectMenuModel extends Model {

    private String projectName;
    private final DefaultListModel<FileModel> files;

    public ProjectMenuModel(String projectName, DefaultListModel<FileModel> files) {
        this.projectName = projectName;
        this.files = files;
    }

    public ProjectMenuModel() {
        this.projectName = "Neues Projekt";
        this.files = new DefaultListModel<>();
    }

    public DefaultListModel<FileModel> getFiles() {
        return files;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void addFile(FileModel file) {
        files.addElement(file);
    }

    public void removeFile(FileModel file) {
        files.removeElement(file);
    }

    public void removeFile(int index) {
        files.remove(index);
    }

}
