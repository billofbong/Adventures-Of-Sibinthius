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
    /**
     * Determines the damage done by the player
     */
    public static int damage = 1;
    private boolean loop1 = true;
    private boolean loop2 = true;
    private static Random gen = new Random();
    /**
     * Returns a random for use in other classes
     * @return a random 
     */
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
    public static JLabel nar3 = new JLabel();
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
        add(nar3);
        setSize(205, 170);
        setVisible(true);
        while(true) {
           if(Player.loc == 1) {
           nar3.setVisible(false);
           right.setVisible(true);
           left.setVisible(true);
           forward.setVisible(false);
           back.setVisible(false);
           nar1.setText("You wake up in a dungeon.");
           nar2.setText("What do you do?");
           left.setText("Do nothing");
           right.setText("Pick the lock");
           if(loop2) {
           left.removeActionListener(AList.q6f);
           left.addActionListener(AList.q1l);
           right.addActionListener(AList.q1r);
           left.removeActionListener(AList.restart);
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
                   nar3.setVisible(true);
                   right.setVisible(true);
                   if(!loop2) {
                   nar3.setText("3 hits to go!");
                   nar1.setText("You show yourself!");
                   nar2.setText("You must now fight him!");
                   left.removeActionListener(AList.q3l);
                   right.removeActionListener(AList.q3r);
                   left.addActionListener(AList.q4g);
                   right.addActionListener(AList.q4g);
                   loop2 = true;
                   } 
               } if(Player.loc == 5) {
                   if(loop1) {
                       try {
                   SaveLoad.save(Player.loc, "/Users/Will/Sibinthius.bin");
                   System.out.println("Saved game at location " + Player.loc + ".");
                   } catch(Exception ex) {
                       System.err.println("Failed to save game");
                   }
                   loop1 = false;
                   }
                   if(loop2) {
                   left.removeActionListener(AList.q4g);
                   right.removeActionListener(AList.q4g);
                   left.setVisible(false);
                   forward.setVisible(false);
                   back.setVisible(false);
                   right.setText("Continue");
                   right.addActionListener(AList.q5r);
                   loop2 = false;
                   }
                   nar1.setText("You killed the guard and");
                   nar2.setText("picked up an iron dagger!");
                   nar3.setText("Iron Dagger damage: 3");
               } if(Player.loc == 6) {
                   nar1.setText("You are in a city.");
                   nar2.setText("What do you do?");
                   forward.setVisible(true);
                   right.setVisible(true);
                   left.setVisible(true);
                   right.setText("Talk to someone");
                   left.setText("Find some food");
                   forward.setText("Kill someone");
                   nar3.setVisible(false);
                   if(!loop2) {
                       right.removeActionListener(AList.q5r);
                       forward.addActionListener(AList.q6f);
                   }
               } if(Player.loc == 7) {
                   forward.setVisible(false);
                   right.setVisible(false);
                   left.setText("Continue");
                   nar1.setText("You try to kill someone.");
                   nar2.setText("The guards arrest you.");
                   if(loop2) {
                   loop2 = false;
                   }
                   if(!loop2) {
                   left.addActionListener(AList.restart); 
                   loop2 = true;   
                   }
               }
        }
    }
}
