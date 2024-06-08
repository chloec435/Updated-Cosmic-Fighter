import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Ranged extends Player implements KeyListener {
    private int code;
    private Image ranged;
    public Ranged(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Ranged spawned");
        addKeyListener(this);
        setFocusable(true);
        ranged = ImageIO.read(new File("Images/Ranged/Ranged.png"));
    }
    public void keyPressed(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_NUMPAD8) forward = true;
        if (code == KeyEvent.VK_NUMPAD2) back = true;
        if (code == KeyEvent.VK_NUMPAD4) left = true;
        if (code == KeyEvent.VK_NUMPAD6) right = true;
        if (code == KeyEvent.VK_NUMPAD9) ultimate = true;
        if (code == KeyEvent.VK_NUMPAD7) skill = true;
        if (code == KeyEvent.VK_NUMPAD0) normal = true;
    }
    public void keyReleased(KeyEvent key) {
        if (code == KeyEvent.VK_NUMPAD8) forward = false;
        if (code == KeyEvent.VK_NUMPAD2) back = false;
        if (code == KeyEvent.VK_NUMPAD4) left = false;
        if (code == KeyEvent.VK_NUMPAD6) right = false;
        if (code == KeyEvent.VK_NUMPAD9) ultimate = false;
        if (code == KeyEvent.VK_NUMPAD7) skill = false;
        if (code == KeyEvent.VK_NUMPAD0) normal = false;
    }
    public void keyTyped(KeyEvent e) {
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ranged, (int)xPos, (int)yPos, 64, 64, null);
    }
}
