import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Startup extends JFrame {
    private int[] map;
    private int[] pixels;
    private BufferedImage[] images;
    private JButton play;
    private JButton help;
    public Startup() {
        startingScreen();
        play();
        setVisible(true);
    }
    public void startingScreen() {
        setSize(1920,1080);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        play = new JButton(); //creating play button
        play.setPreferredSize(new Dimension(500,100));
        ImageIcon PLAY = new ImageIcon(new ImageIcon("Images/Play.png")
                .getImage().getScaledInstance(500,100, Image.SCALE_SMOOTH));
        play.setIcon(PLAY);
        play.setBorderPainted(false);
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        help = new JButton(); //creating help button
        help.setPreferredSize(new Dimension(500,100));
        ImageIcon HELP = new ImageIcon(new ImageIcon("Images/Help.png")
                .getImage().getScaledInstance(500,100, Image.SCALE_SMOOTH));
        help.setIcon(HELP);
        help.setBorderPainted(false);
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        add(play);
        add(help);
        //setting layout for buttons
        layout.putConstraint(SpringLayout.WEST, play, (getWidth()-500)/2, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, play, (getHeight()-350)/2, SpringLayout.NORTH, getContentPane());
        layout.putConstraint(SpringLayout.WEST, help, (getWidth()-500)/2, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, help, 100, SpringLayout.SOUTH, play);
    }
    public void play() {
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                dispose();
                try {
                    dispose();
                    Game game = new Game();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void help() {}

    public void setMap() throws IOException {
        File tiles = new File("Images/Tiles.png");
        BufferedImage TILES = ImageIO.read(tiles);
        int tilesWidth = TILES.getWidth();
        int tilesHeight = TILES.getHeight();
        pixels = new int[tilesWidth*tilesHeight];
        TILES.getRGB(0, 0, tilesWidth, tilesHeight, pixels, 0, tilesWidth);
    }
    public void setTiles(int x, int y) {

    }
    public static void main (String[] args) {
        Startup startup = new Startup();
    }

}
