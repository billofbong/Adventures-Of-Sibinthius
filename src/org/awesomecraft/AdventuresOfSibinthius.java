package org.awesomecraft;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Will Wright
 */
public class AdventuresOfSibinthius extends JFrame {
    private boolean loop1 = true;
    private boolean loop2 = true;
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
        try {
        Player.loc = Double.valueOf(SaveLoad.load("/Users/Will/Sibinthius.bin").toString());
        System.out.println("Loaded game at location " + Player.loc + ".");
        } catch(Exception ex) {
            System.err.println("Could not load Save: Creating a new one.");
        }
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
        while(true) {
           if(Player.loc == 1) {
           forward.setVisible(false);
           back.setVisible(false);
           left.setText("Do nothing");
           left.addActionListener(AList.q1l);
           right.setText("Pick the lock");
           right.addActionListener(AList.q1r);
           } if(Player.loc == 1.1) {
               nar1.setText("You are still in a dungeon.");
           } if(Player.loc == 2) {
                   nar1.setText("You are now outside");
                   nar2.setText("the door. What now?");
                   if(loop1) {
                   try {
                   SaveLoad.save(Player.loc, "/Users/Will/Sibinthius.bin");
                   System.out.println("Saved game at location " + Player.loc + ".");
                   } catch(Exception ex) {
                       System.err.println("Failed to save game");
                   }
                   loop1 = false;
                   }
                   left.removeActionListener(AList.q1l);
                   right.removeActionListener(AList.q1r);
                   forward.addActionListener(AList.q2g);
                   left.addActionListener(AList.q2g);
                   right.addActionListener(AList.q2g);
                   right.setText(rgt);
                   forward.setText(fwd);
                   back.setText(bck);
                   left.setText(lft);
                   forward.setVisible(true);
           }   if(Player.loc == 3) {
                   if(!loop1) {
                   try {
                   SaveLoad.save(Player.loc, "/Users/Will/Sibinthius.bin");
                   System.out.println("Saved game at location " + Player.loc + ".");
                   } catch(Exception ex) {
                       System.err.println("Failed to save game");
                   }
                   loop1 = true;
                   }
               forward.setVisible(false);
               nar1.setText("You hear a guard.");
               nar2.setText("What do you do now?");
               right.setText("Sneak around him!");
               left.setText("Fight him!");
           }
        }
    }
}
