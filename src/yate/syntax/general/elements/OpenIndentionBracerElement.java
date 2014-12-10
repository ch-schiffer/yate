/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general.elements;

import yate.syntax.general.IIndentionBracer;

/**
 *
 * @author Christian
 */
public class OpenIndentionBracerElement extends OpenBracerElement implements IIndentionBracer{

    public OpenIndentionBracerElement(String pattern) {
        super(pattern);
    }
    
}
