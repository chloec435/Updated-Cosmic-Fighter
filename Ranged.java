import java.awt.event.KeyEvent;

public class Ranged extends Player {
    private int code;
    public Ranged() {
        super();
        movement();
    }
    public void keyPressed(KeyEvent key) {
        code = key.getKeyCode();
        if (code == key.VK_NUMPAD8) forward = true;
        if (code == key.VK_NUMPAD2) back = true;
        if (code == key.VK_NUMPAD4) left = true;
        if (code == key.VK_NUMPAD6) right = true;
        if (code == key.VK_NUMPAD9) ultimate = true;
        if (code == key.VK_NUMPAD7) skill = true;
        if (code == key.VK_NUMPAD0) normal = true;
    }
    public void keyReleased(KeyEvent key) {
        if (code == key.VK_NUMPAD8) forward = false;
        if (code == key.VK_NUMPAD2) back = false;
        if (code == key.VK_NUMPAD4) left = false;
        if (code == key.VK_NUMPAD6) right = false;
        if (code == key.VK_NUMPAD9) ultimate = false;
        if (code == key.VK_NUMPAD7) skill = false;
        if (code == key.VK_NUMPAD0) normal = false;
    }
}
