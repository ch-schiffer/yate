/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.managers;

import java.util.ArrayList;
import yate.project.File;
import yate.syntax.asm.AsmLanguage;
import yate.syntax.c.CLanguage;
import yate.syntax.cpp.CppLanguage;
import yate.syntax.csharp.CSharpLanguage;
import yate.syntax.general.Language;
import yate.syntax.java.JavaLanguage;
import yate.syntax.python.PythonLanguage;

/**
 *
 * @author Christian
 */
public class LanguageManager {
    private static final ArrayList<Language> languageList = new ArrayList<>();
    
    static {
        languageList.add(new JavaLanguage());
        languageList.add(new CLanguage());
        languageList.add(new CppLanguage());
        languageList.add(new CSharpLanguage());
        languageList.add(new PythonLanguage());
        languageList.add(new AsmLanguage());        
    }
    
    private LanguageManager() { }
    
    public static ArrayList<Language> getLanguageList() {
        return languageList;
    }
    
    public static Language evaluateLanguage(File file) {
        for (Language language : languageList) {
            if (language.checkSuffix(file.getFileExtension()))
                return language;
        }
        if (languageList.size() > 0) return languageList.get(0);
        return null;
    }    
}
