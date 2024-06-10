import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Ranged extends Character {
    private int code;
    private int normalDmg = 15, skillDmg = 40;
    public Ranged(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Ranged spawned");
        addKeyListener(this);
        setFocusable(true);
        normal = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged.png")));
        attack1 = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged.png")));
        attack2 = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged (1).png")));
        skill1 = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged AOE.png")));
        skill2 = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged AOE (1).png")));
        width = 256; height = 256;
        animate(normal, normal, 1);
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
        code = key.getKeyCode();
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
}
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Ranged extends Character {
    private int code;
    private int normalDmg = 15, skillDmg = 40;
    public Ranged(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Ranged spawned");
        addKeyListener(this);
        setFocusable(true);
        normal = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged.png")));
        attack1 = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged.png")));
        attack2 = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged (1).png")));
        skill1 = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged AOE.png")));
        skill2 = scaleImage(ImageIO.read(new File("Images/Ranged/Ranged AOE (1).png")));
        animate(normal, normal, 1);
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
            attack = false;
            delayFromAttack(normal, normal, 2000,1);
        }
    }
    public void handleKeyTyped(KeyEvent e) {
    }
    public void movement() {
        super.movement();
    }
}
