package frenzyfood;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

public final class loginpage extends JFrame {

    public loginpage() {
        showSplashScreen();
    }

    public loginpage(boolean directLogin) {
        if (directLogin) {
            showLoginPage();
        } else {
            showSplashScreen();
        }
    }

    public void showSplashScreen() {

    JFrame splash = new JFrame();

    splash.setUndecorated(true);   // FIX → Always before setVisible
    splash.setSize(1500, 800);
    splash.setLocationRelativeTo(null);

    JPanel panel = new BackgroundPanel("/pics/frenzyfood.png");
    splash.add(panel);

    splash.setVisible(true);

    new Timer().schedule(new TimerTask() {
        @Override
        public void run() {
            SwingUtilities.invokeLater(() -> {
                splash.dispose();
                showLoginPage();
            });
        }
    }, 3000);
}


    private void showLoginPage() {
        JFrame loginFrame = new JFrame("Login - Food Frenzy");
        loginFrame.setSize(1400, 900);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new BackgroundPanel("/pics/logback.jpg");
        backgroundPanel.setLayout(new GridBagLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(true);
        formPanel.setBackground(new Color(255, 255, 255, 200));
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 123, 255), 2),
                BorderFactory.createEmptyBorder(30, 50, 30, 50)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.BOLD, 18);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 18);

        JLabel title = new JLabel("Login to Food Frenzy");
        title.setFont(new Font("Georgia", Font.BOLD, 32));
        title.setForeground(Color.DARK_GRAY);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(title, gbc);

        // Username Label and Field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(labelFont);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(userLabel, gbc);

        JTextField userTextField = new JTextField(15);
        userTextField.setFont(fieldFont);
        userTextField.setToolTipText("Enter your username");
        userTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        gbc.gridx = 1;
        formPanel.add(userTextField, gbc);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(passwordLabel, gbc);

        JPasswordField passwordTextField = new JPasswordField(15);
        passwordTextField.setFont(fieldFont);
        passwordTextField.setToolTipText("Enter your password");
        passwordTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        gbc.gridx = 1;
        formPanel.add(passwordTextField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);

        JButton loginButton = new JButton("Login");
        styleButton(loginButton, buttonFont);
        loginButton.addActionListener((ActionEvent e) -> {
            String username = userTextField.getText().trim();
            String password = new String(passwordTextField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(loginFrame, "Please enter your credentials.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // No database check — just a placeholder success
                JOptionPane.showMessageDialog(loginFrame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loginFrame.dispose();
                new items(); // Your app main window
            }
        });

        JButton signUpButton = new JButton("Sign Up");
        styleButton(signUpButton, buttonFont);
        signUpButton.addActionListener((ActionEvent e) -> {
            new SignUpPage().show();
            loginFrame.dispose();
        });

        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        backgroundPanel.add(formPanel);
        loginFrame.add(backgroundPanel);
        loginFrame.setVisible(true);
    }

    private void styleButton(JButton button, Font font) {
        button.setFont(font);
        button.setBackground(new Color(255, 140, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        new loginpage();
    }
}

