/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.project;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Carina
 */
public class File implements Serializable{
    private String path = null;
    private String text;
    private boolean validName;

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
    
}
