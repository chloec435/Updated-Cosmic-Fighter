import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Melee extends Player {
    private int code;
    private Image melee;
    public Melee(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Melee spawned");
        addKeyListener(this);
        setFocusable(true);
        melee = ImageIO.read(new File("Images/Melee/Shuriken.png"));
        setIcon(new ImageIcon(new ImageIcon(melee).getImage().
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
        if (code == KeyEvent.VK_W) forward = true;
        if (code == KeyEvent.VK_S) back = true;
        if (code == KeyEvent.VK_A) left = true;
        if (code == KeyEvent.VK_D) right = true;
        if (code == KeyEvent.VK_Q) ultimate = true;
        if (code == KeyEvent.VK_E) skill = true;
        if (code == KeyEvent.VK_SPACE) normal = true;
    }
    public void handleKeyReleased(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_W) forward = false;
        if (code == KeyEvent.VK_S) back = false;
        if (code == KeyEvent.VK_A) left = false;
        if (code == KeyEvent.VK_D) right = false;
        if (code == KeyEvent.VK_Q) ultimate = false;
        if (code == KeyEvent.VK_E) skill = false;
        if (code == KeyEvent.VK_SPACE) normal = false;
    }
    public void handleKeyTyped(KeyEvent e) {
    }
    public void movement() {
        super.movement();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(melee, (int)xPos, (int)yPos, 128, 128, null);
    }
}
