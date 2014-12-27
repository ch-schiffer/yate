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
import yate.syntax.cstyle.CStyleCloseBracer;
import yate.syntax.cstyle.CStyleCloseIndentionBracer;
import yate.syntax.cstyle.CStyleComment;
import yate.syntax.cstyle.CStyleIdentifier;
import yate.syntax.cstyle.CStyleLiteral;
import yate.syntax.cstyle.CStyleOpenBracer;
import yate.syntax.cstyle.CStyleOpenIndentionBracer;
import yate.syntax.general.SyntaxToken;
import yate.syntax.java.JavaDataType;
import yate.syntax.java.JavaKeyWord;
import yate.syntax.java.JavaLanguage;

/**
 * Testet die Syntaxanalyse der Sprache Java
 * @author Christian
 */
public class JavaTest {
    
    /**
     * Testet, ob Datentypen ordungsgemäß erkannt werden
     */
    @Test
    public void testCSharpDataType() {
        JavaLanguage language = new JavaLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "boolean byte char double float int long short void true "
                + "false String";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "boolean",0,7),
                new SyntaxToken(null, "byte",8,12),
                new SyntaxToken(null, "char",13,17),
                new SyntaxToken(null, "double",18,24),
                new SyntaxToken(null, "float",25,30),
                new SyntaxToken(null, "int",31,34),
                new SyntaxToken(null, "long",35,39),
                new SyntaxToken(null, "short",40,45),
                new SyntaxToken(null, "void",46,50),
                new SyntaxToken(null, "true",51,55),
                new SyntaxToken(null, "false",56,61),
                new SyntaxToken(null, "String",62,68)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof JavaDataType);
        }
    }
    
    /**
     * Testet, ob Schlüsselwörter ordungsgemäß erkannt werden
     */
    @Test
    public void testCSharpKeyWord() {
        JavaLanguage language = new JavaLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "abstract assert break case catch class const continue default "
                + "do else enum extends final for goto if implements import instanceof "
                + "interface native new package private protected public static super switch "
                + "synchronized this throws throw transient try volatile while return";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "abstract",0,8),
                new SyntaxToken(null, "assert",9,15),
                new SyntaxToken(null, "break",16,21),
                new SyntaxToken(null, "case",22,26),
                new SyntaxToken(null, "catch",27,32),
                new SyntaxToken(null, "class",33,38),
                new SyntaxToken(null, "const",39,44),
                new SyntaxToken(null, "continue",45,53),
                new SyntaxToken(null, "default",54,61),
                new SyntaxToken(null, "do",62,64),
                new SyntaxToken(null, "else",65,69),
                new SyntaxToken(null, "enum",70,74),
                new SyntaxToken(null, "extends",75,82),
                new SyntaxToken(null, "final",83,88),
                new SyntaxToken(null, "for",89,92),
                new SyntaxToken(null, "goto",93,97),
                new SyntaxToken(null, "if",98,100),
                new SyntaxToken(null, "implements",101,111),
                new SyntaxToken(null, "import",112,118),
                new SyntaxToken(null, "instanceof",119,129),
                new SyntaxToken(null, "interface",130,139),
                new SyntaxToken(null, "native",140,146),
                new SyntaxToken(null, "new",147,150),
                new SyntaxToken(null, "package",151,158),
                new SyntaxToken(null, "private",159,166),
                new SyntaxToken(null, "protected",167,176),
                new SyntaxToken(null, "public",177,183),
                new SyntaxToken(null, "static",184,190),
                new SyntaxToken(null, "super",191,196),
                new SyntaxToken(null, "switch",197,203),
                new SyntaxToken(null, "synchronized",204,216),
                new SyntaxToken(null, "this",217,221),
                new SyntaxToken(null, "throws",222,228),
                new SyntaxToken(null, "throw",229,234),
                new SyntaxToken(null, "transient",235,244),
                new SyntaxToken(null, "try",245,248),
                new SyntaxToken(null, "volatile",249,257),
                new SyntaxToken(null, "while",258,263),
                new SyntaxToken(null, "return",264,270)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof JavaKeyWord);
        }
    }
    
    /**
     * Testet, ob Literale ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleLiteral() {
        JavaLanguage language = new JavaLanguage();
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
        JavaLanguage language = new JavaLanguage();
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
     * Testet, ob Klammern ordungsgemäß erkannt werden
     */
    @Test
    public void testBracers() {
        JavaLanguage language = new JavaLanguage();
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
        JavaLanguage language = new JavaLanguage();
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
