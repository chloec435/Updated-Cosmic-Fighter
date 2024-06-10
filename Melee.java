import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Melee extends Character {
    private int code;
    private int normalDmg = 25, skillDmg = 50;

    public Melee(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Melee spawned");
        addKeyListener(this);
        setFocusable(true);
        normal = scaleImage(ImageIO.read(new File("Images/Melee/Shuriken.png")));
        attack1 = scaleImage(ImageIO.read(new File("Images/Melee/Shuriken.png")));
        attack2 = scaleImage(ImageIO.read(new File("Images/Melee/Shuriken (1).png")));
        skill1 = scaleImage(ImageIO.read(new File("Images/Melee/Shuriken Skill.png")));
        skill2 = scaleImage(ImageIO.read(new File("Images/Melee/Shuriken Skill (1).png")));
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
        if (code == KeyEvent.VK_W) forward = true;
        if (code == KeyEvent.VK_S) back = true;
        if (code == KeyEvent.VK_A) left = true;
        if (code == KeyEvent.VK_D) right = true;
        if (code == KeyEvent.VK_Q) ultimate = true;
        if (code == KeyEvent.VK_E && !onCD) {
            skill = true;
            dmg = skillDmg;
            skillSet(12);
            startCD();
        }
        if (code == KeyEvent.VK_SPACE && !skillRunning && !attackRunning) {
            attack = true;
            dmg = normalDmg;
            attackSet(12);
        }
    }
    public void handleKeyReleased(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_W) forward = false;
        if (code == KeyEvent.VK_S) back = false;
        if (code == KeyEvent.VK_A) left = false;
        if (code == KeyEvent.VK_D) right = false;
        if (code == KeyEvent.VK_Q) ultimate = false;
        if (code == KeyEvent.VK_E) {
            delayFromSkill(normal, normal, 2000,1);
        }
        if (code == KeyEvent.VK_SPACE) {
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
