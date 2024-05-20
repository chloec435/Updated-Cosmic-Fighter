import java.awt.event.KeyEvent;
public class Player {
    protected boolean forward,back,left,right;
    protected boolean normalAttack,AOE,ultimate;
    protected double moveSpeed = 0.5;
    protected int x,y,xDir,yDir;
    public Player(){}
    public Player(String type) {
        type(type);
    }
    public void type(String type) {
        if (type == "melee") new Melee();
        if (type == "ranged") new Ranged();
        if (type == "support") new Support();
    }
    
}
