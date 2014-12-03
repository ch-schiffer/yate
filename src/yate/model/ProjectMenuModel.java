package yate.model;

import javax.swing.DefaultListModel;
import yate.project.File;
import yate.project.Project;

/**
 *
 * @author Laurin
 */
public class ProjectMenuModel {

    private Project project;
    private DefaultListModel<File> dlm;

    public ProjectMenuModel(Project project) {
        this.project = project;
        this.dlm = new DefaultListModel<>();
        
        for (File f:project.getFiles())
        {
            dlm.addElement(f);
        }
        
    }

    public String getProjectName() {
        return project.getName();
    }

    public void setProjectName(String projectName) {
        this.project.setName(projectName);
    }

    public void addFile(File file) {
        project.addFile(file);
        dlm.addElement(file);
    }

    public void removeFile(File file) {
         project.removeFile(file);
         dlm.removeElement(file);
    }
    
    public void setProject(Project project) {
        this.project = project;
    }

    public DefaultListModel<File> getDlm() {
        return dlm;
    }
    
    
}
