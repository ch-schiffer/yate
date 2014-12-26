/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.test.syntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;
import yate.syntax.asm.ASMFlags;
import yate.syntax.asm.ASMMnemonic;
import yate.syntax.asm.ASMNumber;
import yate.syntax.asm.ASMRegister;
import yate.syntax.asm.AsmLanguage;
import yate.syntax.cstyle.CStyleLiteral;
import yate.syntax.general.SyntaxToken;

/**
 * Testet die Syntaxanalyse der Sprache Assembler
 * @author Christian
 */
public class ASMTest {
    
    public ASMTest() {
    }
    
    /**
     * Testet, ob alle Flags ordnungsgemäß erkannt werden.
     */
    @Test
    public void testFlags() {
        AsmLanguage language = new AsmLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "CF AF ZF SF PF OF TF IF DF";
        language.analyzeSyntax(inputText, syntaxMap, null);
        
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "CF",  0,  2),
                new SyntaxToken(null, "AF",  3,  5),
                new SyntaxToken(null, "ZF",  6,  8),
                new SyntaxToken(null, "SF",  9, 11),
                new SyntaxToken(null, "PF", 12, 14),
                new SyntaxToken(null, "OF", 15, 17),
                new SyntaxToken(null, "TF", 18, 20),
                new SyntaxToken(null, "IF", 21, 23),
                new SyntaxToken(null, "DF", 24, 26)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof ASMFlags);
        }
    }
    
    /**
     * Testet, ob alle Mnemonics ordnungsgemäß erkannt werden
     */
    @Test
    public void testMnemonics() {
        AsmLanguage language = new AsmLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "AAA AAD AAM AAS ADC ADD AND CALL CBW CLC CLD CLI CMC "
                + "CMP CMPSB CMPSW CWD DAA DAS DEC DIV ESC HLT IDIV IMUL "
                + "IN INC INT INTO IRET Jcc JCXZ JMP LAHF LDS LEA LES LOCK "
                + "LODSB LODSW LOOP MOV MOVSB MOVSW MUL NEG NOP NOT OR OUT "
                + "POP POPF PUSH PUSHF RCL RCR REP RET RETN RETF ROL ROR "
                + "SAHF SAL SAR SBB SCASB SCASW SHL SHR STC STD STI STOSB "
                + "STOSW SUB TEST WAIT XCHG XLAT XOR";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "AAA",0,3),
                new SyntaxToken(null, "AAD",4,7),
                new SyntaxToken(null, "AAM",8,11),
                new SyntaxToken(null, "AAS",12,15),
                new SyntaxToken(null, "ADC",16,19),
                new SyntaxToken(null, "ADD",20,23),
                new SyntaxToken(null, "AND",24,27),
                new SyntaxToken(null, "CALL",28,32),
                new SyntaxToken(null, "CBW",33,36),
                new SyntaxToken(null, "CLC",37,40),
                new SyntaxToken(null, "CLD",41,44),
                new SyntaxToken(null, "CLI",45,48),
                new SyntaxToken(null, "CMC",49,52),
                new SyntaxToken(null, "CMP",53,56),
                new SyntaxToken(null, "CMPSB",57,62),
                new SyntaxToken(null, "CMPSW",63,68),
                new SyntaxToken(null, "CWD",69,72),
                new SyntaxToken(null, "DAA",73,76),
                new SyntaxToken(null, "DAS",77,80),
                new SyntaxToken(null, "DEC",81,84),
                new SyntaxToken(null, "DIV",85,88),
                new SyntaxToken(null, "ESC",89,92),
                new SyntaxToken(null, "HLT",93,96),
                new SyntaxToken(null, "IDIV",97,101),
                new SyntaxToken(null, "IMUL",102,106),
                new SyntaxToken(null, "IN",107,109),
                new SyntaxToken(null, "INC",110,113),
                new SyntaxToken(null, "INT",114,117),
                new SyntaxToken(null, "INTO",118,122),
                new SyntaxToken(null, "IRET",123,127),
                new SyntaxToken(null, "Jcc",128,131),
                new SyntaxToken(null, "JCXZ",132,136),
                new SyntaxToken(null, "JMP",137,140),
                new SyntaxToken(null, "LAHF",141,145),
                new SyntaxToken(null, "LDS",146,149),
                new SyntaxToken(null, "LEA",150,153),
                new SyntaxToken(null, "LES",154,157),
                new SyntaxToken(null, "LOCK",158,162),
                new SyntaxToken(null, "LODSB",163,168),
                new SyntaxToken(null, "LODSW",169,174),
                new SyntaxToken(null, "LOOP",175,179),
                new SyntaxToken(null, "MOV",180,183),
                new SyntaxToken(null, "MOVSB",184,189),
                new SyntaxToken(null, "MOVSW",190,195),
                new SyntaxToken(null, "MUL",196,199),
                new SyntaxToken(null, "NEG",200,203),
                new SyntaxToken(null, "NOP",204,207),
                new SyntaxToken(null, "NOT",208,211),
                new SyntaxToken(null, "OR",212,214),
                new SyntaxToken(null, "OUT",215,218),
                new SyntaxToken(null, "POP",219,222),
                new SyntaxToken(null, "POPF",223,227),
                new SyntaxToken(null, "PUSH",228,232),
                new SyntaxToken(null, "PUSHF",233,238),
                new SyntaxToken(null, "RCL",239,242),
                new SyntaxToken(null, "RCR",243,246),
                new SyntaxToken(null, "REP",247,250),
                new SyntaxToken(null, "RET",251,254),
                new SyntaxToken(null, "RETN",255,259),
                new SyntaxToken(null, "RETF",260,264),
                new SyntaxToken(null, "ROL",265,268),
                new SyntaxToken(null, "ROR",269,272),
                new SyntaxToken(null, "SAHF",273,277),
                new SyntaxToken(null, "SAL",278,281),
                new SyntaxToken(null, "SAR",282,285),
                new SyntaxToken(null, "SBB",286,289),
                new SyntaxToken(null, "SCASB",290,295),
                new SyntaxToken(null, "SCASW",296,301),
                new SyntaxToken(null, "SHL",302,305),
                new SyntaxToken(null, "SHR",306,309),
                new SyntaxToken(null, "STC",310,313),
                new SyntaxToken(null, "STD",314,317),
                new SyntaxToken(null, "STI",318,321),
                new SyntaxToken(null, "STOSB",322,327),
                new SyntaxToken(null, "STOSW",328,333),
                new SyntaxToken(null, "SUB",334,337),
                new SyntaxToken(null, "TEST",338,342),
                new SyntaxToken(null, "WAIT",343,347),
                new SyntaxToken(null, "XCHG",348,352),
                new SyntaxToken(null, "XLAT",353,357),
                new SyntaxToken(null, "XOR",358,361)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof ASMMnemonic);
        }
        
    }
    
    /**
     * Testet, ob Nummern ordungsgemäß erkannt werden
     */
    @Test
    public void testNumber() {
        AsmLanguage language = new AsmLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "0 1 10 100 123456789";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "0",0,1),
                new SyntaxToken(null, "1",2,3),
                new SyntaxToken(null, "10",4,6),
                new SyntaxToken(null, "100",7,10),
                new SyntaxToken(null, "123456789",11,20)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof ASMNumber);
        }
    }
    /**
     * Testet, ob Register ordungsgemäß erkannt werden
     */
    @Test
    public void testRegisters() {
        AsmLanguage language = new AsmLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "EAX EBX ECX EDX AX BX CX DX AH BH CH DH AL BL CL DL SP"
                + "BP IP SI DI CS DS SS ES";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "EAX",0,3),
                new SyntaxToken(null, "EBX",4,7),
                new SyntaxToken(null, "ECX",8,11),
                new SyntaxToken(null, "EDX",12,15),
                new SyntaxToken(null, "AX",16,18),
                new SyntaxToken(null, "BX",19,21),
                new SyntaxToken(null, "CX",22,24),
                new SyntaxToken(null, "DX",25,27),
                new SyntaxToken(null, "AH",28,30),
                new SyntaxToken(null, "BH",31,33),
                new SyntaxToken(null, "CH",34,36),
                new SyntaxToken(null, "DH",37,39),
                new SyntaxToken(null, "AL",40,42),
                new SyntaxToken(null, "BL",43,45),
                new SyntaxToken(null, "CL",46,48),
                new SyntaxToken(null, "DL",49,51),
                new SyntaxToken(null, "IP",57,59),
                new SyntaxToken(null, "SI",60,62),
                new SyntaxToken(null, "DI",63,65),
                new SyntaxToken(null, "CS",66,68),
                new SyntaxToken(null, "DS",69,71),
                new SyntaxToken(null, "SS",72,74),
                new SyntaxToken(null, "ES",75,77)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof ASMRegister);
        }
        
    }
    
    /**
     * Testet, ob Literale ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleLiteral() {
        AsmLanguage language = new AsmLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "\"Hello World\" 'a'";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "\"Hello World\"",0,13),
                new SyntaxToken(null, "'a'",14,17)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CStyleLiteral);
        }
    }
}
