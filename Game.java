import javax.imageio.ImageIO;
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
    private Monster monster;
    private final ArrayList<Character> characters = new ArrayList<Character>();
    public Game() throws IOException {
        frame();
        selection();
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter()  {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Startup main = new Startup();
            }
        });
    }
    public void frame() throws IOException {
        frame = new JFrame();
        frame.setSize(1920, 1080);
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
        backgroundPanel.setPreferredSize(new Dimension(1920, 1080));
        backgroundPanel.setLayout(null);
    }
    public void selection() {
        JLabel melee = new JLabel(new ImageIcon(new ImageIcon("Images/Melee/Shuriken.png")
                .getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        JLabel ranged = new JLabel(new ImageIcon(new ImageIcon("Images/Ranged/Ranged.png")
                .getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        JLabel support = new JLabel(new ImageIcon(new ImageIcon("Images/Support/Support.png")
                .getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        JLabel choose = new JLabel(new ImageIcon(new ImageIcon("Images/Words/choose char.png")
                .getImage().getScaledInstance(1600, 150, Image.SCALE_SMOOTH)));

        melee.setBounds(100, 300, 500, 500);
        ranged.setBounds(700, 300, 500, 500);
        support.setBounds(1300, 300, 500, 500);
        choose.setBounds((frame.getWidth() - 1600) / 2, 100, 1600, 150);

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
                } catch (InterruptedException | IOException ex) {
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
                } catch (InterruptedException | IOException ex) {
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
                } catch (InterruptedException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void checkClicks(String type) throws InterruptedException, IOException {
        if (clicks == 1) {
            playerOne = type;
            JOptionPane.showMessageDialog(backgroundPanel, "Player 1 will be " + type + ".",
                    "Player One", JOptionPane.INFORMATION_MESSAGE);
        } else if (clicks == 2) {
            playerTwo = type;
            JOptionPane.showMessageDialog(backgroundPanel, "Player 2 will be " + type + ".",
                    "Player Two", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            gameFrame();
        }
    }
    public void gameFrame() throws IOException {
        game = new JFrame();
        game.setSize(1920, 1080);
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
        gameBackgroundPanel.setPreferredSize(new Dimension(1920, 1080));
        gameBackgroundPanel.setLayout(null);
        game.setVisible(true);
        game.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Startup main = new Startup();
            }
        });
        monster = new Monster(game);
//        characters.add(monster);
        gameBackgroundPanel.add(monster);
        switch (playerOne) {
            case "melee" -> charOne = new Melee(game);
            case "ranged" -> charOne = new Ranged(game);
            case "support" -> charOne = new Support(game);
        }
        switch (playerTwo) {
            case "melee" -> charTwo = new Melee(game);
            case "ranged" -> charTwo = new Ranged(game);
            case "support" -> charTwo = new Support(game);
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

        characters.add(charOne);
        characters.add(charTwo);
        gameBackgroundPanel.add(charOne);
        gameBackgroundPanel.add(charTwo);
        game.setContentPane(gameBackgroundPanel);
        gameBackgroundPanel.revalidate();
        gameBackgroundPanel.repaint();

        gameLoop();
    }
    public void gameLoop() {
        if (!game.isShowing()) {
            return;
        }
//        monster.startAttackTimer();
//        monster.path();
        for (Character character : characters) {
            character.checkHp();
            monster.checkHp();
            System.out.println(character.checkHp());
            System.out.println(monster.checkHp());
            character.movement();
//            character.dmgTaken(monster, monster.returnDamage());
//            monster.dmgTaken(character, character.returnDamage());
        }
        monster.movement();
        monster.attackPlayers(charOne, charTwo);
        gameBackgroundPanel.repaint();
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLoop();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
