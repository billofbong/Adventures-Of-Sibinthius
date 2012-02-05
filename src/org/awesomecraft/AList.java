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
    public static ActionListener q3r = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
                Player.loc = 4;
        }
    };
    public static ActionListener q3l = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Player.loc = 4.5;
        }
    };
    public static ActionListener q4r = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(AdventuresOfSibinthius.fight() == 1) {
                npcs.basicGuardHP--;
                AdventuresOfSibinthius.nar1.setText("Successful hit!");
                AdventuresOfSibinthius.nar2.setText("");
            } else {
                AdventuresOfSibinthius.nar1.setText("Unsuccessful hit!");
                AdventuresOfSibinthius.nar2.setText("");
            }
        }
    };
    public static ActionListener q4l = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Player.loc = 4.5;
        }
    };
    public static NPCs npcs;
        }
    
