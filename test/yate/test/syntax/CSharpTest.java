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
import yate.syntax.csharp.CSharpDataType;
import yate.syntax.csharp.CSharpKeyWord;
import yate.syntax.csharp.CSharpLanguage;
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
 * Testet die Syntaxanalyse der Sprache C#
 * @author Christian
 */
public class CSharpTest {
    
    /**
     * Testet, ob Datentypen ordungsgemäß erkannt werden
     */
    @Test
    public void testCSharpDataType() {
        CSharpLanguage language = new CSharpLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "bool byte char decimal double float int long sbyte short "
                + "string uint ulong ushort void uint ulong ushort";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "bool",0,4),
                new SyntaxToken(null, "byte",5,9),
                new SyntaxToken(null, "char",10,14),
                new SyntaxToken(null, "decimal",15,22),
                new SyntaxToken(null, "double",23,29),
                new SyntaxToken(null, "float",30,35),
                new SyntaxToken(null, "int",36,39),
                new SyntaxToken(null, "long",40,44),
                new SyntaxToken(null, "sbyte",45,50),
                new SyntaxToken(null, "short",51,56),
                new SyntaxToken(null, "string",57,63),
                new SyntaxToken(null, "uint",64,68),
                new SyntaxToken(null, "ulong",69,74),
                new SyntaxToken(null, "ushort",75,81),
                new SyntaxToken(null, "void",82,86),
                new SyntaxToken(null, "uint",87,91),
                new SyntaxToken(null, "ulong",92,97),
                new SyntaxToken(null, "ushort",98,104)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CSharpDataType);
        }
    }
    
    /**
     * Testet, ob Schlüsselwörter ordungsgemäß erkannt werden
     */
    @Test
    public void testCSharpKeyWord() {
        CSharpLanguage language = new CSharpLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "abstract as base break case catch checked class const "
                + "continue default delegate do else enum event explicit "
                + "extern false finally fixed for foreach goto if implicit in "
                + "interface internal is lock namespace new null object operator out "
                + "override params private protected public readonly ref return sealed "
                + "sizeof stackalloc static struct switch this throw typeof true try unchecked "
                + "unsafe using virtual volatile while unchecked unsafe using virtual volatile while";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "abstract",0,8),
                new SyntaxToken(null, "as",9,11),
                new SyntaxToken(null, "base",12,16),
                new SyntaxToken(null, "break",17,22),
                new SyntaxToken(null, "case",23,27),
                new SyntaxToken(null, "catch",28,33),
                new SyntaxToken(null, "checked",34,41),
                new SyntaxToken(null, "class",42,47),
                new SyntaxToken(null, "const",48,53),
                new SyntaxToken(null, "continue",54,62),
                new SyntaxToken(null, "default",63,70),
                new SyntaxToken(null, "delegate",71,79),
                new SyntaxToken(null, "do",80,82),
                new SyntaxToken(null, "else",83,87),
                new SyntaxToken(null, "enum",88,92),
                new SyntaxToken(null, "event",93,98),
                new SyntaxToken(null, "explicit",99,107),
                new SyntaxToken(null, "extern",108,114),
                new SyntaxToken(null, "false",115,120),
                new SyntaxToken(null, "finally",121,128),
                new SyntaxToken(null, "fixed",129,134),
                new SyntaxToken(null, "for",135,138),
                new SyntaxToken(null, "foreach",139,146),
                new SyntaxToken(null, "goto",147,151),
                new SyntaxToken(null, "if",152,154),
                new SyntaxToken(null, "implicit",155,163),
                new SyntaxToken(null, "in",164,166),
                new SyntaxToken(null, "interface",167,176),
                new SyntaxToken(null, "internal",177,185),
                new SyntaxToken(null, "is",186,188),
                new SyntaxToken(null, "lock",189,193),
                new SyntaxToken(null, "namespace",194,203),
                new SyntaxToken(null, "new",204,207),
                new SyntaxToken(null, "null",208,212),
                new SyntaxToken(null, "object",213,219),
                new SyntaxToken(null, "operator",220,228),
                new SyntaxToken(null, "out",229,232),
                new SyntaxToken(null, "override",233,241),
                new SyntaxToken(null, "params",242,248),
                new SyntaxToken(null, "private",249,256),
                new SyntaxToken(null, "protected",257,266),
                new SyntaxToken(null, "public",267,273),
                new SyntaxToken(null, "readonly",274,282),
                new SyntaxToken(null, "ref",283,286),
                new SyntaxToken(null, "return",287,293),
                new SyntaxToken(null, "sealed",294,300),
                new SyntaxToken(null, "sizeof",301,307),
                new SyntaxToken(null, "stackalloc",308,318),
                new SyntaxToken(null, "static",319,325),
                new SyntaxToken(null, "struct",326,332),
                new SyntaxToken(null, "switch",333,339),
                new SyntaxToken(null, "this",340,344),
                new SyntaxToken(null, "throw",345,350),
                new SyntaxToken(null, "typeof",351,357),
                new SyntaxToken(null, "true",358,362),
                new SyntaxToken(null, "try",363,366),
                new SyntaxToken(null, "unchecked",367,376),
                new SyntaxToken(null, "unsafe",377,383),
                new SyntaxToken(null, "using",384,389),
                new SyntaxToken(null, "virtual",390,397),
                new SyntaxToken(null, "volatile",398,406),
                new SyntaxToken(null, "while",407,412),
                new SyntaxToken(null, "unchecked",413,422),
                new SyntaxToken(null, "unsafe",423,429),
                new SyntaxToken(null, "using",430,435),
                new SyntaxToken(null, "virtual",436,443),
                new SyntaxToken(null, "volatile",444,452),
                new SyntaxToken(null, "while",453,458)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CSharpKeyWord);
        }
    }
    
    /**
     * Testet, ob Literale ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleLiteral() {
        CSharpLanguage language = new CSharpLanguage();
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
        CSharpLanguage language = new CSharpLanguage();
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
        CSharpLanguage language = new CSharpLanguage();
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
        CSharpLanguage language = new CSharpLanguage();
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
        CSharpLanguage language = new CSharpLanguage();
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
