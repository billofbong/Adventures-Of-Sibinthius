/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.awesomecraft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Will Wright
 */
public class AList {
    
    public static ActionListener q1l = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
        Player.loc = 1.1;
    }
    };
    public static ActionListener q1r = new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   Player.loc = 2;
               }
           };
    public static ActionListener q2g = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Player.loc = 3;
        }
    };
    
}
