/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.general.elements;

/**
 * Dieses Enum listet alle möglichen Typen auf, die ein SyntaxElement annehmen kann
 * @author Christian
 */
public enum LanguageElementType {
    LITERAL("Literal"),
    KEYWORD("Schlüsselwort"),
    OPENBRACER("Klammer"),
    CLOSEBRACER("Klammer"),
    OPENINDBRACER("Klammer"),
    CLOSEINDBRACER("Klammer"),
    COMMENT("Kommentar"),
    DATATYPE("Datentyp"),
    IDENTIFIER("Bezeichner"),
    REGISTER("Register"),
    FLAG("Flag"),
    MNEMONIC("Menmonic"),
    NUMBER("Zahl"),
    PREPROCESSOR("Präprozessor");
    
    private final String displayName;
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    private LanguageElementType(final String displayName) {
        this.displayName = displayName;
    }
    
    /**
     * Ruft den Anzeigenamen des Typs ab
     * @return Anzeigename des Typs
     */
    public String getDisplayName() {
        return displayName;
    }
    
    /**
     * Ruft die String-Präsentation des Element-Typs ab
     * @return String-Repräsentation
     */
    @Override
    public String toString() {
        return this.name();
    }
    
    
}
