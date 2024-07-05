package view;

import interface_adapter.MainMenuViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "main menu";
    private final MainMenuViewModel mainMenuViewModel;

    private final JButton addBookButton;
    private final JButton addRentButton;
    private final JButton addPurchaseButton;

    public MainMenuView(MainMenuViewModel mainMenuViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;
        this.mainMenuViewModel.addPropertyChangeListener(this);

        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title Label
        JLabel title = new JLabel("Book Transaction Manager for Book Store");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title);

        add(Box.createRigidArea(new Dimension(0, 20))); // Add space between title and buttons

        // Add Book Button
        addBookButton = new JButton("Add Book Entry");
        addBookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addBookButton.addActionListener(this);
        add(addBookButton);

        add(Box.createRigidArea(new Dimension(0, 10))); // Add space between buttons

        // Add Rent Button
        addRentButton = new JButton("Rent Book Entry");
        addRentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRentButton.addActionListener(this);
        add(addRentButton);

        add(Box.createRigidArea(new Dimension(0, 10))); // Add space between buttons

        // Add Purchase Button
        addPurchaseButton = new JButton("Purchase Book Entry");
        addPurchaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addPurchaseButton.addActionListener(this);
        add(addPurchaseButton);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookButton) {
            System.out.println("Add Book Entry button clicked");
            // Handle Add Book Entry action
        } else if (e.getSource() == addRentButton) {
            System.out.println("Rent Book Entry button clicked");
            // Handle Rent Book Entry action
        } else if (e.getSource() == addPurchaseButton) {
            System.out.println("Purchase Book Entry button clicked");
            // Handle Purchase Book Entry action
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change updates from the ViewModel
        // For example, you can update button states based on the ViewModel state
    }
}
