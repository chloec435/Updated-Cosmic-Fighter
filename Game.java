import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

public class Game extends JFrame {
    private int[] map;
    private int[] pixels;
    private BufferedImage[] images;
    public Game() {
        startingScreen();
        setVisible(true);
    }
    public void startingScreen() {
        setSize(1720,960);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton menu = new JButton(); //creating menu button
        menu.setPreferredSize(new Dimension(50,50));
        menu.setBackground(Color.WHITE);
        ImageIcon threeDash = new ImageIcon(new ImageIcon("Images/Three dash.png")
                .getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
        menu.setIcon(threeDash);
        menu.setBorder(new LineBorder(Color.BLACK, 3));
        JButton play = new JButton(); //creating play button
        play.setPreferredSize(new Dimension(500,100));
        ImageIcon PLAY = new ImageIcon(new ImageIcon("Images/Play.png")
                .getImage().getScaledInstance(500,100, Image.SCALE_SMOOTH));
        play.setIcon(PLAY);
        play.setBorderPainted(false);
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        JButton help = new JButton(); //creating help button
        help.setPreferredSize(new Dimension(500,100));
        ImageIcon HELP = new ImageIcon(new ImageIcon("Images/Help.png")
                .getImage().getScaledInstance(500,100, Image.SCALE_SMOOTH));
        help.setIcon(HELP);
        help.setBorderPainted(false);
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        add(menu);
        add(play);
        add(help);
        //setting layout for buttons
        layout.putConstraint(SpringLayout.EAST, menu, -5, SpringLayout.EAST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, menu, 5, SpringLayout.NORTH, getContentPane());
        layout.putConstraint(SpringLayout.WEST, play, (getWidth()-500)/2, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, play, (getHeight()-350)/2-55, SpringLayout.SOUTH, menu);
        layout.putConstraint(SpringLayout.WEST, help, (getWidth()-500)/2, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, help, 100, SpringLayout.SOUTH, play);
    }
    public void setMap() {
        File tiles = new File("Images/Tiles.png");
    }
    public void setTiles(int x, int y) {

    }
    public static void main (String[] args) {
        Game game = new Game();
    }

}
