import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Startup extends JFrame {
    private JButton play;
//    private JButton help;
    private JLabel title;
    private JPanel backgroundPanel;
    public static Clip introMusic;
    public Startup() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        startingScreen();
        play();
        setVisible(true);
        introMusic = AudioSystem.getClip();
        introMusic.open(AudioSystem.getAudioInputStream(new File("Images/Audio/Intro Music.wav")));
        introMusic.loop(Clip.LOOP_CONTINUOUSLY);
        introMusic.start();
    }
    public void startingScreen() throws IOException {
        setSize(1920,1080);
        SpringLayout layout = new SpringLayout();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Image background = ImageIO.read(new File("Images/ufo-1265186_1920.jpg"));
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setPreferredSize(new Dimension(1920, 1080));
        backgroundPanel.setLayout(layout);

        title = new JLabel();
        title.setPreferredSize(new Dimension(1920,850));
        ImageIcon TITLE = new ImageIcon(new ImageIcon("Images/Words/Cosmic Fighter.png")
                .getImage().getScaledInstance(1920,1000, Image.SCALE_SMOOTH));
        title.setIcon(TITLE);
        title.setOpaque(false);
        play = new JButton(); //creating play button
        play.setPreferredSize(new Dimension(500,100));
        ImageIcon PLAY = new ImageIcon(new ImageIcon("Images/Play.png")
                .getImage().getScaledInstance(500,100, Image.SCALE_SMOOTH));
        play.setIcon(PLAY);
        play.setBorderPainted(false);
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        backgroundPanel.add(play);
        backgroundPanel.add(title);
        layout.putConstraint(SpringLayout.WEST, title, 0, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, getContentPane());
        layout.putConstraint(SpringLayout.WEST, play, (getWidth()-500)/2, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, play, 900, SpringLayout.NORTH, title);
        add(backgroundPanel);
    }
    public void play() {
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    dispose();
                    Game game = new Game();
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void help() {}
    public static void main (String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Startup startup = new Startup();
    }

}
