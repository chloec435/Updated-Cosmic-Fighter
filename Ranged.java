import java.awt.event.KeyEvent;

public class Ranged extends Player {
    public Ranged() {
        super();
    }
    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() == key.VK_KP_UP) forward = true;
        if (key.getKeyCode() == key.VK_KP_DOWN) back = true;
        if (key.getKeyCode() == key.VK_KP_LEFT) left = true;
        if (key.getKeyCode() == key.VK_KP_RIGHT) right = true;
    }
    public void keyReleased(KeyEvent key) {
        if (key.getKeyCode() == key.VK_KP_UP) forward = false;
        if (key.getKeyCode() == key.VK_KP_DOWN) back = false;
        if (key.getKeyCode() == key.VK_KP_LEFT) left = false;
        if (key.getKeyCode() == key.VK_KP_RIGHT) right = false;
    }
}
