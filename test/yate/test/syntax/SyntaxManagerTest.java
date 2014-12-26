/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.test.syntax;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import org.junit.Assert;
import org.junit.Test;
import yate.managers.SyntaxManager;
import yate.project.File;
import yate.syntax.asm.AsmLanguage;
import yate.syntax.c.CLanguage;
import yate.syntax.cpp.CppLanguage;
import yate.syntax.csharp.CSharpLanguage;
import yate.syntax.java.JavaLanguage;
import yate.syntax.python.PythonLanguage;

/**
 *
 * @author Christian
 */
public class SyntaxManagerTest {
    
    @Test
    public void testEvaluateASMLanguage() {
        SyntaxManager syntaxManager;
        //ASM
        File asmFile = new File("test.asm");
        syntaxManager = new SyntaxManager(null, asmFile, null);
        Assert.assertTrue(syntaxManager.getLanguage() instanceof AsmLanguage);
    }
    
    
    @Test
    public void testEvaluateJavaLanguage() {
        SyntaxManager syntaxManager;
        //Java
        File javaFile = new File("test.java");
        syntaxManager = new SyntaxManager(null, javaFile, null);
        Assert.assertTrue(syntaxManager.getLanguage() instanceof JavaLanguage);
    }
    
    @Test
    public void testEvaluatePythonLanguage() {
        SyntaxManager syntaxManager;
        //Python
        File pythonFile = new File("test.py");
        syntaxManager = new SyntaxManager(null, pythonFile, null);
        Assert.assertTrue(syntaxManager.getLanguage() instanceof PythonLanguage);
    }
    
    @Test
    public void testEvaluateCLanguage() {
        SyntaxManager syntaxManager;
        //C
        File cFile = new File("test.c");
        syntaxManager = new SyntaxManager(null, cFile, null);
        Assert.assertTrue(syntaxManager.getLanguage() instanceof CLanguage);
    }
    
    @Test
    public void testEvaluateCppLanguage() {
        SyntaxManager syntaxManager;
        //C++
        File cppFile = new File("test.cpp");
        File cppHeaderFile = new File("test.h");
        File cppTemplateFile = new File("test.t");
        syntaxManager = new SyntaxManager(null, cppFile, null);
        Assert.assertTrue(syntaxManager.getLanguage() instanceof CppLanguage);
        syntaxManager = new SyntaxManager(null, cppHeaderFile, null);
        Assert.assertTrue(syntaxManager.getLanguage() instanceof CppLanguage);
        syntaxManager = new SyntaxManager(null, cppTemplateFile, null);
        Assert.assertTrue(syntaxManager.getLanguage() instanceof CppLanguage);
    }
    
    @Test
    public void testEvaluateCSharpLanguage() {
        SyntaxManager syntaxManager;
        //CSharp
        File cSharpFile = new File("test.cs");
        syntaxManager = new SyntaxManager(null, cSharpFile, null);
        Assert.assertTrue(syntaxManager.getLanguage() instanceof CSharpLanguage);
    }
}
