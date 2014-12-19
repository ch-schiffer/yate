/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general.elements;

/**
 *
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
    
    private LanguageElementType(final String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return this.name();
    }
    
    
}
