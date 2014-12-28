package yate.managers;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import yate.project.Project;

/**
 *
 * @author Carina
 * 
 * Klasse ProjectManager ist für die Administration des aktuellen Projekts zuständig
 */
public class ProjectManager {
    
     //Private Instanz der Klasse selbst
    private static ProjectManager projectmanager;
    
    // aktuelles Projekt
    private Project currentProject;
    
    /**
     * privater Konstruktor, der das aktuelle Projekt anlegt
     */
    private ProjectManager () {
        currentProject = new Project();
    }
    
    /**
     * Methode, die statt des Konstruktors von außen aufgerufen wird
     * ruft, sofern das private Attribut der Klasse noch nicht instanziiert ist, 
     * den Konstruktor auf
     * @return private Instanz des ProjectManagers
     */
    public static ProjectManager getInstance(){
        //Instanziieren, wenn interne Instanz noch NULL ist
        return projectmanager = projectmanager != null ? projectmanager : new ProjectManager();
    }
    
    /**
     * speichert das aktuelle Projekt
     */
    public void saveProject() {
        try (XMLEncoder enc = new XMLEncoder(new FileOutputStream(currentProject.getPath()))){
            enc.writeObject(currentProject);       
        } catch (IOException e) {
        }
    }
    
    /**
     * lädt das passende Projekt zum übergebenen FileInputStream
     * @param fis 
     */
    public void loadProject(FileInputStream fis) {
        
        XMLDecoder dec = new XMLDecoder(fis);
        currentProject = (Project) dec.readObject();        
    }
    
    /**
     * schliesst das aktuelle Projekt
     */
    public void closeProject(){
        currentProject = null;
    }
    
    /**
     * Getter für das aktuelle Projekt
     * @return aktuelles Projekt
     */
    public Project getCurrentProject(){
        return currentProject;
    }
    
    /**
     * erstellt ein Projekt und setzt es als das aktuelle Projekt
     */
    public void createProject (){
        Project project = new Project();
        currentProject = project;
    }
    
    
}
