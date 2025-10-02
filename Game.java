import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Game {
    private BufferedImage background;
    private int clicks = 0;
    private JPanel backgroundPanel, gameBackgroundPanel;
    private String playerOne, playerTwo;
    private JFrame frame, game;
    private Character charOne, charTwo;
    private Clip theme, currentClip;
    private Monster monster;
    private boolean triumph = true, running = true;
    private int screen_width = 1400;
    private int screen_length = 840;
    private final ArrayList<Character> characters = new ArrayList<Character>();
    public Game() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        theme = AudioSystem.getClip();
        theme.open(AudioSystem.getAudioInputStream(new File("Audio/Game Music.wav")));
        frame();
        selection();
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter()  {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    theme.stop();
                    Startup main = new Startup();
                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void frame() throws IOException {
        frame = new JFrame();
        frame.setSize(screen_width, screen_length);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        background = ImageIO.read(new File("Images/ufo-1265186_1920.jpg"));
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setPreferredSize(new Dimension(screen_width, screen_length));
        backgroundPanel.setLayout(null);
    }
    public void selection() {
        int char_xy = 500;
        int choose_x = screen_width;
        int choose_y = 150;
        JLabel melee = new JLabel(new ImageIcon(new ImageIcon("Images/Melee/Shuriken.png")
                .getImage().getScaledInstance(char_xy, char_xy, Image.SCALE_SMOOTH)));
        JLabel ranged = new JLabel(new ImageIcon(new ImageIcon("Images/Ranged/Ranged.png")
                .getImage().getScaledInstance(char_xy, char_xy, Image.SCALE_SMOOTH)));
        JLabel support = new JLabel(new ImageIcon(new ImageIcon("Images/Support/Support.png")
                .getImage().getScaledInstance(char_xy, char_xy, Image.SCALE_SMOOTH)));
        JLabel choose = new JLabel(new ImageIcon(new ImageIcon("Images/Words/choose char.png")
                .getImage().getScaledInstance(choose_x, choose_y, Image.SCALE_SMOOTH)));

        int x_bounds = (screen_width - char_xy * 3) / 4;
        int y_bounds = (screen_length - choose_y - char_xy);
        melee.setBounds(x_bounds, y_bounds, char_xy, char_xy);
        ranged.setBounds(x_bounds * 2 + char_xy, y_bounds, char_xy, char_xy);
        support.setBounds(x_bounds * 3 + char_xy * 2, y_bounds, char_xy, char_xy);
        choose.setBounds((frame.getWidth() - choose_x) / 2, 300, choose_x, choose_y);

        backgroundPanel.add(melee);
        backgroundPanel.add(ranged);
        backgroundPanel.add(support);
        backgroundPanel.add(choose);

        frame.setContentPane(backgroundPanel);

        melee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                melee.setVisible(false);
                clicks++;
                System.out.println("Melee clicked");
                try {
                    checkClicks("melee");
                } catch (InterruptedException | IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ranged.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ranged.setVisible(false);
                clicks++;
                System.out.println("Ranged clicked");
                try {
                    checkClicks("ranged");
                } catch (InterruptedException | IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        support.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                support.setVisible(false);
                clicks++;
                System.out.println("Support clicked");
                try {
                    checkClicks("support");
                } catch (InterruptedException | IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void checkClicks(String type) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (clicks == 1) {
            playerOne = type;
            JOptionPane.showMessageDialog(backgroundPanel, "Player 1 will be " + type + ".",
                    "Player One", JOptionPane.INFORMATION_MESSAGE);
        } else if (clicks == 2) {
            playerTwo = type;
            JOptionPane.showMessageDialog(backgroundPanel, "Player 2 will be " + type + ".",
                    "Player Two", JOptionPane.INFORMATION_MESSAGE);
            Startup.introMusic.stop();
            frame.dispose();
            currentClip = theme;
            theme.loop(Clip.LOOP_CONTINUOUSLY);
            theme.start();
            gameFrame();
        }
    }
    public void gameFrame() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        game = new JFrame();
        game.setSize(screen_width, screen_length);
        game.setResizable(false);
        game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        game.setLocationRelativeTo(null);
        gameBackgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        gameBackgroundPanel.setPreferredSize(new Dimension(screen_width, screen_length));
        gameBackgroundPanel.setLayout(null);
        game.setVisible(true);
        game.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    currentClip.stop();
                    Startup main = new Startup();
                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        switch (playerOne) {
            case "melee" -> charOne = new Melee(game);
            case "ranged" -> charOne = new Ranged(game);
            case "support" -> charOne = new Support(game, characters);
        }
        switch (playerTwo) {
            case "melee" -> charTwo = new Melee(game);
            case "ranged" -> charTwo = new Ranged(game);
            case "support" -> charTwo = new Support(game, characters);
        }
        game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                for (Character character : characters) {
                    character.keyPressed(e);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                for (Character character : characters) {
                    character.keyReleased(e);
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
                for (Character character : characters) {
                    character.keyTyped(e);
                }
            }
        });
        monster = new Monster(game);
        characters.add(charOne);
        characters.add(charTwo);
        gameBackgroundPanel.add(charOne);
        gameBackgroundPanel.add(charTwo);
        gameBackgroundPanel.add(monster);
        game.setContentPane(gameBackgroundPanel);
        gameBackgroundPanel.revalidate();
        gameBackgroundPanel.repaint();
        gameLoop();
    }
    public void gameLoop() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (!game.isShowing()) {
            System.out.println("Game loop stopped: window not showing or not running.");
            return;
        }
        for (Character character : characters) {
            if (character.checkHp() <= 0 || monster.checkHp() <= 0) {
                if (character.checkHp() <= 0) {
                    triumph = false;
                    System.out.println("Character HP is zero. Stopping game loop.");
                } else if (monster.checkHp() <= 0) {
                    triumph = true;
                    System.out.println("Monster HP is zero. Stopping game loop.");
                }
                endGame();
                return;
            }
            character.movement();
            monster.dmgTaken(character, character.returnDamage());
        }
        monster.movement();
        monster.attackPlayers(charOne, charTwo);
        gameBackgroundPanel.repaint();
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameLoop();
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    public void endGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        theme.stop();
        for (Character character : characters) {
            game.removeKeyListener(character);
        }
        JLabel end = new JLabel();
        end.setSize(screen_width, screen_length);
        end.setLocation((game.getWidth() - end.getWidth()) / 2, (game.getHeight() - end.getHeight()) / 2);
        end.setOpaque(false);
        if (triumph) {
            Clip triumphMusic = AudioSystem.getClip();
            triumphMusic.open(AudioSystem.getAudioInputStream(new File("Audio/Triumph Music.wav")));
            currentClip = triumphMusic;
            triumphMusic.loop(Clip.LOOP_CONTINUOUSLY);
            triumphMusic.start();
            end.setIcon(new ImageIcon(new ImageIcon("Images/Words/Triumph.png")
                    .getImage().getScaledInstance(end.getWidth(), end.getHeight(), Image.SCALE_SMOOTH)));
        } else {
            Clip defeatMusic = AudioSystem.getClip();
            defeatMusic.open(AudioSystem.getAudioInputStream(new File("Audio/Defeat Music.wav")));
            currentClip = defeatMusic;
            defeatMusic.loop(Clip.LOOP_CONTINUOUSLY);
            defeatMusic.start();
            end.setIcon(new ImageIcon(new ImageIcon("Images/Words/Defeat.png")
                    .getImage().getScaledInstance(end.getWidth(), end.getHeight(), Image.SCALE_SMOOTH)));
        }
        gameBackgroundPanel.add(end);
        gameBackgroundPanel.setComponentZOrder(end, 0);
        gameBackgroundPanel.revalidate();
        gameBackgroundPanel.repaint();
    }
}
