import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public abstract class Character extends JLabel implements KeyListener {
    protected boolean forward,back,left,right;
    protected boolean attack,skill,ultimate;
    protected boolean onCD = false, skillRunning = false, attackRunning = false;
    protected int moveSpeed = 2;
    protected int yPos = 400, xPos = 890/2;
    protected int yDir = 1, xDir = 1;
    protected int dmg, heal = 50;
    protected double hp = 200.00;
    protected int width, height;
    protected JFrame frame;
    protected Image currentImage;
    protected Image normal, attack1, attack2, skill1, skill2;
    private Timer animation, delaySkill, delayAttack;
    private boolean switchImage = false;
    public Character(JFrame frame) {
        this.frame = frame;
        this.frame.requestFocusInWindow();
        setOpaque(false);
        setLayout(null);
        setSize(frame.getWidth(), frame.getHeight());
        setLocation(xPos, yPos);
        setVisible(true);
    }
    public void movement() {
        if (forward && yPos >= 0) {
            yPos -= yDir * moveSpeed;
        }
        if (back && yPos <= 455) {
            yPos += yDir * moveSpeed;
        }
        if (left && xPos >= 0) {
            xPos -= xDir * moveSpeed;
        }
        if (right && xPos <= 890) {
            xPos += xDir * moveSpeed;
        }
        if (forward || back || left || right) {
            setLocation(xPos, yPos);
            repaint();
        }
    }
    public void animate(Image first, Image second, int frames) {
        if (animation != null) {
            animation.stop();
        }
        currentImage = first;
        animation = new Timer(100/frames, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchImage = !switchImage;
                if (switchImage) currentImage = first;
                else currentImage = second;
                repaint();
            }
        });
        animation.start();
    }
    public void delayFromSkill(Image first, Image second, int time, int frames) {
        if (delaySkill != null) {
            delaySkill.stop();
        }
        delaySkill = new Timer(time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skill = false;
                skillRunning = false;
                animate(first, second, frames);
            }
        });
        delaySkill.setRepeats(false);
        delaySkill.start();
    }
    public void delayFromAttack(Image first, Image second, int time, int frames) {
        if (delayAttack != null) {
            delayAttack.stop();
        }
        delayAttack = new Timer(time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attack = false;
                attackRunning = false;
                animate(first, second, frames);
            }
        });
        delayAttack.setRepeats(false);
        delayAttack.start();
    }
    public void startCD() {
        onCD = true;
        new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCD = false;
            }
        }).start();
    }
    public void skillSet(int frames) {
        if (skill) {
            skillRunning = true;
            attackRunning = false;
            animate(skill1, skill2, frames);
        }
    }
    public void attackSet(int frames) {
        if (attack) {
            attackRunning = true;
            skillRunning = false;
            animate(attack1, attack2, frames);
        }
    }
    public void dmgTaken(Character other, int dmgTaken) {
        if (isTouching(other)) {
            hp -= dmgTaken;
            System.out.println("Character damage taken: " + dmgTaken + ", Character current HP: " + hp);
        }
    }
    public void heal(int amount) {
        if (hp < 200) {
            double toMaxHp = 200-hp;
            if (toMaxHp <= 50) {
                hp = 200;
            } else {
                hp += heal;
            }
        }
        System.out.println("Character healed: " + amount + ", Character current HP: " + hp);
    }
    public double checkHp() {
        System.out.println("Character Hp: " + hp);
        if (this.hp <= 0) {
            frame.remove(this);
        }
        return hp;
    }
    public Rectangle getBoundingBox() {
        return new Rectangle(xPos, yPos, width, height);
    }
    public boolean isTouching(Character other) {
        return getBoundingBox().intersects(other.getBoundingBox());
    }
    public int returnDamage() {
        return dmg;
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
    protected Image scaleImage(Image image) {
        return image.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int imageWidth = currentImage.getWidth(null);
        int imageHeight = currentImage.getHeight(null);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int imageX = centerX - (imageWidth / 2);
        int imageY = centerY - (imageHeight / 2);
        g.drawImage(currentImage, imageX, imageY, imageWidth, imageHeight, null);
        int rectX = imageX - (width - imageWidth) / 2;
        int rectY = imageY - (height - imageHeight) / 2;
        g.setColor(Color.WHITE);
        g.drawRect(rectX, rectY, width, height);
    }
}
