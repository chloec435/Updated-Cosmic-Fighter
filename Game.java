import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private JFrame frame;
    private int map[][];
    public Game() {
        startingScreen();
//        topPanel();
        setVisible(true);
        // main window 
        // Function to set the default look  
        // and feel decorated status of JFrame.
    }
    public void topPanel() {
//        JPanel top = new JPanel();
//        top.setSize(1720,50);
        SpringLayout layout = new SpringLayout();
//        top.setLayout(layout);
//        top.setBackground(Color.RED);
//        getContentPane().add(top, BorderLayout.NORTH);
        setLayout(layout);
        JButton instructions = new JButton();
        instructions.setBackground(Color.BLUE);
        add(instructions);
        layout.putConstraint(SpringLayout.EAST, instructions, 100, SpringLayout.EAST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, instructions, 100, SpringLayout.NORTH, getContentPane());
//        layout.putConstraint(SpringLayout.WEST, instructions, 50, SpringLayout.WEST, getContentPane());
//        layout.putConstraint(SpringLayout.SOUTH, instructions, 50, SpringLayout.SOUTH, getContentPane());
    }
    public void startingScreen() {
        setSize(1720,960);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Component b1 = new JButton("b1");
        Component b2 = new JButton("b2");
        Component b3 = new JButton("b3");
        Component b4 = new JButton("b4");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        layout.putConstraint(SpringLayout.WEST, b1, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, b1, 10, SpringLayout.NORTH, getContentPane());
        layout.putConstraint(SpringLayout.WEST, b2, 50, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, b2, 10, SpringLayout.SOUTH, b1);
        layout.putConstraint(SpringLayout.WEST, b3, 75, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, b3, 10, SpringLayout.SOUTH, b2);
        layout.putConstraint(SpringLayout.WEST, b4, 15, SpringLayout.EAST, b1);
        layout.putConstraint(SpringLayout.NORTH, b4, 10, SpringLayout.NORTH, getContentPane());
    }
    public static void main (String[] args) {
        Game game = new Game();
    }

}
