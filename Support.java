import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Support extends Character {
    private int code;
    private int normalDmg = 5;
    private ArrayList<Character> characters;
    public Support(JFrame frame, ArrayList<Character> characters) throws IOException {
        super(frame);
        this.characters = characters;
        System.out.println("Support spawned");
        addKeyListener(this);
        setFocusable(true);
        normal = scaleImage(ImageIO.read(new File("Images/Support/Support.png")));
        attack1 = scaleImage(ImageIO.read(new File("Images/Support/Support.png")));
        attack2 = scaleImage(ImageIO.read(new File("Images/Support/Support (1).png")));
        skill1 = scaleImage(ImageIO.read(new File("Images/Support/Support Heal.png")));
        skill2 = scaleImage(ImageIO.read(new File("Images/Support/Support (1).png")));
        width = 256; height = 256;
        animate(normal, normal, 1);
    }
    public void healAll() {
        for (Character character : characters) {
            character.heal(heal);
        }
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
        if (code == KeyEvent.VK_UP) forward = true;
        if (code == KeyEvent.VK_DOWN) back = true;
        if (code == KeyEvent.VK_LEFT) left = true;
        if (code == KeyEvent.VK_RIGHT) right = true;
        if (code == KeyEvent.VK_NUMPAD3) ultimate = true;
        if (code == KeyEvent.VK_NUMPAD2 && !onCD) {
            skill = true;
            healAll();
            skillSet(4);
            startCD();
        }
        if (code == KeyEvent.VK_NUMPAD1 && !skillRunning && !attackRunning) {
            attack = true;
            dmg = normalDmg;
            attackSet(4);
        }
    }
    public void handleKeyReleased(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_UP) forward = false;
        if (code == KeyEvent.VK_DOWN) back = false;
        if (code == KeyEvent.VK_LEFT) left = false;
        if (code == KeyEvent.VK_RIGHT) right = false;
        if (code == KeyEvent.VK_NUMPAD3) ultimate = false;
        if (code == KeyEvent.VK_NUMPAD2) {
            delayFromSkill(normal, normal, 2000,1);
        }
        if (code == KeyEvent.VK_NUMPAD1) {
            delayFromAttack(normal, normal, 2000,1);
        }
    }
    public void handleKeyTyped(KeyEvent e) {
    }
    public void movement() {
        super.movement();
    }
}
