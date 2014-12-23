/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.project;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import yate.managers.ColorManager;
import yate.syntax.general.Language;

/**
 *
 * @author Carina
 */
public class Project implements Serializable{
    
    private String projectPath;
    private String name;
    private ArrayList<File> files;
    private boolean validName;
    private HashMap<String, Color> colors;
    
    
    /**
     * Konstruktor zur Erstellung eines Projekts
     */
    public Project (){
        this.files = new ArrayList <>();
    }
    
    
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
    
    public HashMap<String, Color> getColors() {
        return ColorManager.getInstance().getColors();
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
     * @param path
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
     * @param name
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
    
    public boolean isValid() {
        return validName;
    }
    
    public void setValid() {
        this.validName = true;
    }
    
    public void setColors(HashMap<String, Color> colors) {
        for (String s: colors.keySet()) {
            ColorManager.getInstance().setColor(s, colors.get(s));
        }
    }
}
