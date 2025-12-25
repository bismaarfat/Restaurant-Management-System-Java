package frenzyfood;

import frenzyfood.data.CartData;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JButton;

public class kfc {

    public kfc() {
    	
        JFrame frame = new JFrame("KFC Menu");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("/pics/project.jpg").getImage());

        JPanel backgroundPanel;
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getResource("/pics/KFC.jpg"));
                g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
               
    
};
        backgroundPanel.setLayout(new GridBagLayout());

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);

        String base = "/Users/bismaarfat/NetBeansProjects/cravingfood/pics";
        addItem(contentPanel, base + "KFC1.png", "Zinger Stacker", 620, 0);
        addItem(contentPanel, base + "KFC2.png", "Chicken & Chips", 590, 1);
        addItem(contentPanel, base + "KFC3.png", "3 Pcs Chicken", 650, 2);
        addItem(contentPanel, base + "KFC4.png", "Xtreme Duo Box", 1490, 3);
        addItem(contentPanel, base + "KFC5.png", "Jalapeno Cheese Burger", 390, 4);

        JScrollPane scroll = new JScrollPane(contentPanel);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; gbc.weighty = 1.0;
        backgroundPanel.add(scroll, gbc);

        JButton back = new JButton("Back");
        back.setBackground(Color.ORANGE);
        back.addActionListener(e -> {
            new Frame2(); // Go back
            frame.dispose();
        });

        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(back, gbc);

        frame.setContentPane(backgroundPanel);
        frame.setVisible(true);
    }

    private void addItem(JPanel panel, String imagePath, String name, int price, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.gridy = y;

        // Image
        gbc.gridx = 0;
        JLabel img = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        panel.add(img, gbc);

        // Text
        gbc.gridx = 1;
        JLabel text = new JLabel("<html>" + name + "<br>Rs " + price + "</html>");
        text.setFont(new Font("Times New Roman", Font.BOLD, 25));
        text.setForeground(Color.ORANGE);
        panel.add(text, gbc);

        // Quantity
        gbc.gridx = 2;
        JPanel qtyPanel = new JPanel();
        qtyPanel.setOpaque(false);
        JLabel qtyLabel = new JLabel("1");
        qtyLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JButton minus = new JButton("-"), plus = new JButton("+");

        minus.addActionListener(e -> {
            int q = Integer.parseInt(qtyLabel.getText());
            if (q > 1) qtyLabel.setText(String.valueOf(q - 1));
        });
        plus.addActionListener(e -> {
            int q = Integer.parseInt(qtyLabel.getText());
            qtyLabel.setText(String.valueOf(q + 1));
        });

        qtyPanel.add(minus); qtyPanel.add(qtyLabel); qtyPanel.add(plus);
        panel.add(qtyPanel, gbc);

        // Order Now Button
        gbc.gridx = 3;
        JButton orderBtn = new JButton("Order Now");
        orderBtn.setBackground(Color.ORANGE);
        orderBtn.setFont(new Font("Arial", Font.BOLD, 18));
        orderBtn.addActionListener((ActionEvent e) -> {
            int qty;
            qty = Integer.parseInt(qtyLabel.getText());
            CartData.cartItems.add(new Item(name, price, qty));
            JOptionPane.showMessageDialog(null, "Order placed successfully!");
        });
        panel.add(orderBtn, gbc);
    }

    public static class Item {
        private final String label;
        private final int price;
        private final int quantity;

        public Item(String label, int price, int quantity) {
            this.label = label;
            this.price = price;
            this.quantity = quantity;
        }

        public String getLabel() { return label; }
        public int getPrice() { return price; }
        public int getQuantity() { return quantity; }
    }
}

