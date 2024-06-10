import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Monster extends Character {
    private double attackDamage = 0.01;
    private int hp = 1000;
    public Monster(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Monster spawned");
        xPos = 890/2;
        yPos = 0;
        setFocusable(true);
        normal = ImageIO.read(new File("Images/Melee/Shuriken.png"));
        skill1 = ImageIO.read(new File("Images/Melee/Shuriken Skill.png"));
        skill2 = ImageIO.read(new File("Images/Melee/Shuriken Skill (1).png"));
    }
    @Override
    public void movement() {
        if (xPos >= 890) {
            xDir = -1;
        } else if (xPos <= 0) {
            xDir = 1;
        }
        xPos += xDir * moveSpeed;
        if (yPos >= 455) {
            yDir = -1;
        } else if (yPos <= 0) {
            yDir = 1;
        }
        yPos += yDir * moveSpeed;
        setLocation(xPos, yPos);
        repaint();
    }
    public void attackPlayers(Character playerOne, Character playerTwo) {
        playerOne.hp -= attackDamage;
        playerTwo.hp -= attackDamage;
        animate(skill1, skill2, 4);
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(normal, xPos, yPos, 128, 128, null);
    }
    public double checkHp() {
        if (this.hp <= 0) {
            frame.remove(this);
        }
        return hp;
    }
//    @Override
//    public void keyPressed(KeyEvent e) {handleKeyPressed(e);}
//    @Override
//    public void keyReleased(KeyEvent e) {handleKeyReleased(e);}
//    @Override
//    public void keyTyped(KeyEvent e) {handleKeyTyped(e);}
//    public void handleKeyPressed(KeyEvent key) {}
//    public void handleKeyReleased(KeyEvent key) {}
//    public void handleKeyTyped(KeyEvent e) {}
//    // Implement other methods as needed
//
//}
//
////public class Monster extends Character {
////    private int moveSpeed = 5;
////    private int xPos = 890/2, yPos = 200;
////    private int skillDmg = 50, hp = 1000;
////    private Timer attackTimer;
////    public Monster(JFrame frame) throws IOException {
////        super(frame);
////        System.out.println("Monster spawned");
////        setFocusable(true);
////        normal = ImageIO.read(new File("Images/Melee/Shuriken.png"));
////        skill1 = ImageIO.read(new File("Images/Melee/Shuriken Skill.png"));
////        skill2 = ImageIO.read(new File("Images/Melee/Shuriken Skill (1).png"));
////        animate(normal,normal,4);
////    }
////    public void attack() {
////        animate(skill1, skill2, 4);
////    }
////    public void startAttackTimer() {
////        attackTimer = new Timer(5000, new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                attack();
////            }
////        });
////        attackTimer.start();
////    }
////    public void movement() {
////        if (xPos >= frame.getWidth() - getWidth()) {
////            xDir = -1;
////        } else if (xPos <= 0) {
////            xDir = 1;
////        }
////        xPos += xDir * moveSpeed;
////        if (yPos >= frame.getHeight() - getHeight()) {
////            yDir = -1;
////        } else if (yPos <= 0) {
////            yDir = 1;
////        }
////        yPos += yDir * moveSpeed;
////        setLocation(xPos, yPos);
////        repaint();
////    }
////        public void attackPlayers(Character playerOne, Character playerTwo) {
////        playerOne.hp -= skillDmg;
////        playerTwo.hp -= skillDmg;
////        animate(skill1, skill2, 4);
////    }
////    public int checkHp() {
////        if (this.hp <= 0) {
////            frame.remove(this);
////        }
////        return hp;
//    }
    public void handleKeyPressed(KeyEvent e) {}
    public void handleKeyReleased(KeyEvent e) {}
    public void handleKeyTyped(KeyEvent e) {}
}
