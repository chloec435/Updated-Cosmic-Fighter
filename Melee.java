import java.awt.event.KeyEvent;

public class Melee extends Player {
    private int code;
    public Melee() {
        super();
        movement();
    }
    public void keyPressed(KeyEvent key) {
        code = key.getKeyCode();
        if (code == key.VK_W) forward = true;
        if (code == key.VK_S) back = true;
        if (code == key.VK_A) left = true;
        if (code == key.VK_D) right = true;
        if (code == key.VK_Q) ultimate = true;
        if (code == key.VK_E) skill = true;
        if (code == key.VK_SPACE) normal = true;
    }
    public void keyReleased(KeyEvent key) {
        code = key.getKeyCode();
        if (code == key.VK_W) forward = false;
        if (code == key.VK_S) back = false;
        if (code == key.VK_A) left = false;
        if (code == key.VK_D) right = false;
        if (code == key.VK_Q) ultimate = false;
        if (code == key.VK_E) skill = false;
        if (code == key.VK_SPACE) normal = false;
    }
}
