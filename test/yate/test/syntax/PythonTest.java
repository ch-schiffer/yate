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
import yate.syntax.cstyle.CStyleIdentifier;
import yate.syntax.cstyle.CStyleLiteral;
import yate.syntax.cstyle.CStyleOpenBracer;
import yate.syntax.general.SyntaxToken;
import yate.syntax.python.PythonComment;
import yate.syntax.python.PythonKeyWord;
import yate.syntax.python.PythonLanguage;

/**
 * Testet die Syntaxanalyse der Sprache Python
 * @author Christian
 */
public class PythonTest {
    
    /**
     * Testet, ob Schlüsselwörter ordungsgemäß erkannt werden
     */
    @Test
    public void testPythonKeyWord() {
        PythonLanguage language = new PythonLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "del elif else except exec finally for from global if "
                + "import in is lambda and as assert break class continue "
                + "def not or pass print raise return try while with yield";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "del",0,3),
                new SyntaxToken(null, "elif",4,8),
                new SyntaxToken(null, "else",9,13),
                new SyntaxToken(null, "except",14,20),
                new SyntaxToken(null, "exec",21,25),
                new SyntaxToken(null, "finally",26,33),
                new SyntaxToken(null, "for",34,37),
                new SyntaxToken(null, "from",38,42),
                new SyntaxToken(null, "global",43,49),
                new SyntaxToken(null, "if",50,52),
                new SyntaxToken(null, "import",53,59),
                new SyntaxToken(null, "in",60,62),
                new SyntaxToken(null, "is",63,65),
                new SyntaxToken(null, "lambda",66,72),
                new SyntaxToken(null, "and",73,76),
                new SyntaxToken(null, "as",77,79),
                new SyntaxToken(null, "assert",80,86),
                new SyntaxToken(null, "break",87,92),
                new SyntaxToken(null, "class",93,98),
                new SyntaxToken(null, "continue",99,107),
                new SyntaxToken(null, "def",108,111),
                new SyntaxToken(null, "not",112,115),
                new SyntaxToken(null, "or",116,118),
                new SyntaxToken(null, "pass",119,123),
                new SyntaxToken(null, "print",124,129),
                new SyntaxToken(null, "raise",130,135),
                new SyntaxToken(null, "return",136,142),
                new SyntaxToken(null, "try",143,146),
                new SyntaxToken(null, "while",147,152),
                new SyntaxToken(null, "with",153,157),
                new SyntaxToken(null, "yield",158,163)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof PythonKeyWord);
        }
    }
    
    /**
     * Testet, ob Klammern ordungsgemäß erkannt werden
     */
    @Test
    public void testPythonComment() {
        PythonLanguage language = new PythonLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "#Dies ist ein Kommentar\n\"\"\"Dies ist ein\nmehrzeiliger\nKommentar\"\"\"";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "#Dies ist ein Kommentar",0,23),
                new SyntaxToken(null, "\"\"\"Dies ist ein\nmehrzeiliger\nKommentar\"\"\"" ,24,65)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof PythonComment);
        }
    }
    
    /**
     * Testet, ob Literale ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleLiteral() {
        PythonLanguage language = new PythonLanguage();
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
     * Testet, ob Klammern ordungsgemäß erkannt werden
     */
    @Test
    public void testBracers() {
        PythonLanguage language = new PythonLanguage();
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
        assertTrue(foundTokens.get(4).getTokenType() instanceof CStyleOpenBracer);
        assertTrue(foundTokens.get(5).getTokenType() instanceof CStyleCloseBracer);
    }
    
    /**
     * Testet, ob Identifer ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleIdentifier() {
        PythonLanguage language = new PythonLanguage();
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
