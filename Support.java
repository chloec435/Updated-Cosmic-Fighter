import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Support extends Player {
    private int code;
//    private Image support1;
//    private Image support2;
//    private Image currentImage;
//    private Timer animation;
//    private boolean switchImage = false;
    public Support(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Support spawned");
        addKeyListener(this);
        setFocusable(true);
        image1 = ImageIO.read(new File("Images/Support/Support.png"));
        image2 = ImageIO.read(new File("Images/Support/Support (1).png"));
        image();
//        currentImage = support1;
//        setSize(frame.getWidth(), frame.getHeight());
//        setLocation((int) xPos, (int) yPos);
//        setVisible(true);
//        image(support1);
//        animation = new Timer(1000/2, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switchImage = !switchImage;
//                if (switchImage) currentImage = support1;
//                else currentImage = support2;
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
        g.drawImage(currentImage, (int)xPos, (int)yPos, 128, 128, null);
    }
}
