package yate.project;

import java.io.Serializable;
import java.util.Objects;
import yate.syntax.general.Language;

/**
 *
 * @author Carina
 * Klasse File enthält die serialisierbare Datei
 */
public class File implements Serializable{
    // Pfad der Datei
    private String path = null;
    // Inhalt der Datei
    private String text;
    // Angabe ob Name gesetzt ist
    private boolean validName;
    //
    private java.io.File internalFile;
    // Programmiersprache der Datei
    private Language language;
    // Angabe, ob Datei ordentlich abgespeichert wurde und nicht nur temporär
    private boolean saved;
    
    /**
     * Konstruktor für eine Datei ohne Namen und Pfad
     */
    public File (){
        validName = false;
        saved = false;
    }
    
    /**
     * Konstruktor für eine Datei mit Pfad
     * @param path übergebener Pfad
     */
    public File  (String path) {
        this.path = path;
        validName = false;
        saved = false;
    }
    
    /**
     * Getter für den Pfad
     * @return
     */
    public String getPath (){
        return path != null ? path : "Unbenannt";
    }
    
    /**
     * Setter für den Pfad
     * @param path
     */
    public void setPath (String path){
        this.path = path;
    }
    
    /**
     * Getter für den Dateinamen
     * @return
     */
    public String getName () {
        internalFile = internalFile != null && !internalFile.getPath().equals("Unbenannt") ? internalFile : new java.io.File(this.getPath());
        return internalFile != null ? internalFile.getName() : "Unbenannt";
    }
    
    /**
     * Getter für den Dateiinhalt
     * @return Dateiinhalt
     */
    public String getContent (){
        return text;
    }
    
    /**
     * Setter für den Dateiinhalt
     * @param content Inhalt
     */
    public void setContent (String content){
        this.text = content;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
    /**
     * Vergleichsmethode für zwei Dateien
     * @param obj übergebene Datei
     * @return true oder false, je nachdem ob die Dateien gleich sind oder nicht
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final File other = (File) obj;
        return Objects.equals(this.path, other.path);
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
    
    /**
     * Getter, der angibt ob der Name der Datei gesetzt ist oder nicht
     * @return
     */
    public boolean isValid() {
        return validName;
    }
    
    /**
     * Setter, um die Angabe des Dateinamens auf true zu setzen
     */
    public void setValid() {
        this.validName = true;
    }
    
    
    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
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
        return getName();
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
