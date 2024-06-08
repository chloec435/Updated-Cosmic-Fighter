import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Support extends Player implements KeyListener {
    private int code;
    private Image support;
    public Support(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Support spawned");
        addKeyListener(this);
        setFocusable(true);
        support = ImageIO.read(new File("Images/Support/Support.png"));
    }
    public void keyPressed(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_KP_UP) forward = true;
        if (code == KeyEvent.VK_KP_DOWN) back = true;
        if (code == KeyEvent.VK_KP_LEFT) left = true;
        if (code == KeyEvent.VK_KP_RIGHT) right = true;
        if (code == KeyEvent.VK_J) ultimate = true;
        if (code == KeyEvent.VK_K) skill = true;
        if (code == KeyEvent.VK_L) normal = true;
    }
    public void keyReleased(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_KP_UP) forward = false;
        if (code == KeyEvent.VK_KP_DOWN) back = false;
        if (code == KeyEvent.VK_KP_LEFT) left = false;
        if (code == KeyEvent.VK_KP_RIGHT) right = false;
        if (code == KeyEvent.VK_J) ultimate = false;
        if (code == KeyEvent.VK_K) skill = false;
        if (code == KeyEvent.VK_L) normal = false;
    }
    public void keyTyped(KeyEvent e) {
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(support, (int)xPos, (int)yPos, 64, 64, null);
    }
}
