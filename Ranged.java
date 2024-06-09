import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Ranged extends Player {
    private int code;
    private Image ranged;
    public Ranged(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Ranged spawned");
        addKeyListener(this);
        setFocusable(true);
        ranged = ImageIO.read(new File("Images/Ranged/Ranged.png"));
        setIcon(new ImageIcon(new ImageIcon(ranged).getImage().
                getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
        setSize(128, 128);
        setLocation((int) xPos, (int) yPos);
        setVisible(true);
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
        if (code == KeyEvent.VK_I) forward = true;
        if (code == KeyEvent.VK_K) back = true;
        if (code == KeyEvent.VK_J) left = true;
        if (code == KeyEvent.VK_L) right = true;
        if (code == KeyEvent.VK_U) ultimate = true;
        if (code == KeyEvent.VK_O) skill = true;
        if (code == KeyEvent.VK_P) normal = true;
    }
    public void handleKeyReleased(KeyEvent key) {
        if (code == KeyEvent.VK_I) forward = false;
        if (code == KeyEvent.VK_K) back = false;
        if (code == KeyEvent.VK_J) left = false;
        if (code == KeyEvent.VK_L) right = false;
        if (code == KeyEvent.VK_U) ultimate = false;
        if (code == KeyEvent.VK_O) skill = false;
        if (code == KeyEvent.VK_P) normal = false;
    }
    public void handleKeyTyped(KeyEvent e) {
    }
    public void movement() {
        super.movement();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ranged, (int)xPos, (int)yPos, 128, 128, null);
    }
}
