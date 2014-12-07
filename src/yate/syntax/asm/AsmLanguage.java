/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.asm;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.cstyle.CStyleLiteral;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.Language;
import yate.syntax.general.SyntaxToken;

/**
 *
 * @author Christian
 */
public class AsmLanguage extends Language{

    public AsmLanguage() {
        super("Assembler");
        languageSuffixList.add(".asm");
    }

    @Override
    protected ArrayList<KeyWordCollection> getKeyWords() {
        return keyWords;
    }
    

    @Override
    protected void analysisHandler(SyntaxToken token) {
        //ASM implementiert keine weitere Logik
    }
    
     /**
     * Geordnete (!!!) Liste der verschiedenen Schlüsselwortarten
     */
    private static final ArrayList<KeyWordCollection> keyWords = new ArrayList<>(Arrays.asList(
            new ASMMnemonic(),
            new ASMRegister(),
            new ASMFlags(),
            new ASMNumber(),
            new CStyleLiteral()
    ));    
}
