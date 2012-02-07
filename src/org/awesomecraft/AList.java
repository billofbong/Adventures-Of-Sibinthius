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
    public static ActionListener restart = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Player.loc = 1;
            
        }
    };
    public static ActionListener q4g = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(AdventuresOfSibinthius.getRandom().nextInt(2) == 1) {
                AdventuresOfSibinthius.nar2.setText("That was a successful hit!");
                q4BG--;
                AdventuresOfSibinthius.HPleft.setText(new String().valueOf(q4BG) + " hits to go!");
                    if(q4BG == 0) {
                    Player.loc = 5;
                }
            } else {
                AdventuresOfSibinthius.nar2.setText("That was an unsuccessful hit!");
            }
        }
    };
    public static int q4BG = NPCHP.BASICGUARD.getHP();
        }
    
