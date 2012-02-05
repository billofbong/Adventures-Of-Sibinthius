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
    private static final Random gen = new Random();
    public static int fight() {
        return gen.nextInt(1);
    }
    public static int sneak() {
        return gen.nextInt(1);
    }
    private String fwd = "Go forward";
    private String rgt = "Go right";
    private String lft = "Go left";
    private String bck = "Go back";
    JButton forward = new JButton("Go Forward");
    JButton back = new JButton("Go Back");
    JButton left = new JButton("Go Left");
    JButton right = new JButton("Go Right");
    static JLabel nar1 = new JLabel("You wake up in a dungeon.");
    static JLabel nar2 = new JLabel("What do you do?");
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
               left.setText("Fight him!");
               if(loop2) {
                   forward.removeActionListener(AList.q2g);
                   left.removeActionListener(AList.q2g);
                   right.removeActionListener(AList.q2g);
                   right.addActionListener(AList.q3r);
                   left.addActionListener(AList.q3l);
                   loop2 = false;
               }
               if(Player.loc == 4) {
                   nar1.setText("You sneak past the guard and");
                   nar2.setText("through the door. What now?");
               } if(Player.loc == 4.5) {
                   nar1.setText("You show yourself!.");
                   nar2.setText("You must now fight the guard!");
                   if(!loop2) {
                   left.removeActionListener(AList.q3r);
                   right.removeActionListener(AList.q3l);
                   left.addActionListener(AList.q4l);
                   right.addActionListener(AList.q4r);
                   left.setText("Stab");
                   right.setText("Slash");
                   }
               }
           }
        }
    }
}
