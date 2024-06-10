import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Monster extends Character {
    private double attackDamage = 0.1;
    public double hp = 100000;
    public Monster(JFrame frame) throws IOException {
        super(frame);
        System.out.println("Monster spawned");
        xPos = 890/2;
        yPos = 0;
        setFocusable(true);
        currentImage = ImageIO.read(new File("Images/Monsters/Boss.png"));
        skill1 = ImageIO.read(new File("Images/Monsters/Boss.png"));
        skill2 = ImageIO.read(new File("Images/Monsters/Boss.png"));
        width = 256; height = 256;
    }
    @Override
    public void movement() {
        if (xPos >= 825) {
            xDir = -1;
        } else if (xPos <= 0) {
            xDir = 1;
        }
        xPos += xDir * moveSpeed;
        if (yPos >= 400) {
            yDir = -1;
        } else if (yPos <= 0) {
            yDir = 1;
        }
        yPos += yDir * moveSpeed;
        setLocation(xPos, yPos);
        animate(currentImage,currentImage,1);
    }
    public void attackPlayers(Character playerOne, Character playerTwo) {
        playerOne.hp -= attackDamage;
        playerTwo.hp -= attackDamage;
    }
    public void dmgTaken(Character other, int dmgTaken) {
        if (isTouching(other)) {
            hp -= dmgTaken;
            System.out.println("Monster damage taken: " + dmgTaken + ", Monster current HP: " + hp);
        }
    }
    public double checkHp() {
        if (this.hp <= 0) {
            frame.remove(this);
        }
        return hp;
    }
    public void handleKeyPressed(KeyEvent e) {}
    public void handleKeyReleased(KeyEvent e) {}
    public void handleKeyTyped(KeyEvent e) {}
}
