import java.awt.event.KeyEvent;

public class Melee extends Player {
    public Melee() {
        super();
        super.movement();
    }
    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() == key.VK_W) forward = true;
        if (key.getKeyCode() == key.VK_S) back = true;
        if (key.getKeyCode() == key.VK_A) left = true;
        if (key.getKeyCode() == key.VK_D) right = true;
    }
    public void keyReleased(KeyEvent key) {
        if (key.getKeyCode() == key.VK_W) forward = false;
        if (key.getKeyCode() == key.VK_S) back = false;
        if (key.getKeyCode() == key.VK_A) left = false;
        if (key.getKeyCode() == key.VK_D) right = false;
    }
}
