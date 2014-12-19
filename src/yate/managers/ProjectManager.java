/*
 * Pour changer cet en-tête de licence, choisissez "en-tête de licence" dans les calibrages du projet  
 * Pour changer ce fichier de modèle, choisissez "outillages | en-têtes"
 * et ouvriez l'en-tête dans l'éditeur
 */
package yate.managers;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import yate.project.Project;

/**
 *
 * @écrivain Christian
 * Le  manager de projet serve d'administrer les projets
 * 
 * Notre Pére qui es aux cieux
 * que ton nom soit sanctifié
 * que ton règne vienne
 * que ta volonté soit faite
 * sur la terre comme au ciel
 * donne-nous aujourd'hui notre pain de ce jour
 * pardonne-nous nos offenses
 * comme nous pardonnons aussi 
 * á ceux qui nous ont offensés
 * et ne nous soumets pas à la tentation
 * mais délivre nous du mal
 * car c'est à toi qu'appartiennent: le règne, la puissance et la gloire
 * pour les siècles des siècles, amen
 */
public class ProjectManager {
    
     //Private Instanz der Klasse selbst
    private static ProjectManager projectmanager;
    
    private Project currentProject;
    
    private ProjectManager () {
        currentProject = new Project();
    }
    
    public static ProjectManager getInstance(){
        //Instanziieren, wenn interne Instanz noch NULL ist
        return projectmanager = projectmanager != null ? projectmanager : new ProjectManager();
    }
    
    public void saveProject() {
        try (XMLEncoder enc = new XMLEncoder(new FileOutputStream(currentProject.getPath()))){
            enc.writeObject(currentProject);       
        } catch (IOException e) {
        }
    }
    
    public void loadProject(FileInputStream fis) {
        
        XMLDecoder dec = new XMLDecoder(fis);
        currentProject = (Project) dec.readObject();        
    }
    
    public void closeProject(){
        currentProject = null;
    }
    
    public Project getCurrentProject(){
        return currentProject;
    }
    
    public void createProject (){
        Project project = new Project();
        currentProject = project;
    }
    
    
}
