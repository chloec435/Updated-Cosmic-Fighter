import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    private BufferedImage selectedImage;
    public Image(String image) {
    }
    public void setImage(String image) throws IOException {
        if (image.equalsIgnoreCase("melee")) {
            selectedImage = ImageIO.read(new File("Images/Melee/Melee.png"));
        }
        if (image.equalsIgnoreCase("meleeAttack")) {
            selectedImage = ImageIO.read(new File("Images/Melee/Melee Attack.gif"));
        }
        if (image.equalsIgnoreCase("meleeSkill")) {
            selectedImage = ImageIO.read(new File("Images/Melee/Melee Skill.gif"));
        }
        if (image.equalsIgnoreCase("ranged")) {
            selectedImage = ImageIO.read(new File("Images/Ranged/Ranged.png"));
        }
        if (image.equalsIgnoreCase("rangedAOE")) {
            selectedImage = ImageIO.read(new File("Images/Ranged/Ranged AOE.gif"));
        }
        if (image.equalsIgnoreCase("support")) {
            selectedImage = ImageIO.read(new File("Images/Support/Support.png"));
        }
        if (image.equalsIgnoreCase("supportHeal")) {
            selectedImage = ImageIO.read(new File("Images/Support/Support Heal.gif"));
        }
    }

}
