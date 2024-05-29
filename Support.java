import java.awt.event.KeyEvent;
public class Support extends Player {
    private int code;
    public Support() {
        super();
        movement();
    }
    public void keyPressed(KeyEvent key) {
        code = key.getKeyCode();
        if (code == key.VK_KP_UP) forward = true;
        if (code == key.VK_KP_DOWN) back = true;
        if (code == key.VK_KP_LEFT) left = true;
        if (code == key.VK_KP_RIGHT) right = true;
        if (code == key.VK_J) ultimate = true;
        if (code == key.VK_K) skill = true;
        if (code == key.VK_L) normal = true;
    }
    public void keyReleased(KeyEvent key) {
        code = key.getKeyCode();
        if (code == key.VK_KP_UP) forward = false;
        if (code == key.VK_KP_DOWN) back = false;
        if (code == key.VK_KP_LEFT) left = false;
        if (code == key.VK_KP_RIGHT) right = false;
        if (code == key.VK_J) ultimate = false;
        if (code == key.VK_K) skill = false;
        if (code == key.VK_L) normal = false;
    }
}
