import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Melee extends Player implements KeyListener {
    private int code;
    private Image melee;
    public Melee(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Melee spawned");
        addKeyListener(this);
        setFocusable(true);
        melee = ImageIO.read(new File("Images/Melee/Shuriken.png"));
    }
    public void keyPressed(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_W) forward = true;
        if (code == KeyEvent.VK_S) back = true;
        if (code == KeyEvent.VK_A) left = true;
        if (code == KeyEvent.VK_D) right = true;
        if (code == KeyEvent.VK_Q) ultimate = true;
        if (code == KeyEvent.VK_E) skill = true;
        if (code == KeyEvent.VK_SPACE) normal = true;
    }
    public void keyReleased(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_W) forward = false;
        if (code == KeyEvent.VK_S) back = false;
        if (code == KeyEvent.VK_A) left = false;
        if (code == KeyEvent.VK_D) right = false;
        if (code == KeyEvent.VK_Q) ultimate = false;
        if (code == KeyEvent.VK_E) skill = false;
        if (code == KeyEvent.VK_SPACE) normal = false;
    }
    public void keyTyped(KeyEvent e) {
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(melee, (int)xPos, (int)yPos, 64, 64, null);
    }
}
