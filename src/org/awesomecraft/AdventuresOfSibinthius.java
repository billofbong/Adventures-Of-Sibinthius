/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.awesomecraft;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Will Wright
 */
public class AdventuresOfSibinthius extends JFrame {
    private boolean shouldLoop = true;
    private Random gen = new Random();
    private int fight = gen.nextInt(1);
    private int sneak = gen.nextInt(1);
    private String fwd = "Go forward";
    private String rgt = "Go right";
    private String lft = "Go left";
    private String bck = "Go back";
    JButton forward = new JButton("Go Forward");
    JButton back = new JButton("Go Back");
    JButton left = new JButton("Go Left");
    JButton right = new JButton("Go Right");
    JLabel nar1 = new JLabel("You wake up in a dungeon.");
    JLabel nar2 = new JLabel("What do you do?");
    public AdventuresOfSibinthius() {
        forward.setVisible(false);
        back.setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(nar1);
        add(nar2);
        add(forward);
        add(left);
        add(right);
        add(back);
        setSize(205, 170);
        setVisible(true);
        while(shouldLoop) {
           if(Player.loc == 1) {
           left.setText("Do nothing");
           left.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
               nar1.setText("You are still in a dungeon.");
           }
           });
           right.setText("Pick the lock");
           right.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   Player.loc = 2;
               }
           });
           } if(Player.loc == 2) {
                   nar1.setText("You are now outside");
                   nar2.setText("the door. What now?");
                   forward.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           nar1.setText("You hear a guard.");
                           nar2.setText("What do you do now?");
                           Player.loc = 3;
           }
                   });
                   left.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           nar1.setText("You hear a guard.");
                           nar2.setText("What do you do now?");
                           Player.loc = 3;
                       }
                   });
                   right.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           nar1.setText("You hear a guard.");
                           nar2.setText("What do you do now?");
                           Player.loc = 3;
                       }
                   });
                   right.setText(rgt);
                   forward.setText(fwd);
                   back.setText(bck);
                   left.setText(lft);
                   forward.setVisible(true);
           } if(Player.loc == 3) {
               forward.setVisible(false);
               right.setText("Sneak around him!");
               left.setText("Fight him!");
           }
        }
    }
}
