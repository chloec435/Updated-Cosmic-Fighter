import java.awt.event.KeyEvent;
public class Player {
    protected boolean forward,back,left,right;
    protected boolean normal,skill,ultimate;
    protected double moveSpeed = 0.5;
    protected float yPos, xPos;
    protected float yDir = 1, xDir = 0;
    protected int[][] map;
    public Player(){}
    public Player(String type, int[][] mapping) {
        type(type);
        map = mapping;
    }
    public void type(String type) {
        if (type == "melee") new Melee();
        if (type == "ranged") new Ranged();
        if (type == "support") new Support();
    }
    //https://medium.com/@niiicolai/an-introduction-to-movement-in-2d-games-281ff3b58533
    public void movement() {
        if (forward) {
            if (map[ (int) (yPos + yDir * moveSpeed) ][ (int) xPos ] == 0) {
                yPos += yDir * moveSpeed;
            }
        }
        if (back) {
            if (map[ (int) (yPos - yDir * moveSpeed) ][ (int) xPos ] == 0) {
                yPos -= yDir * moveSpeed;
            }
        }
        if (left) {
            if (map[ (int) yPos][ (int) (xPos + xDir * moveSpeed) ] == 0) {
                xPos += xDir * moveSpeed;
            }
        }
        if (right) {
            if (map[ (int) yPos][ (int) (xPos + xDir * moveSpeed) ] == 0) {
                xPos -= yDir * moveSpeed;
            }
        }
    }

}
