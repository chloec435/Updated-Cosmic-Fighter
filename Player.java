import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Player extends JLabel implements KeyListener {
    protected boolean forward,back,left,right;
    protected boolean normal,skill,ultimate;
    protected double moveSpeed = 2;
    protected float yPos = 10, xPos = 10;
    protected float yDir = 1, xDir = 1;
    protected JFrame frame;
    public Player(JFrame frame) {
        this.frame = frame;
        this.frame.requestFocusInWindow();
        setOpaque(false);
        setLayout(null);
    }
    public void movement() {
        if (forward && yPos != 0) {
            yPos -= (float) (yDir * moveSpeed);
            System.out.println("forward");
        }
        if (back && yPos != 952) {
            yPos += (float) (yDir * moveSpeed);
            System.out.println("backwards");
        }
        if (left && xPos != 0) {
            xPos -= (float) (xDir * moveSpeed);
            System.out.println("left");
        }
        if (right && xPos != 1792) {
            xPos += (float) (xDir * moveSpeed);
            System.out.println("right");
        }
        if (forward || back || left || right) {
            setLocation((int) xPos, (int) yPos);
            repaint();
        }
    }
    public abstract void handleKeyPressed(KeyEvent e);

    public abstract void handleKeyReleased(KeyEvent e);

    public abstract void handleKeyTyped(KeyEvent e);

    public void keyPressed(KeyEvent e) {
        handleKeyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        handleKeyReleased(e);
    }

    public void keyTyped(KeyEvent e) {
        handleKeyTyped(e);
    }
}
