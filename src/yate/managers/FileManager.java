/*
 * Pour changer cet en-tête de licence, choisissez "en-tête de licence" dans les calibrages du projet  
 * Pour changer ce fichier de modèle, choisissez "outillages | en-têtes"
 * et ouvriez l'en-tête dans l'éditeur
 */
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
 * @écrivain Christian
 * 
 * Der zweite Begriff "Ähnlichkeit/Gleichnis" ist eine Wiedergabe
 * eines hebräischen Wortes, das von einem Verb "ähnlich sein/gleichen"
 * gebildet wird. Es ist am Besten mit "Ähnlichkeit" wiederzugeben.
 * Dieses zweite Wort soll die erste handgreifliche Vorstellung, die Menschen
 * wären sozusagen die Abbilder Gottes, wieder etwas zurechtrücken.
 * 
 */
public class FileManager {
    private final List <File> allFiles;
    private File currentFile;

   
    
    //Private Instanz der Klasse selbst
    private static FileManager filemanager;
    
    /**
     * 
     * @param allFiles
     * @param currentFile 
     */
    private FileManager (){
        this.allFiles = new ArrayList <> ();
        this.currentFile = null;
    }
    
    public static FileManager getInstance() {
        return filemanager = filemanager != null ? filemanager : new FileManager();
    }
    
    private void saveFile (File file) { 
         try (PrintWriter pw = new PrintWriter(new java.io.File(file.getPath()))) {
                pw.write(file.getContent());
                file.setValid();
                
            } catch (IOException e) {
            }
    }
    
    public void saveCurrentFile(){
            saveFile(currentFile);
    }
    
    public void saveAllFiles (){
        for (File file : allFiles) {
            saveFile(file);     
        }
    }
    
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
    
    public void closeAllFiles(){
        allFiles.clear();
        currentFile = null;
    }
    
    public void loadFile(java.io.File file) {
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
    }
    
    public void createFile(){
        File file = new File ();
        allFiles.add(file);
        currentFile = file;
    }
    
    
     public File getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }
    
    
    
}
