package yate.managers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilenameFilter;
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
    // Variable zum Zählen der Änderungen zum automatischen Zwischenspeichern
    private int countChanges;
    // Pfad zum Verzeichnis für temporäre Dateien
    private final String tmpdir = System.getProperty("java.io.tmpdir");
    
    private final FilenameFilter fileNameFilter;
    // Verzeichnis für temporäre Dateien
    private java.io.File tempDir = new java.io.File(tmpdir);
    
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
        
        fileNameFilter = new FilenameFilter() {
            
            @Override
            public boolean accept(java.io.File dir, String name) {
                return name.endsWith(".yate");
            }
        };
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
            // Finden und Löschen aller .yate-Dateien
            for (java.io.File fileToDelete : tempDir.listFiles(fileNameFilter)) {
                if (fileToDelete.getName().split(".")[0].equals(file.getName())){
                    fileToDelete.delete();
                }
            }
            file.setSaved(true);
        } catch (IOException e) {
            file.setSaved(false);
        }
    }
    
    /**
     * Löscht alle temporären Dateien, die von yate abgespeichert wurden
     */
    public void deleteAllTemporaryFiles() {
        // Finden und Löschen aller .yate-Dateien
        for (java.io.File fileToDelete : tempDir.listFiles(fileNameFilter)) {
            fileToDelete.delete();
        }
    }
    
    /**
     * Speichert die aktuelle Datei
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
     * Temporäres Zwischenspeichern aller Dateien
     * @throws java.io.IOException
     */
    public void saveAllFilesTemporary() throws IOException {
        
        // Finden und Löschen aller .yate-Dateien
        for (java.io.File file : tempDir.listFiles(fileNameFilter)) {
            file.delete();
        }
        
        // ablegen aller Dateien im temporären Verzeichnis
        for (File file : allFiles) {
            java.io.File temp = java.io.File.createTempFile(file.getName()+".", ".yate");
            try (PrintWriter pw = new PrintWriter(temp)) {
                pw.write(file.getContent());
            } catch (IOException e) {
            }
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
            newFile.setSaved(true);
        } catch (IOException e) {
        }
        finally {
            return newFile; //06.12.14 CHS Erstellte Datei zurückgeben
        }
    }
    
    /**
     * lädt die übergebene Datei
     * @param file übergebene Datei
     * @return die erstellte Datei
     */
    public File loadFile(File file) {
        currentFile = file;
        allFiles.add(file);
        
        return file;
    }
    
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
