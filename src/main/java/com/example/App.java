package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple Desktop Application
 *
 */
public class App extends JFrame
{
    private JLabel messageLabel;
    private JButton clickButton;
    private int clickCount = 0;
    
    public App() {
        // Set up the frame
        setTitle("Simple Desktop Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create components
        messageLabel = new JLabel("Welcome to the Simple Desktop App!", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        clickButton = new JButton("Click Me!");
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                messageLabel.setText("Button clicked " + clickCount + " times!");
            }
        });
        
        // Set up layout
        setLayout(new BorderLayout());
        add(messageLabel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clickButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public static void main( String[] args )
    {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App app = new App();
                app.setVisible(true);
                System.out.println("Simple Desktop Application started successfully!");
            }
        });
    }
}
