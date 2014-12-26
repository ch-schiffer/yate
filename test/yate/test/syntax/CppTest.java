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
import yate.syntax.cpp.CPPDataType;
import yate.syntax.cpp.CPPKeyWord;
import yate.syntax.cpp.CppLanguage;
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
 * Testet die Syntaxanalyse der Sprache C++
 * @author Christian
 */
public class CppTest {
    
    /**
     * Testet, ob Datentypen ordungsgemäß erkannt werden
     */
    @Test
    public void testCppDataType() {
        CppLanguage language = new CppLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "bool char char16_t char32_t double float int long short signed "
                + "unsigned void wchar_t int long short";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "bool",0,4),
                new SyntaxToken(null, "char",5,9),
                new SyntaxToken(null, "char16_t",10,18),
                new SyntaxToken(null, "char32_t",19,27),
                new SyntaxToken(null, "double",28,34),
                new SyntaxToken(null, "float",35,40),
                new SyntaxToken(null, "int",41,44),
                new SyntaxToken(null, "long",45,49),
                new SyntaxToken(null, "short",50,55),
                new SyntaxToken(null, "signed",56,62),
                new SyntaxToken(null, "unsigned",63,71),
                new SyntaxToken(null, "void",72,76),
                new SyntaxToken(null, "wchar_t",77,84),
                new SyntaxToken(null, "int",85,88),
                new SyntaxToken(null, "long",89,93),
                new SyntaxToken(null, "short",94,99)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CPPDataType);
        }
    }
    
    /**
     * Testet, ob Schlüsselwörter ordungsgemäß erkannt werden
     */
    @Test
    public void testCppKeyWord() {
        CppLanguage language = new CppLanguage();
        NavigableMap<Integer, SyntaxToken> syntaxMap = new TreeMap<>();
        String inputText = "alignas alignof and and_eq asm auto bitand bitor break "
                + "case catch class compl const constexpr const_cast "
                + "continue decltype default delete do else enum explicit dynamic_cast "
                + "extern false for friend goto if inline mutable namespace new noexcept "
                + "not not_eq nullptr operator or or_eq private protected public register reinterpret_cast "
                + "return sizeof static static_assert static_cast struct switch template this thread_local throw "
                + "true try typedef typeid typename union using virtual volatile while xor xor_eq export";
        language.analyzeSyntax(inputText, syntaxMap, null);
        ArrayList<SyntaxToken> foundTokens = new ArrayList<>(syntaxMap.values());
        
        ArrayList<SyntaxToken> targetTokens = new ArrayList<>(Arrays.asList(
                new SyntaxToken(null, "alignas",0,7),
                new SyntaxToken(null, "alignof",8,15),
                new SyntaxToken(null, "and",16,19),
                new SyntaxToken(null, "and_eq",20,26),
                new SyntaxToken(null, "asm",27,30),
                new SyntaxToken(null, "auto",31,35),
                new SyntaxToken(null, "bitand",36,42),
                new SyntaxToken(null, "bitor",43,48),
                new SyntaxToken(null, "break",49,54),
                new SyntaxToken(null, "case",55,59),
                new SyntaxToken(null, "catch",60,65),
                new SyntaxToken(null, "class",66,71),
                new SyntaxToken(null, "compl",72,77),
                new SyntaxToken(null, "const",78,83),
                new SyntaxToken(null, "constexpr",84,93),
                new SyntaxToken(null, "const_cast",94,104),
                new SyntaxToken(null, "continue",105,113),
                new SyntaxToken(null, "decltype",114,122),
                new SyntaxToken(null, "default",123,130),
                new SyntaxToken(null, "delete",131,137),
                new SyntaxToken(null, "do",138,140),
                new SyntaxToken(null, "else",141,145),
                new SyntaxToken(null, "enum",146,150),
                new SyntaxToken(null, "explicit",151,159),
                new SyntaxToken(null, "dynamic_cast",160,172),
                new SyntaxToken(null, "extern",173,179),
                new SyntaxToken(null, "false",180,185),
                new SyntaxToken(null, "for",186,189),
                new SyntaxToken(null, "friend",190,196),
                new SyntaxToken(null, "goto",197,201),
                new SyntaxToken(null, "if",202,204),
                new SyntaxToken(null, "inline",205,211),
                new SyntaxToken(null, "mutable",212,219),
                new SyntaxToken(null, "namespace",220,229),
                new SyntaxToken(null, "new",230,233),
                new SyntaxToken(null, "noexcept",234,242),
                new SyntaxToken(null, "not",243,246),
                new SyntaxToken(null, "not_eq",247,253),
                new SyntaxToken(null, "nullptr",254,261),
                new SyntaxToken(null, "operator",262,270),
                new SyntaxToken(null, "or",271,273),
                new SyntaxToken(null, "or_eq",274,279),
                new SyntaxToken(null, "private",280,287),
                new SyntaxToken(null, "protected",288,297),
                new SyntaxToken(null, "public",298,304),
                new SyntaxToken(null, "register",305,313),
                new SyntaxToken(null, "reinterpret_cast",314,330),
                new SyntaxToken(null, "return",331,337),
                new SyntaxToken(null, "sizeof",338,344),
                new SyntaxToken(null, "static",345,351),
                new SyntaxToken(null, "static_assert",352,365),
                new SyntaxToken(null, "static_cast",366,377),
                new SyntaxToken(null, "struct",378,384),
                new SyntaxToken(null, "switch",385,391),
                new SyntaxToken(null, "template",392,400),
                new SyntaxToken(null, "this",401,405),
                new SyntaxToken(null, "thread_local",406,418),
                new SyntaxToken(null, "throw",419,424),
                new SyntaxToken(null, "true",425,429),
                new SyntaxToken(null, "try",430,433),
                new SyntaxToken(null, "typedef",434,441),
                new SyntaxToken(null, "typeid",442,448),
                new SyntaxToken(null, "typename",449,457),
                new SyntaxToken(null, "union",458,463),
                new SyntaxToken(null, "using",464,469),
                new SyntaxToken(null, "virtual",470,477),
                new SyntaxToken(null, "volatile",478,486),
                new SyntaxToken(null, "while",487,492),
                new SyntaxToken(null, "xor",493,496),
                new SyntaxToken(null, "xor_eq",497,503),
                new SyntaxToken(null, "export",504,510)
        ));
        
        assertEquals(foundTokens, targetTokens);
        
        for (SyntaxToken targetToken : foundTokens) {
            assertTrue(targetToken.getTokenType() instanceof CPPKeyWord);
        }
    }
    
    
    /**
     * Testet, ob Literale ordungsgemäß erkannt werden
     */
    @Test
    public void testCStyleLiteral() {
        CppLanguage language = new CppLanguage();
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
        CppLanguage language = new CppLanguage();
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
        CppLanguage language = new CppLanguage();
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
        CppLanguage language = new CppLanguage();
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
        CppLanguage language = new CppLanguage();
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
