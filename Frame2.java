package frenzyfood;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
class Frame2{
public Frame2(){
        JFrame frameObj = new JFrame();
        frameObj.setLayout(new BorderLayout());

        // Create the title label
        JLabel titleLabel = new JLabel("Top Brands", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        titleLabel.setForeground(Color.ORANGE);

        // Add the title label to the top of the frame
        JPanel title =new JPanel();
        title.add(titleLabel);
        title.setOpaque(false);
        // frameObj.add(titleLabel, BorderLayout.NORTH);

        ImageIcon iconn = new ImageIcon("/pics/project.jpg");
        frameObj.setIconImage(iconn.getImage());

        // Create buttons with images and text
        ImageIcon icon = new ImageIcon("/pics/KFC.jpg");
        JButton btn1 = new JButton("KFC", icon);
        btn1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        btn1.setForeground(Color.ORANGE);
        btn1.setBackground(Color.RED);
        btn1.setPreferredSize(new Dimension(200, 200));
        btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn1.setHorizontalTextPosition(SwingConstants.CENTER);
        btn1.addActionListener((ActionEvent e) -> {
            //  frameObj.dispose();
            new kfc();
            frameObj.dispose();
        });

        ImageIcon icon2 = new ImageIcon("/pics/OPTP.jpeg");
        JButton btn2 = new JButton("OPTP", icon2);
        btn2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        btn2.setPreferredSize(new Dimension(200, 200));
        btn2.setForeground(Color.BLACK);
        btn2.setBackground(Color.ORANGE);
        btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn2.setHorizontalTextPosition(SwingConstants.CENTER);
        btn2.addActionListener((ActionEvent e) -> {
            //  frameObj.dispose();
            new optp();
            frameObj.dispose();
        });

        ImageIcon icon4 = new ImageIcon("/pics//BK.png");
        JButton btn4 = new JButton("Bundu Khan",icon4);
        btn4.setFont(new Font("Times New Roman", Font.BOLD, 30));
        btn4.setPreferredSize(new Dimension(200, 200));
        btn4.setForeground(Color.ORANGE);
        btn4.setBackground(Color.RED);
        btn4.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn4.setHorizontalTextPosition(SwingConstants.CENTER);
        btn4.addActionListener((ActionEvent e) -> {
            // frameObj.dispose();
            new bundukhan();
            frameObj.dispose();
        });

        // Additional Buttons
        ImageIcon iconKFC = new ImageIcon("/pics/BR.jpeg");
        JButton btn3 = new JButton("Baskin Robin", iconKFC);
        btn3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        btn3.setPreferredSize(new Dimension(200, 200));
        btn3.setBackground(Color.PINK);
        btn3.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn3.setHorizontalTextPosition(SwingConstants.CENTER);
        btn3.addActionListener((ActionEvent e) -> {
            //  frameObj.dispose();
            new baskinrobin();
            frameObj.dispose();
        });

        ImageIcon iconMcDonalds = new ImageIcon("/pics/MD.png");
        JButton btnMcDonalds = new JButton("McDonald's", iconMcDonalds);
        btnMcDonalds.setFont(new Font("Times New Roman", Font.BOLD, 30));
        btnMcDonalds.setPreferredSize(new Dimension(200, 200));
        btnMcDonalds.setBackground(Color.RED);
        btnMcDonalds.setForeground(Color.ORANGE);
        btnMcDonalds.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnMcDonalds.setHorizontalTextPosition(SwingConstants.CENTER);
        btnMcDonalds.addActionListener((ActionEvent e) -> {
            // frameObj.dispose();
            new macDonalds();
            frameObj.dispose();
        });

        ImageIcon iconPapaJohns = new ImageIcon("/pics/PJ.png");
        JButton btnPapaJohns = new JButton("Papa John's", iconPapaJohns);
        btnPapaJohns.setFont(new Font("Times New Roman", Font.BOLD, 30));
        btnPapaJohns.setPreferredSize(new Dimension(200, 200));
        btnPapaJohns.setBackground(Color.GRAY);
        btnPapaJohns.setForeground(Color.BLACK);
        btnPapaJohns.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPapaJohns.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPapaJohns.addActionListener((ActionEvent e) -> {
            // frameObj.dispose();
            new papajohns();
            frameObj.dispose();
        });

        // Back Button
        JButton btnBack = new JButton(new ImageIcon("/pics/bac.jpeg"));
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 30));
        btnBack.setPreferredSize(new Dimension(300, 70));
        //   btnBack.setVerticalTextPosition(SwingConstants.CENTER);
        btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
        btnBack.addActionListener((ActionEvent e) -> {
            new items();
            frameObj.dispose();
            // new items();
        });

        // Create a JPanel for buttons and set its layout
        JPanel panel = new JPanel();
        panel.setOpaque(false); // Make the panel transparent
        panel.setLayout(new GridLayout(2, 3, 20, 20));
        // Add buttons to the panel
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn4);
        panel.add(btn3);
        panel.add(btnMcDonalds);
        panel.add(btnPapaJohns);

        // Create a separate panel for the Back button
        JPanel backPanel = new JPanel();
        backPanel.setOpaque(false);
        backPanel.add(btnBack);

        // Create a custom JPanel for the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("/pics/aa.png");
                Image backgroundImage = backgroundIcon.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout()); // Use BorderLayout for main background panel

        // Add the button panels to the background panel
        backgroundPanel.add(title, BorderLayout.NORTH);
        backgroundPanel.add(panel, BorderLayout.CENTER);
        backgroundPanel.add(backPanel, BorderLayout.SOUTH);

        // Add the background panel to the frame
        frameObj.add(backgroundPanel, BorderLayout.CENTER);
        frameObj.setSize(1500, 800); // Increased frame size to accommodate the buttons
        frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameObj.setVisible(true);

    }
}


