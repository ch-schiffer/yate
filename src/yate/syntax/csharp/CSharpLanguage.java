/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.csharp;

import java.util.ArrayList;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.Language;
import yate.syntax.general.SyntaxToken;

/**
 *
 * @author Christian
 */
public class CSharpLanguage extends Language {

    public CSharpLanguage() {
        super();
        languageName = "CSharp";
    }

    @Override
    protected ArrayList<KeyWordCollection> getKeyWords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void analysisHandler(SyntaxToken token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
