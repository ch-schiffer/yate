/* * To change this license header, choose License Headers in Project Properties.
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
 * Diese Klasse listet die Mnemonics auf, die in der Sprache Assembler verwendet werden
 * @author Christian
 */
public class ASMMnemonic extends KeyWordCollection {
    
    /**
     * Konstruktor, erzeugt eine Instanz der Klasse
     */
    public ASMMnemonic() {
        super(LanguageElementType.MNEMONIC);
    }
    
    /**
     * Ruft eine Liste der hinterlegten KeyWords ab
     * @return Liste der KeyWords
     */
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    /**
     * Liste der Schlüsselwörter
     */
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new CaseInsensitiveKeyWordElement("AAA"),
            new CaseInsensitiveKeyWordElement("AAD"),
            new CaseInsensitiveKeyWordElement("AAM"),
            new CaseInsensitiveKeyWordElement("AAS"),
            new CaseInsensitiveKeyWordElement("ADC"),
            new CaseInsensitiveKeyWordElement("ADD"),
            new CaseInsensitiveKeyWordElement("AND"),
            new CaseInsensitiveKeyWordElement("CALL"),
            new CaseInsensitiveKeyWordElement("CBW"),
            new CaseInsensitiveKeyWordElement("CLC"),
            new CaseInsensitiveKeyWordElement("CLD"),
            new CaseInsensitiveKeyWordElement("CLI"),
            new CaseInsensitiveKeyWordElement("CMC"),
            new CaseInsensitiveKeyWordElement("CMP"),
            new CaseInsensitiveKeyWordElement("CMPSB"),
            new CaseInsensitiveKeyWordElement("CMPSW"),
            new CaseInsensitiveKeyWordElement("CWD"),
            new CaseInsensitiveKeyWordElement("DAA"),
            new CaseInsensitiveKeyWordElement("DAS"),
            new CaseInsensitiveKeyWordElement("DEC"),
            new CaseInsensitiveKeyWordElement("DIV"),
            new CaseInsensitiveKeyWordElement("ESC"),
            new CaseInsensitiveKeyWordElement("HLT"),
            new CaseInsensitiveKeyWordElement("IDIV"),
            new CaseInsensitiveKeyWordElement("IMUL"),
            new CaseInsensitiveKeyWordElement("IN"),
            new CaseInsensitiveKeyWordElement("INC"),
            new CaseInsensitiveKeyWordElement("INT"),
            new CaseInsensitiveKeyWordElement("INTO"),
            new CaseInsensitiveKeyWordElement("IRET"),
            new CaseInsensitiveKeyWordElement("Jcc"),
            new CaseInsensitiveKeyWordElement("JCXZ"),
            new CaseInsensitiveKeyWordElement("JMP"),
            new CaseInsensitiveKeyWordElement("LAHF"),
            new CaseInsensitiveKeyWordElement("LDS"),
            new CaseInsensitiveKeyWordElement("LEA"),
            new CaseInsensitiveKeyWordElement("LES"),
            new CaseInsensitiveKeyWordElement("LOCK"),
            new CaseInsensitiveKeyWordElement("LODSB"),
            new CaseInsensitiveKeyWordElement("LODSW"),
            new CaseInsensitiveKeyWordElement("LOOP"),
            new CaseInsensitiveKeyWordElement("MOV"),
            new CaseInsensitiveKeyWordElement("MOVSB"),
            new CaseInsensitiveKeyWordElement("MOVSW"),
            new CaseInsensitiveKeyWordElement("MUL"),
            new CaseInsensitiveKeyWordElement("NEG"),
            new CaseInsensitiveKeyWordElement("NOP"),
            new CaseInsensitiveKeyWordElement("NOT"),
            new CaseInsensitiveKeyWordElement("OR"),
            new CaseInsensitiveKeyWordElement("OUT"),
            new CaseInsensitiveKeyWordElement("POP"),
            new CaseInsensitiveKeyWordElement("POPF"),
            new CaseInsensitiveKeyWordElement("PUSH"),
            new CaseInsensitiveKeyWordElement("PUSHF"),
            new CaseInsensitiveKeyWordElement("RCL"),
            new CaseInsensitiveKeyWordElement("RCR"),
            new CaseInsensitiveKeyWordElement("REP"),
            new CaseInsensitiveKeyWordElement("RET"),
            new CaseInsensitiveKeyWordElement("RETN"),
            new CaseInsensitiveKeyWordElement("RETF"),
            new CaseInsensitiveKeyWordElement("ROL"),
            new CaseInsensitiveKeyWordElement("ROR"),
            new CaseInsensitiveKeyWordElement("SAHF"),
            new CaseInsensitiveKeyWordElement("SAL"),
            new CaseInsensitiveKeyWordElement("SAR"),
            new CaseInsensitiveKeyWordElement("SBB"),
            new CaseInsensitiveKeyWordElement("SCASB"),
            new CaseInsensitiveKeyWordElement("SCASW"),
            new CaseInsensitiveKeyWordElement("SHL"),
            new CaseInsensitiveKeyWordElement("SHR"),
            new CaseInsensitiveKeyWordElement("STC"),
            new CaseInsensitiveKeyWordElement("STD"),
            new CaseInsensitiveKeyWordElement("STI"),
            new CaseInsensitiveKeyWordElement("STOSB"),
            new CaseInsensitiveKeyWordElement("STOSW"),
            new CaseInsensitiveKeyWordElement("SUB"),
            new CaseInsensitiveKeyWordElement("TEST"),
            new CaseInsensitiveKeyWordElement("WAIT"),
            new CaseInsensitiveKeyWordElement("XCHG"),
            new CaseInsensitiveKeyWordElement("XLAT"),
            new CaseInsensitiveKeyWordElement("XOR")
    ));
    
}
