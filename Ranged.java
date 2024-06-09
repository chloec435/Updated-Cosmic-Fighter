import javax.imageio.ImageIO;
import javax.swing.*;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Ranged extends Character {
    private int code;
    private int normalDmg = 15, skillDmg = 40;
//    private Image ranged1;
//    private Image ranged2;
//    private Image currentImage;
//    private Timer animation;
//    private boolean switchImage = false;
    public Ranged(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Ranged spawned");
        addKeyListener(this);
        setFocusable(true);
        normal = ImageIO.read(new File("Images/Ranged/Ranged.png"));
        attack1 = ImageIO.read(new File("Images/Ranged/Ranged.png"));
        attack2 = ImageIO.read(new File("Images/Ranged/Ranged (1).png"));
        skill1 = ImageIO.read(new File("Images/Ranged/Ranged AOE.png"));
        skill2 = ImageIO.read(new File("Images/Ranged/Ranged AOE (1).png"));
        animate(normal, normal, 1);
//        currentImage = ranged1;
//        setSize(frame.getWidth(), frame.getHeight());
//        setLocation((int) xPos, (int) yPos);
//        setVisible(true);
//        animation = new Timer(1000/2, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switchImage = !switchImage;
//                if (switchImage) currentImage = ranged1;
//                else currentImage = ranged2;
//                repaint();
//            }
//        });
//        animation.start();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        handleKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        handleKeyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        handleKeyTyped(e);
    }
    public void handleKeyPressed(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_I) forward = true;
        if (code == KeyEvent.VK_K) back = true;
        if (code == KeyEvent.VK_J) left = true;
        if (code == KeyEvent.VK_L) right = true;
        if (code == KeyEvent.VK_U) ultimate = true;
        if (code == KeyEvent.VK_O && !onCD) {
            skill = true;
            dmg = skillDmg;
            skillSet(4);
            startCD();
        }
        if (code == KeyEvent.VK_P && !skillRunning && !attackRunning) {
            attack = true;
            dmg = normalDmg;
            attackSet(4);
        }
    }
    public void handleKeyReleased(KeyEvent key) {
        if (code == KeyEvent.VK_I) forward = false;
        if (code == KeyEvent.VK_K) back = false;
        if (code == KeyEvent.VK_J) left = false;
        if (code == KeyEvent.VK_L) right = false;
        if (code == KeyEvent.VK_U) ultimate = false;
        if (code == KeyEvent.VK_O) {
            delayFromSkill(normal, normal, 2000,1);
        }
        if (code == KeyEvent.VK_P) {
            delayFromAttack(normal, normal, 2000,1);
        }
    }
    public void handleKeyTyped(KeyEvent e) {
    }
    public void movement() {
        super.movement();
    }
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(currentImage, (int)xPos, (int)yPos, 128, 128, null);
//    }
}
