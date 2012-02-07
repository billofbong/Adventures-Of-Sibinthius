/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.awesomecraft;

/**
 *
 * @author Will
 */
public enum Weapons {
    
    FISTS(1);
    
    private int damage;
    
    private Weapons(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
}
