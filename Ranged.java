import java.awt.event.KeyEvent;

public class Ranged extends Player {
    public Ranged() {
        super();
    }
    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() == key.VK_NUMPAD8) forward = true;
        if (key.getKeyCode() == key.VK_NUMPAD2) back = true;
        if (key.getKeyCode() == key.VK_NUMPAD4) left = true;
        if (key.getKeyCode() == key.VK_NUMPAD6) right = true;
    }
    public void keyReleased(KeyEvent key) {
        if (key.getKeyCode() == key.VK_NUMPAD8) forward = false;
        if (key.getKeyCode() == key.VK_NUMPAD2) back = false;
        if (key.getKeyCode() == key.VK_NUMPAD4) left = false;
        if (key.getKeyCode() == key.VK_NUMPAD6) right = false;
    }
}
