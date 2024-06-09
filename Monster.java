import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Monster extends Character {
//    private int moveSpeed = 5;
    private int xPos = 890/2, yPos = 200;
    private int skillDmg = 50, hp = 1000;
    private Timer attackTimer;
    public Monster(JFrame frame) throws IOException {
        super(frame);
        this.frame = frame;
        this.frame.requestFocusInWindow();
        setOpaque(false);
        setLayout(null);
        setSize(frame.getWidth(), frame.getHeight());
        setLocation(xPos, yPos);
        System.out.println(frame.getWidth());
        System.out.println(frame.getHeight());
        setVisible(true);
        normal = ImageIO.read(new File("Images/Melee/Shuriken.png"));
        skill1 = ImageIO.read(new File("Images/Melee/Shuriken Skill.png"));
        skill2 = ImageIO.read(new File("Images/Melee/Shuriken Skill (1).png"));
        animate(normal,normal,4);
        attackTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attack();
                attackTimer.stop();
            }
        });
    }
    public void attack() {
        skill = true;
        dmg = skillDmg;
        skillSet(12);
        startCD();
        delayFromSkill(normal, normal, 2000,1);

    }
    public void startAttackTimer() {
        attackTimer.start();
    }
//    public void path() {
//        if (xPos >= frame.getWidth() - getWidth()) {
//            xDir = -1;
//        } else if (xPos <= 0) {
//            xDir = 1;
//        }
//        xPos += xDir * moveSpeed;
//        if (yPos >= frame.getHeight() - getHeight()) {
//            yDir = -1;
//        } else if (yPos <= 0) {
//            yDir = 1;
//        }
//        yPos += yDir * moveSpeed;
//        setLocation(xPos, yPos);
//        repaint();
//    }
    public void dmgTaken(Character other, int dmgTaken) {
        Timer checkCollision = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTouching(other)) {
                    hp -= dmgTaken;
                }
            }
        });
        checkCollision.start();
    }
    public void handleKeyPressed(KeyEvent e) {}
    public void handleKeyReleased(KeyEvent e) {}
    public void handleKeyTyped(KeyEvent e) {}
}
