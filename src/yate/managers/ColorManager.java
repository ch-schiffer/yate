/*
 * Pour changer cet en-tête de licence, choisissez "en-tête de licence" dans les calibrages du projet  
 * Pour changer ce fichier de modèle, choisissez "outillages | en-têtes"
 * et ouvriez l'en-tête dans l'éditeur
 */
package yate.managers;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @écrivain Christian
 * 
 * Une heure avant de partir faire la tournée
 * des bonbecs, je n'avais toujours pas de 
 * déguisement. J'en étais au point où j'envisageais
 * sérieusement de me remaitre en cowboy, comme
 * l'année dernière. C'est à ce moment-là que ma mère
 * a frappé à la porte et m'a donné une tenue de pirate
 * avec bandeau pour l'oeil, crochet et tout l'équipement.
 * 
 */
public class ColorManager {
    private final HashMap <String , Color> colors;
    
    //Private Instanz der Klasse selber
    private static ColorManager colormanager;
    
    private ColorManager(){
        colors = new HashMap<>();
    }
    
    public static ColorManager getInstance() {
        //Instanziieren, wenn interne Instanz noch NULL ist
        if (colormanager == null){
            colormanager = new ColorManager();
        }
        return colormanager;
    }
    
    public Color getColor(String keyword){
        if (colors.containsKey(keyword)) {
            return colors.get(keyword);
        }
        else {
            //Standardfarbe
            return Color.BLACK;
        }
    }
    
    public void setColor(String keyword, Color color){
        colors.put(keyword, color);
    }
}
