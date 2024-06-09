import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Melee extends Player {
    private int code;
//    private Image melee1;
//    private Image melee2;
//    private Image currentImage;
//    private Timer animation;
//    private boolean switchImage = false;

    public Melee(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Melee spawned");
        addKeyListener(this);
        setFocusable(true);
        image1 = ImageIO.read(new File("Images/Melee/Shuriken.png"));
        image2 = ImageIO.read(new File("Images/Melee/Shuriken (1).png"));
        image();
//        currentImage = melee1;
//        setSize(frame.getWidth(), frame.getHeight());
//        setLocation((int) xPos, (int) yPos);
//        setVisible(true);
//        animation = new Timer(1000/12, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switchImage = !switchImage;
//                if (switchImage) currentImage = melee1;
//                else currentImage = melee2;
//                repaint();
//            }
//        });
//        animation.start();
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
        System.out.println("Repainting component");
        g.drawImage(currentImage, (int)xPos, (int)yPos, 128, 128, null);
    }
}
