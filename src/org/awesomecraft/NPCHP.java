/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.awesomecraft;

/**
 *
 * @author Will
 */
public enum NPCHP {
    
    BASICGUARD(3);
    private int HP;
    private NPCHP(int i) {
        HP = i;
    }
    /**
     * Returns the HP.
     * @return HP 
     */
    public int getHP() {
        return HP;
    }
    
}
