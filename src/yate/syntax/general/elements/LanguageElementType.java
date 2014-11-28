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
    LITERAL("LITERAL"),
    KEYWORD("Schlüsselwort"),
    OPENBRACER("Klammer"),
    CLOSEBRACER("Klammer"),
    COMMENT("Kommentar"),
    DATATYPE("Datentyp"),
    IDENTIFIER("Bezeichner");
    
    private final String type;
    
    private LanguageElementType(final String type) {
        this.type = type;
    }
}
