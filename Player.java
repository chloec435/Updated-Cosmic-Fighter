import java.awt.event.KeyEvent;
public class Player {
    protected boolean forward,back,left,right;
    protected boolean normalAttack,AOE,ultimate;
    protected double moveSpeed = 0.5;
    protected float xPos,yPos;
    protected float xDir = 1, yDir = 0;
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
    public void movement(int x, int y) {
        if (forward) {
            xPos = 
        }
        if (back) {

        }
        if (left) {

        }
        if (right) {

        }
    }
}
