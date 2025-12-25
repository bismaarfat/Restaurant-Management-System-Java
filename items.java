package frenzyfood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class items {

    public items() {
        JFrame frameObj = new JFrame("Food App Menu");
        frameObj.setSize(1500, 800);
        frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameObj.setLocationRelativeTo(null); // Center on screen

        ImageIcon appIcon = new ImageIcon("/pics/project.jpg");
        frameObj.setIconImage(appIcon.getImage());

        // Create buttons
        JButton btn1 = createButton("Food Delivery", "/pics/btn1.jpg", e -> {
            new Frame2();
            frameObj.dispose();
        });

        JButton btn4 = createButton("Daily Deals", "/pics/btn4.jpeg", e -> {
            new F4();
            frameObj.dispose();
        });

     //   JButton btn2 = createButton("Cart history", "C:\\Users\\HS TRADER\\food app\\btn1.jpg", e -> {
        //    new EditDetails();
       //     frameObj.dispose();
      //  });

        // Create a panel with a 2x2 grid layout
        JPanel panel = new JPanel(new GridLayout(1, 2, 20, 20));
        panel.setOpaque(false);
        panel.add(btn1);
        panel.add(btn4);
      //  panel.add(btn2);
       // panel.add(new JPanel()); // Placeholder for layout balance

        // Background panel with custom image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("/pics/backs.jpg");
                Image backgroundImage = backgroundIcon.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout()); // Center content
        backgroundPanel.add(panel);

        // Add background panel to frame
        frameObj.setContentPane(backgroundPanel);
        frameObj.setVisible(true);
    }

    private JButton createButton(String text, String imagePath, ActionListener listener) {
        ImageIcon icon = new ImageIcon(imagePath);
        JButton button = new JButton(text, icon);
        button.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button.setForeground(Color.ORANGE);
        button.setPreferredSize(new Dimension(300, 200));
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.addActionListener(listener);
        return button;
    }
}
