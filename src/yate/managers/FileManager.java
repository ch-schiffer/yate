package yate.managers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import yate.project.File;

/**
 *
 * @author Carina
 * 
 * Klasse FileManager ist für die Administration der Dateien zuständig
 * 
 */
public class FileManager {
    // Liste aller Dateien
    private final List <File> allFiles;
    // aktuelle Datei, mit der gearbeitet wird
    private File currentFile;
    // Varibale zum Zählen der Änderungen zum automatischen Zwischenspeichern
    private int countChanges;

    
   //Private Instanz der Klasse selbst
    private static FileManager filemanager;
    
    /**
     * privater Konstruktor, der die Liste aller Dateien instanziiert und die aktuelle 
     * Datei auf null setzt
     */
    private FileManager (){
        this.allFiles = new ArrayList <> ();
        this.currentFile = null;
        countChanges = 0;
    }
    
    /**
     * Methode, die statt des Konstruktors von außen aufgerufen wird.
     * Ruft, sofern das private Attribut der Klasse noch nicht instanziiert ist, 
     * den Konstruktor auf
     * @return Instanz des FileManagers
     */
    public static FileManager getInstance() {
        return filemanager = filemanager != null ? filemanager : new FileManager();
    }
    
    /**
     * speichert die übergebene Datei
     * @param file 
     */
    private void saveFile (File file) { 
         try (PrintWriter pw = new PrintWriter(new java.io.File(file.getPath()))) {
                pw.write(file.getContent());
                file.setValid();
                
            } catch (IOException e) {
            }
    }
    
    /**
     * speichert die aktuelle Datei 
    */
    public void saveCurrentFile(){
            saveFile(currentFile);
    }
    
    /**
     * speichert alle Dateien, die in der Liste der Dateien vorhanden sind
     */
    public void saveAllFiles (){
        for (File file : allFiles) {
            saveFile(file);     
        }
    }
    
    /**
     * schließt die aktuelle Datei
     */
    public void closeCurrentFile(){
        int index = allFiles.indexOf(currentFile);
        allFiles.remove(currentFile);
                        
        if (index > 0) {
            currentFile = allFiles.get(index-1);
        } else if (allFiles.size() > 0){
            currentFile = allFiles.get(0);
        } else {
            createFile();
        }
        
    }
    
    /**
     * schließt die übergebene Datei
     * @param file übergebene Datei
     */
    public void closeFile(File file){
        int index = allFiles.indexOf(file);
        allFiles.remove(file);
        if (file != currentFile) return;                
        if (index > 0) {
            currentFile = allFiles.get(index-1);
        } else if (allFiles.size() > 0){
            currentFile = allFiles.get(0);
        } else {
            createFile();
        }
        
    }
    
    /**
     * schließt alle Dateien
     */
    public void closeAllFiles(){
        allFiles.clear();
        currentFile = null;
    }
    
    /**
     * lädt die übergebene Datei
     * @param file übergebene Datei
     * @return die erstellte Datei
     */
    public File loadFile(java.io.File file) {
        File newFile = new File(file.getAbsolutePath());
        currentFile = newFile;
        allFiles.add(newFile);
        
        try (BufferedReader sc = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            
            while (sc.ready()){
                sb.append(sc.readLine());
                sb.append("\n");
            }
            
            newFile.setContent(sb.toString());
            newFile.setValid();
        } catch (IOException e) {
        }
        finally {
            return newFile; //06.12.14 CHS Erstellte Datei zurückgeben
        }
    };
    
    /**
     * erstellt eine neue Datei, fügt diese der Liste mit allen Dateien hinzu
     * und setzt diese als aktuelle Datei
     * @return die erstellte Datei
     */
    public File createFile(){
        File file = new File ();
        allFiles.add(file);
        currentFile = file;
        return file;
    }
    
    /**
     * Getter für die aktuelle Datei
     * @return aktuelle Datei
     */
     public File getCurrentFile() {
        return currentFile;
    }

     /**
      * Setter für die aktuelle Datei
      * @param currentFile übergebene Datei
      */
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }
    
    /**
     * Getter für die Liste mit allen Dateien
     * @return 
     */
    public List<File> getAllFiles() {
        return allFiles;
    }
    
    /**
     * Getter für die Anzahl der Änderungen seit dem letzten Speichern
     * @return Anzahl der Änderungen
     */
    public int getCountChanges() {
        return countChanges;
    }

    /**
     * Setzt die Anzahl der Änderungen auf 0 zurück
     */
    public void resetCountChanges() {
        this.countChanges = 0;
    }
    
    /**
     * Beim Aufruf dieser Methode wird die Anzahl er Änderungen um eins erhöht
     */
    public void incrementCountChanges() {
        this.countChanges++;
    }
    
    
}
