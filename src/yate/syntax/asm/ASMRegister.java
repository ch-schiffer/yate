/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.asm;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.CaseInsensitiveKeyWordElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 *
 * @author Christian
 */
public class ASMRegister extends KeyWordCollection {

    public ASMRegister() {
        super(LanguageElementType.REGISTER);
    }

    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
            /**
     * Liste der Schlüsselwörter
     */
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new CaseInsensitiveKeyWordElement("EAX"),
            new CaseInsensitiveKeyWordElement("EBX"),
            new CaseInsensitiveKeyWordElement("ECX"),
            new CaseInsensitiveKeyWordElement("EDX"),
            new CaseInsensitiveKeyWordElement("AX"),
            new CaseInsensitiveKeyWordElement("BX"),
            new CaseInsensitiveKeyWordElement("CX"),
            new CaseInsensitiveKeyWordElement("DX"),
            new CaseInsensitiveKeyWordElement("AH"),
            new CaseInsensitiveKeyWordElement("BH"),
            new CaseInsensitiveKeyWordElement("CH"),
            new CaseInsensitiveKeyWordElement("DH"),
            new CaseInsensitiveKeyWordElement("AL"),
            new CaseInsensitiveKeyWordElement("BL"),
            new CaseInsensitiveKeyWordElement("CL"),
            new CaseInsensitiveKeyWordElement("DL"),
            new CaseInsensitiveKeyWordElement("SP"),
            new CaseInsensitiveKeyWordElement("BP"),
            new CaseInsensitiveKeyWordElement("IP"),
            new CaseInsensitiveKeyWordElement("SI"),
            new CaseInsensitiveKeyWordElement("DI"),
            new CaseInsensitiveKeyWordElement("CS"),
            new CaseInsensitiveKeyWordElement("DS"),
            new CaseInsensitiveKeyWordElement("SS"),
            new CaseInsensitiveKeyWordElement("ES")
        ));    
}
