package org.awesomecraft;

import java.awt.FlowLayout;
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
    private static Random gen = new Random();
    public static Random getRandom() {
        return gen;
    }
    private String fwd = "Go forward";
    private String rgt = "Go right";
    private String lft = "Go left";
    private String bck = "Go back";
    JButton forward = new JButton("Go Forward");
    JButton back = new JButton("Go Back");
    JButton left = new JButton("Go Left");
    JButton right = new JButton("Go Right");
    public static JLabel nar1 = new JLabel("You wake up in a dungeon.");
    public static JLabel nar2 = new JLabel("What do you do?");
    public static JLabel HPleft = new JLabel();
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
        add(HPleft);
        setSize(205, 170);
        setVisible(true);
        while(true) {
           if(Player.loc == 1) {
           HPleft.setVisible(false);
           right.setVisible(true);
           left.setVisible(true);
           forward.setVisible(false);
           back.setVisible(false);
           nar1.setText("You wake up in a dungeon.");
           nar2.setText("What do you do?");
           left.setText("Do nothing");
           right.setText("Pick the lock");
           if(loop2) {
           left.addActionListener(AList.q1l);
           right.addActionListener(AList.q1r);
           loop2 = false;
           }
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
                   } if(!loop2) {
                   left.removeActionListener(AList.q1l);
                   right.removeActionListener(AList.q1r);
                   forward.addActionListener(AList.q2g);
                   left.addActionListener(AList.q2g);
                   right.addActionListener(AList.q2g);
                   loop2 = true;
                   }
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
               back.setVisible(false);
               nar1.setText("You hear a guard.");
               nar2.setText("What do you do now?");
               right.setText("Sneak around him!");
               left.setText("Scream 'I am a walrus'!");
               if(loop2) {
                   forward.removeActionListener(AList.q2g);
                   left.removeActionListener(AList.q2g);
                   right.removeActionListener(AList.q2g);
                   right.addActionListener(AList.q3r);
                   left.addActionListener(AList.q3l);
                   loop2 = false;
               }
           } 
               if(Player.loc == 4) {
                   nar1.setText("You sneak past the guard and");
                   nar2.setText("through the door. What now?");
               } if(Player.loc == 4.5) {
                   right.setText("Slash");
                   left.setText("Stab");
                   HPleft.setVisible(true);
                   right.setVisible(true);
                   if(!loop2) {
                   HPleft.setText("3 hits to go!");
                   nar1.setText("You show yourself!");
                   nar2.setText("You must now fight him!");
                   left.removeActionListener(AList.q3l);
                   right.removeActionListener(AList.q3r);
                   left.addActionListener(AList.q4g);
                   right.addActionListener(AList.q4g);
                   loop2 = true;
                   } 
               } if(Player.loc == 5) {
                   if(loop2) {
                   left.removeActionListener(AList.q4g);
                   right.removeActionListener(AList.q4g);
                   }
                   nar1.setText("You killed the guard.");
                   nar2.setText("You are outside. What now?");
               }
        }
    }
}
