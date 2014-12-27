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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import yate.syntax.c.CDataType;
import yate.syntax.c.CKeyWord;
import yate.syntax.c.CLanguage;
import yate.syntax.cstyle.CStyleCloseBracer;
import yate.syntax.cstyle.CStyleCloseIndentionBracer;
import yate.syntax.cstyle.CStyleComment;
import yate.syntax.cstyle.CStyleIdentifier;
import yate.syntax.cstyle.CStyleLiteral;
import yate.syntax.cstyle.CStyleOpenBracer;
import yate.syntax.cstyle.CStyleOpenIndentionBracer;
import yate.syntax.cstyle.CStylePreProcessorDirective;
import yate.syntax.general.SyntaxToken;

/**
 * Testet die Syntaxanalyse der Sprache C
 * @author Christian
 */
public class CTest {
    
    /**
     * Testet, ob Datentypen ordungsgemäß erkannt werden
     */
    @Test
    public void testDataType() {
        CLanguage language = new CLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "byte char signed unsigned double float int long short void";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "byte",0,4),
                new SyntaxToken(null, "char",5,9),
                new SyntaxToken(null, "signed",10,16),
                new SyntaxToken(null, "unsigned",17,25),
                new SyntaxToken(null, "double",26,32),
                new SyntaxToken(null, "float",33,38),
                new SyntaxToken(null, "int",39,42),
                new SyntaxToken(null, "long",43,47),
                new SyntaxToken(null, "short",48,53),
                new SyntaxToken(null, "void",54,58)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CDataType);
        }
    }
    
    /**
     * Testet, ob Schlüsselwörter ordungsgemäß erkannt werden
     */
    @Test
    public void testCKeyWord() {
        CLanguage language = new CLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "auto break case const continue default do else "
                + "enum extern for goto if register return "
                + "sizeof static struct switch typedef union volatile while";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "auto",0,4),
                new SyntaxToken(null, "break",5,10),
                new SyntaxToken(null, "case",11,15),
                new SyntaxToken(null, "const",16,21),
                new SyntaxToken(null, "continue",22,30),
                new SyntaxToken(null, "default",31,38),
                new SyntaxToken(null, "do",39,41),
                new SyntaxToken(null, "else",42,46),
                new SyntaxToken(null, "enum",47,51),
                new SyntaxToken(null, "extern",52,58),
                new SyntaxToken(null, "for",59,62),
                new SyntaxToken(null, "goto",63,67),
                new SyntaxToken(null, "if",68,70),
                new SyntaxToken(null, "register",71,79),
                new SyntaxToken(null, "return",80,86),
                new SyntaxToken(null, "sizeof",87,93),
                new SyntaxToken(null, "static",94,100),
                new SyntaxToken(null, "struct",101,107),
                new SyntaxToken(null, "switch",108,114),
                new SyntaxToken(null, "typedef",115,122),
                new SyntaxToken(null, "union",123,128),
                new SyntaxToken(null, "volatile",129,137),
                new SyntaxToken(null, "while",138,143)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CKeyWord);
        }
    }
    
    
    /**
     * Testet, ob Literale ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleLiteral() {
        CLanguage language = new CLanguage();
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
    
    /**
     * Testet, ob Kommentare ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleComment() {
        CLanguage language = new CLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "//Hallo Welt\n/*Dies ist ein\n mehrzeiliger Kommentar*/";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "//Hallo Welt",0,12),
                new SyntaxToken(null, "/*Dies ist ein\n mehrzeiliger Kommentar*/",13,53)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CStyleComment);
        }
    }
    
    /**
     * Testet, ob Präprozessordirektiven ordungsgemäß erkannt werden
     */
    @Test
    public void testCStylePreprocessorDirective() {
        CLanguage language = new CLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "#pragma\n#include <iostream>";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "#pragma",0,7),
                new SyntaxToken(null, "#include <iostream>",8,27)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CStylePreProcessorDirective);
        }
    }
    
    /**
     * Testet, ob Klammern ordungsgemäß erkannt werden
     */
    @Test
    public void testBracers() {
        CLanguage language = new CLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "( ) [ ] { }";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "(",0,1),
                new SyntaxToken(null, ")",2,3),
                new SyntaxToken(null, "[",4,5),
                new SyntaxToken(null, "]",6,7),
                new SyntaxToken(null, "{",8,9),
                new SyntaxToken(null, "}",10,11)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        assertTrue(foundTokens.get(0).getTokenType() instanceof CStyleOpenBracer);
        assertTrue(foundTokens.get(1).getTokenType() instanceof CStyleCloseBracer);
        assertTrue(foundTokens.get(2).getTokenType() instanceof CStyleOpenBracer);
        assertTrue(foundTokens.get(3).getTokenType() instanceof CStyleCloseBracer);
        assertTrue(foundTokens.get(4).getTokenType() instanceof CStyleOpenIndentionBracer);
        assertTrue(foundTokens.get(5).getTokenType() instanceof CStyleCloseIndentionBracer);
    }
    
    /**
     * Testet, ob Identifer ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleIdentifier() {
        CLanguage language = new CLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "abs hello world funtionName Test";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "abs",0,3),
                new SyntaxToken(null, "hello",4,9),
                new SyntaxToken(null, "world",10,15),
                new SyntaxToken(null, "funtionName",16,27),
                new SyntaxToken(null, "Test",28,32)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CStyleIdentifier);
        }
    }
}
