package yate.project;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Carina
 * Klasse Project enthält das serialisierbare Projekt
 */
public class Project implements Serializable{
    
    // Pfad zum Projekt
    private String projectPath;
    // Name des Projekts
    private String name;
    // Liste der im Projekt enthaltenen Dateien
    private ArrayList<File> files;
    // Angabe ob das Projekt einen gültigen Namen und damit Pfad hat
    private boolean validName;
    // HashMap der zum Projekt gehörigen Farben
    private HashMap<String, Color> colors;
    
    
    /**
     * Konstruktor zur Erstellung eines Projekts
     */
    public Project (){
        this.files = new ArrayList <>();        
    }
    
    /**
     * fügt dem Projekt eine Datei hinzu
     * @param file hinzuzufügende Datei
     */
    public void addFile (File file){
        files.add(file);
    }
    
    /**
     * Entfernt die angegebene Datei, sofern vorhanden, aus dem Projekt
     * @param file zu entfernende Datei
     */
    public void removeFile (File file){
        if (files.contains(file)){
            files.remove(file);
        }
    }
    
    /**
     * Getter für Pfad
     * @return Pfad
     */
    public String getPath (){
        return projectPath;
    }
    
    /**
     * Setter für Pfad
     * @param path zu setzender Pfad
     */
    public void setPath (String path){
        this.projectPath = path;
    }    
    
    /**
     * Getter für den Projektnamen
     * @return Projektname
     */
    public String getName(){
        return name;
    }
    
    /**
     * Setter für den Namen
     * @param name zu setzender Projektname
     */
    public void setName (String name){
        this.name = name;
    }
    
    /**
     * Getter für die im Projekt enthaltenen Dateien
     * @return Liste der enthaltenen Dateien
     */
    public ArrayList<File> getFiles() {
        return files;
    }
    
    /**
     * @deprecated
     * @param files
     */
    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
    
    /**
     * Getter für die Angabe, ob Pfad und Name aktuell gesetzt sind oder nicht
     * @return 
     */
    public boolean isValid() {
        return validName;
    }
    
    /**
     * setzt das Attribut validname auf true
     */
    public void setValid() {
        this.validName = true;
    }

    /**
     * Getter für die gesetzten Farben
     * @return HashMap mit den gesetzten Farben
     */
    public HashMap<String, Color> getColors() {
        return colors;
    }

    /**
     * Setter für die Farben
     * @param colors HashMap mit den zu setzenden Farben
     */
    public void setColors(HashMap<String, Color> colors) {
        this.colors = colors;
    }
}
