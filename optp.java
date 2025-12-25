package frenzyfood;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

 class optp {
	    optp(){
	        JFrame frame = new JFrame("OPTP Menu");
	        ImageIcon iconn = new ImageIcon("C:\\Users\\HS TRADER\\food app\\project.jpg");
	        frame.setIconImage(iconn.getImage());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1500, 800);

	        // Create a panel with a background image
	        JPanel backgroundPanel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\HS TRADER\\food app\\OB.gif");
	                Image backgroundImage = backgroundIcon.getImage();
	                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	            }
	        };
	        backgroundPanel.setLayout(new GridBagLayout());

	        // Create a panel with GridBagLayout for the content
	        JPanel contentPanel = new JPanel();
	        contentPanel.setLayout(new GridBagLayout());
	        contentPanel.setOpaque(false); // Make it transparent to show the background

	        // Create a cartItems list
	        ArrayList<Item3> cartItems = new ArrayList<>();

	        // Load the images and create labels and buttons
	        String basePath = "/Users/bismaarfat/NetBeansProjects/cravingfood/pics";
	        addItem3(contentPanel, cartItems, basePath + "O1.png", "Chicken Mac", 520, 0);
	        addItem3(contentPanel, cartItems, basePath + "O2.png", "Happy Meal Chicken McNuggets", 999, 1);
	        addItem3(contentPanel, cartItems, basePath + "O3.png", "Double Quarter Pounder Meal", 650, 2);
	        addItem3(contentPanel, cartItems, basePath + "O4.png", "McArabia Meal", 749, 3);
	        addItem3(contentPanel, cartItems, basePath + "O5.png", "Vanilla Cone", 290, 4);

	        // Add the content panel to a JScrollPane
	        JScrollPane scrollPane = new JScrollPane(contentPanel);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        scrollPane.setOpaque(false); // Make it transparent to show the background
	        scrollPane.getViewport().setOpaque(false); // Make it transparent to show the background

	        // Add the JScrollPane to the background panel
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.BOTH;
	        gbc.weightx = 1.0;
	        gbc.weighty = 1.0;
	        backgroundPanel.add(scrollPane, gbc);

	        // Add a back button at the end
	        JButton backButton = new JButton("Back");
	        backButton.setBackground(Color.ORANGE);
	        backButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	              //  frame.dispose();
	                new Frame2();
	                frame.dispose();
	            }
	        });
	        gbc.gridy = 1;
	        gbc.weighty = 0;
	        gbc.anchor = GridBagConstraints.SOUTHEAST;
	        gbc.insets = new Insets(10, 10, 10, 10);
	        backButton.setPreferredSize(new Dimension(100, 30));
	        backgroundPanel.add(backButton, gbc);

	        // Add the background panel to the frame
	        frame.setContentPane(backgroundPanel);

	        // Set the frame visibility to true
	        frame.setVisible(true);
	    }

	    private static void addItem3(JPanel panel, ArrayList<Item3> cartItems, String imagePath, String label, int price, int gridy) {
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 2, 10, 10);
	        gbc.gridx = 0;
	        gbc.gridy = gridy;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 0.5;

	        // Load the image
	        ImageIcon originalIcon = new ImageIcon(imagePath);
	        Image originalImage = originalIcon.getImage();
	        Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Adjust width and height as needed
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);

	        // Create a label with the resized image
	        JLabel imageLabel = new JLabel(resizedIcon);
	        panel.add(imageLabel, gbc);

	        // Create a label with the image
	        gbc.gridx = 1;
	        JLabel textLabel = new JLabel("<html>" + label + "<br>Rs " + price + "</html>");
	        textLabel.setForeground(Color.BLACK); // Change the color to white
	        textLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
	        panel.add(textLabel, gbc);

	        gbc.gridx = 2;
	        // Create a panel for quantity controls
	        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
	        quantityPanel.setOpaque(false); // Make it transparent

	        JButton subtractButton = new JButton("-");
	        subtractButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        subtractButton.setPreferredSize(new Dimension(45, 30));
	        subtractButton.setForeground(Color.BLACK);
	        subtractButton.setBackground(Color.ORANGE);
	        quantityPanel.add(subtractButton);

	        JLabel quantityLabel = new JLabel("1");
	        quantityLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        quantityLabel.setForeground(Color.BLACK);
	        quantityPanel.add(quantityLabel);

	        JButton addButton = new JButton("+");
	        addButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        addButton.setPreferredSize(new Dimension(45, 30));
	        addButton.setForeground(Color.BLACK);
	        addButton.setBackground(Color.ORANGE);
	        quantityPanel.add(addButton);

	        subtractButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int quantity = Integer.parseInt(quantityLabel.getText());
	                if (quantity > 1) {
	                    quantity--;
	                    quantityLabel.setText(String.valueOf(quantity));
	                }
	            }
	        });

	        addButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int quantity = Integer.parseInt(quantityLabel.getText());
	                quantity++;
	                quantityLabel.setText(String.valueOf(quantity));
	            }
	        });

	        panel.add(quantityPanel, gbc);

	        gbc.gridx = 3;
	        JButton addToCartButton = new JButton("Add to Cart");
	        addToCartButton.setBackground(Color.ORANGE);
	        addToCartButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        addToCartButton.setPreferredSize(new Dimension(120, 30));
	        panel.add(addToCartButton, gbc);

	        addToCartButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int quantity = Integer.parseInt(quantityLabel.getText());
	                cartItems.add(new Item3(label, price, quantity));
	                showCart3(cartItems);
	            }
	        });

	        gbc.gridx = 4;
	        JButton orderNowButton = new JButton("Order Now");
	        orderNowButton.setBackground(Color.ORANGE);
	        orderNowButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        orderNowButton.setPreferredSize(new Dimension(120, 30));
	        panel.add(orderNowButton, gbc);

	        orderNowButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int quantity = Integer.parseInt(quantityLabel.getText());
	                cartItems.add(new Item3(label, price, quantity));
	                int totalBill = calculateTotalBill71(cartItems);
	                JOptionPane.showMessageDialog(null, "Total Bill: Rs " + totalBill, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
	                JOptionPane.showMessageDialog(null, "Order placed successfully!", "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);
	                cartItems.clear();
	            }
	        });
	    }

	    private static int calculateTotalBill71(ArrayList<Item3> cartItems) {
	        int totalBill = 0;
	        for (Item3 item : cartItems) {
	            totalBill += item.getPrice() * item.getQuantity();
	        }
	        return totalBill;
	    }

	    private static void showCart3(ArrayList<Item3> cartItems) {
	        JFrame cartFrame = new JFrame("Your Cart");
	        cartFrame.setSize(500, 500);
	        cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        ImageIcon iconn = new ImageIcon("C:\\Users\\HS TRADER\\food app\\project.jpg");
	        cartFrame.setIconImage(iconn.getImage());
	        cartFrame.setBackground(Color.orange);

	        JPanel cartPanel = new JPanel();
	        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

	        int totalBill = 0;
	        for (Item3 item : cartItems) {
	            JLabel itemLabel = new JLabel(item.getLabel() + " x " + item.getQuantity() + " = Rs " + (item.getPrice() * item.getQuantity()));
	            itemLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
	            cartPanel.add(itemLabel);
	            totalBill += item.getPrice() * item.getQuantity();
	        }

	        JLabel totalLabel = new JLabel("Total Bill: Rs " + totalBill);
	        totalLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        cartPanel.add(totalLabel);

	        // Create a panel for buttons
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

	        JButton discardButton = new JButton("Discard");
	        discardButton.setBackground(Color.ORANGE);
	        discardButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        discardButton.setPreferredSize(new Dimension(120, 30));
	        buttonPanel.add(discardButton);

	        JButton orderNowButton = new JButton("Order Now");
	        orderNowButton.setBackground(Color.ORANGE);
	        orderNowButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        orderNowButton.setPreferredSize(new Dimension(120, 30));
	        buttonPanel.add(orderNowButton);

	        // Add action listeners for the buttons
	        discardButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            //	cartFrame.dispose();
	                cartItems.clear();
	                cartFrame.dispose();
	            }
	        });

	        orderNowButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int totalBill = calculateTotalBill71(cartItems);
	                JOptionPane.showMessageDialog(cartFrame, "Total Bill: Rs " + totalBill, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
	                JOptionPane.showMessageDialog(cartFrame, "Order placed successfully!", "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);
	                cartItems.clear();
	                cartFrame.dispose();
	            }
	        });

	        // Add the button panel to the cart panel
	        cartPanel.add(buttonPanel);

	        cartFrame.add(new JScrollPane(cartPanel));
	        cartFrame.setVisible(true);
	    }

	    static class Item3 {
	        private String label;
	        private int price;
	        private int quantity;

	        public Item3(String label, int price, int quantity) {
	            this.label = label;
	            this.price = price;
	            this.quantity = quantity;
	        }

	        public String getLabel() {
	            return label;
	        }

	        public int getPrice() {
	            return price;
	        }

	        public int getQuantity() {
	            return quantity;
	        }
	    }
}
