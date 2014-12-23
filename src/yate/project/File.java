/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.project;

import java.io.Serializable;
import java.util.Objects;
import yate.syntax.general.Language;

/**
 *
 * @author Carina
 */
public class File implements Serializable{
    private String path = null;
    private String text;
    private boolean validName;
    private java.io.File internalFile;
    private Language language;
    
    public boolean isValid() {
        return validName;
    }
    
    public void setValid() {
        this.validName = true;
    }
    
    public File (){
        validName = false;
    }
    
    public File  (String path) {
        this.path = path;
        validName = false;
    }
    
    public String getPath (){
        return path != null ? path : "Unbenannt";
    }
    
    
    public void setPath (String path){
        this.path = path;
    }
    
    public String getName () {
        internalFile = internalFile != null && !internalFile.getPath().equals("Unbenannt") ? internalFile : new java.io.File(this.getPath());
        return internalFile != null ? internalFile.getName() : "Unbenannt";    
    }
    
    public String getContent (){
        return text;
    }
    
    public void setContent (String content){
        this.text = content;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final File other = (File) obj;
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        return true;
    }
    
    /**
     * Getter für die Sprache
     * @return Sprache
     */
    public Language getLanguage (){
        return language;
    }
    
    /**
     * Setter für die Sprache
     * @param language 
     */
    public void setLanguage (Language language){
        this.language = language;
    }
    
    //3.12.2014 Laurin
    
    /**
     * Die Methode toString muss überschrieben werden,
     * damit diese in der JList gescheit angezeigt wird.
     *
     * @return Den Pfad der Datei.
     */
    
    
    @Override
    public String toString()
    {
        return getPath();
    }
    
    
    
    public String getFileExtension() {
        String name = this.getPath();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }
    
}
