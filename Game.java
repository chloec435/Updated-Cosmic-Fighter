import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private BufferedImage background;
    private int clicks = 0;
    private JPanel backgroundPanel;
    private JPanel gamePanel;
    private String playerOne;
    private String playerTwo;
    private JFrame frame;
    private Player one;
    private Player two;
    private ArrayList<Player> players = new ArrayList<Player>();
    public Game() throws IOException {
        frame = new JFrame();
        frame();
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter()  {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Startup main = new Startup();
            }
        });
    }
    public void frame() throws IOException {
        frame.setSize(1920, 1080);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        selection();
    }
    public void selection() throws IOException {
        background = ImageIO.read(new File("Images/ufo-1265186_1920.jpg"));
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setPreferredSize(new Dimension(1920, 1080));

        JLabel melee = new JLabel(new ImageIcon(new ImageIcon("Images/Melee/Shuriken.png")
                .getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        JLabel ranged = new JLabel(new ImageIcon(new ImageIcon("Images/Ranged/Ranged.png")
                .getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        JLabel support = new JLabel(new ImageIcon(new ImageIcon("Images/Support/Support.png")
                .getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        JLabel choose = new JLabel(new ImageIcon(new ImageIcon("Images/Words/choose char.png")
                .getImage().getScaledInstance(1600, 150, Image.SCALE_SMOOTH)));
        backgroundPanel.add(melee);
        backgroundPanel.add(ranged);
        backgroundPanel.add(support);
        backgroundPanel.add(choose);

        SpringLayout layout = new SpringLayout();
        backgroundPanel.setLayout(layout);
        frame.setContentPane(backgroundPanel);
        int width = (frame.getWidth() - 1500) / 4;
        int height = (frame.getHeight() - 450) / 2;

        layout.putConstraint(SpringLayout.WEST, choose, (frame.getWidth() - 1600) / 2, SpringLayout.WEST, backgroundPanel);
        layout.putConstraint(SpringLayout.NORTH, choose, 100, SpringLayout.NORTH, backgroundPanel);
        layout.putConstraint(SpringLayout.WEST, melee, width, SpringLayout.WEST, backgroundPanel);
        layout.putConstraint(SpringLayout.NORTH, melee, height, SpringLayout.NORTH, choose);
        layout.putConstraint(SpringLayout.WEST, ranged, width, SpringLayout.EAST, melee);
        layout.putConstraint(SpringLayout.NORTH, ranged, height, SpringLayout.NORTH, choose);
        layout.putConstraint(SpringLayout.WEST, support, width, SpringLayout.EAST, ranged);
        layout.putConstraint(SpringLayout.NORTH, support, height, SpringLayout.NORTH, choose);

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
            backgroundPanel.removeAll();
            frame.revalidate();
            frame.repaint();
            spawnCharacters();
        }
    }
    public void spawnCharacters() throws IOException {
        switch (playerOne) {
            case "melee" -> one = new Melee(frame);
            case "ranged" -> one = new Ranged(frame);
            case "support" -> one = new Support(frame);
        }
        switch (playerTwo) {
            case "melee" -> two = new Melee(frame);
            case "ranged" -> two = new Ranged(frame);
            case "support" -> two = new Support(frame);
        }
        players.add(one);
        players.add(two);
        backgroundPanel.add(one);
        backgroundPanel.add(two);
        frame.revalidate();
        frame.repaint();
        gameLoop();
    }
    public void gameLoop() {
        if (!frame.isShowing()) {
            System.out.println("ended");
            return;
        }
        for (Player player : players) {
            player.movement();
            System.out.println("running");
        }
        gamePanel.repaint();
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
