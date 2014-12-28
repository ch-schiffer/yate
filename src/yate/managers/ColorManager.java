
package yate.managers;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @écrivain Carina
 * 
 * Klasse ColorManager, der für die Farben im Dokument zuständig ist
 * 
 */
public class ColorManager {
    //Map mit den Farben
    private final HashMap <String , Color> colors;
    
    //Private Instanz der Klasse selber
    private static ColorManager colormanager;
    
    /**
     * privater Konstruktor für den ColorManager
     * instanziiert die HashMap der Farben
     */
    private ColorManager(){
        colors = new HashMap<>();
    }
    
    /**
     * Methode, die statt des Konstruktors von außen aufgerufen wird
     * ruft, sofern das private Attribut der Klasse noch nicht instanziiert ist, 
     * den Konstruktor auf
     * @return private Instanz des Colormanagers
     */
    public static ColorManager getInstance() {
        //Instanziieren, wenn interne Instanz noch NULL ist
        if (colormanager == null){
            colormanager = new ColorManager();
        }
        return colormanager;
    }
    
    /**
     * Getter für die Farbe zum übergebenen String keyword
     * @param keyword
     * @return Farbe
     */
    public Color getColor(String keyword){
        if (colors.containsKey(keyword)) {
            return colors.get(keyword);
        }
        else {
            //Standardfarbe
            return Color.BLACK;
        }
    }
    
    /**
     * Setter für eine Farbe in der HashMap
     * @param keyword
     * @param color 
     */
    public void setColor(String keyword, Color color){
        colors.put(keyword, color);
    }
    
    /**
     * Getter für die gesamte HashMap mit allen Farben
     * @return alle Farben
     */
     public HashMap<String, Color> getColors() {
        return colors;
    }
}
