import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Support extends Player {
    private int code;
    private Image support;
    public Support(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Support spawned");
        addKeyListener(this);
        setFocusable(true);
        support = ImageIO.read(new File("Images/Support/Support.png"));
        setIcon(new ImageIcon(new ImageIcon(support).getImage().
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
        if (code == KeyEvent.VK_UP) forward = true;
        if (code == KeyEvent.VK_DOWN) back = true;
        if (code == KeyEvent.VK_LEFT) left = true;
        if (code == KeyEvent.VK_RIGHT) right = true;
        if (code == KeyEvent.VK_NUMPAD3) ultimate = true;
        if (code == KeyEvent.VK_NUMPAD2) skill = true;
        if (code == KeyEvent.VK_NUMPAD1) normal = true;
    }
    public void handleKeyReleased(KeyEvent key) {
        code = key.getKeyCode();
        if (code == KeyEvent.VK_UP) forward = false;
        if (code == KeyEvent.VK_DOWN) back = false;
        if (code == KeyEvent.VK_LEFT) left = false;
        if (code == KeyEvent.VK_RIGHT) right = false;
        if (code == KeyEvent.VK_NUMPAD3) ultimate = false;
        if (code == KeyEvent.VK_NUMPAD2) skill = false;
        if (code == KeyEvent.VK_NUMPAD1) normal = false;
    }
    public void handleKeyTyped(KeyEvent e) {
    }
    public void movement() {
        super.movement();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(support, (int)xPos, (int)yPos, 128, 128, null);
    }
}
