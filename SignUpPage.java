package frenzyfood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SignUpPage {

    public SignUpPage() {
        // No database code
    }

    public void show() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setSize(1400, 900);
        signUpFrame.setLocationRelativeTo(null);

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/pics/ii.jpg"));

        Image backgroundImage = backgroundImageIcon.getImage();

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(true);
        formPanel.setBackground(new Color(255, 255, 255, 200));
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.ORANGE, 2),
                BorderFactory.createEmptyBorder(30, 40, 30, 40)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.BOLD, 18);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 18);

        JLabel userLabel = new JLabel("New Username:");
        userLabel.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(userLabel, gbc);

        JTextField newUserTextField = new JTextField(20);
        newUserTextField.setFont(fieldFont);
        newUserTextField.setToolTipText("Username must be at least 8 characters (no numbers)");
        newUserTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        gbc.gridx = 1;
        formPanel.add(newUserTextField, gbc);

        JLabel passwordLabel = new JLabel("New Password:");
        passwordLabel.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(passwordLabel, gbc);

        JPasswordField newPasswordTextField = new JPasswordField(20);
        newPasswordTextField.setFont(fieldFont);
        newPasswordTextField.setToolTipText("Password must be 4-8 characters long");
        newPasswordTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        gbc.gridx = 1;
        formPanel.add(newPasswordTextField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);

        JButton signUpButton = new JButton("Sign Up");
        styleButton(signUpButton, buttonFont);
        signUpButton.addActionListener((ActionEvent e) -> {
            String username = newUserTextField.getText().trim();
            String password = new String(newPasswordTextField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(signUpFrame, "Please enter both username and password.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (username.length() < 3 || username.chars().anyMatch(Character::isDigit)) {
                JOptionPane.showMessageDialog(signUpFrame, "Username must be at least 3 characters and contain no digits.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (password.length() < 4 || password.length() > 8) {
                JOptionPane.showMessageDialog(signUpFrame, "Password must be between 4 and 8 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // No database call — just success message and go to login
            JOptionPane.showMessageDialog(signUpFrame, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            signUpFrame.dispose();
            new loginpage(true);
        });

        JButton backButton = new JButton("Back to Login");
        styleButton(backButton, buttonFont);
        backButton.addActionListener((ActionEvent e) -> {
            new loginpage(true);
            signUpFrame.dispose();
        });

        buttonPanel.add(signUpButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        backgroundPanel.add(formPanel);
        signUpFrame.add(backgroundPanel);
        signUpFrame.setVisible(true);
    }

    private void styleButton(JButton button, Font font) {
        button.setFont(font);
        button.setBackground(new Color(255, 140, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        button.setPreferredSize(new Dimension(180, 45));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}


