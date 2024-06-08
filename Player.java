import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Player extends JPanel{
    protected boolean forward,back,left,right;
    protected boolean normal,skill,ultimate;
    protected double moveSpeed = 0.5;
    protected float yPos, xPos;
    protected float yDir = 1, xDir = 0;
    protected JFrame frame;
    public Player(JFrame frame) {
        this.frame = frame;
    }
    public void movement() {
        if (forward) {
            yPos += (float) (yDir * moveSpeed);
        }
        if (back) {
            yPos -= (float) (yDir * moveSpeed);
        }
        if (left) {
            xPos += (float) (xDir * moveSpeed);
        }
        if (right) {
            xPos -= (float) (yDir * moveSpeed);
        }
    }
}
