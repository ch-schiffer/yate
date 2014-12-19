/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.asm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import yate.syntax.cstyle.CStyleLiteral;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.Language;
import yate.syntax.general.SyntaxToken;
import yate.syntax.general.elements.LanguageElementType;

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

    private HashMap<String, Color> defaultColors = null;
    
    @Override
    public HashMap<String, Color> getDefaultColors() {
        if (defaultColors != null) return defaultColors;
        defaultColors = new HashMap<>();
        defaultColors.put(getLanguageName()+LanguageElementType.MNEMONIC.getDisplayName(), Color.PINK);
        defaultColors.put(getLanguageName()+LanguageElementType.REGISTER.getDisplayName(), Color.BLUE);
        defaultColors.put(getLanguageName()+LanguageElementType.FLAG.getDisplayName(), Color.ORANGE);
        defaultColors.put(getLanguageName()+LanguageElementType.NUMBER.getDisplayName(), Color.green);
        defaultColors.put(getLanguageName()+LanguageElementType.LITERAL.getDisplayName(), Color.RED);
        return defaultColors;
    }    
}
