package view;

import interface_adapter.add_book.AddBookPresenter;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.ViewManagerModel;
import use_case.AddBookUseCase;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "main menu";
    private final MainMenuViewModel mainMenuViewModel;
    private final AddBookUseCase addBookUseCase;

    private final JButton addBookButton;
    private final JButton addRentButton;
    private final JButton addPurchaseButton;
    private final JButton calculateRevenueButton;

    public MainMenuView(MainMenuViewModel mainMenuViewModel, AddBookViewModel addBookViewModel, ViewManagerModel viewManagerModel) {
        this.mainMenuViewModel = mainMenuViewModel;
        this.mainMenuViewModel.addPropertyChangeListener(this);
        AddBookPresenter presenter = new AddBookPresenter(addBookViewModel, viewManagerModel);
        this.addBookUseCase = new AddBookUseCase(presenter);

        // Set layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title Label
        JLabel title = new JLabel(mainMenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        this.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between title and buttons

        // Add Book Button
        addBookButton = new JButton(mainMenuViewModel.ADD_BOOK);
        addBookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addBookButton.addActionListener(this);
        this.add(addBookButton);

        this.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between buttons

        // Add Rent Button
        addRentButton = new JButton(mainMenuViewModel.ADD_RENT);
        addRentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRentButton.addActionListener(this);
        this.add(addRentButton);

        this.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between buttons

        // Add Purchase Button
        addPurchaseButton = new JButton(mainMenuViewModel.ADD_PURCHASE);
        addPurchaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addPurchaseButton.addActionListener(this);
        this.add(addPurchaseButton);

        this.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between buttons

        // Add Calculate Revenue Button
        calculateRevenueButton = new JButton(mainMenuViewModel.CALCULATE_REVENUE);
        calculateRevenueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateRevenueButton.addActionListener(this);
        this.add(calculateRevenueButton);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (mainMenuViewModel.ADD_BOOK.equals(evt.getActionCommand())) {
            System.out.println("Add Book Entry button clicked");
            addBookUseCase.addBook();
        } else if (mainMenuViewModel.ADD_RENT.equals(evt.getActionCommand())) {
            System.out.println("Rent Book Entry button clicked");
            // Handle Rent Book Entry action
        } else if (mainMenuViewModel.ADD_PURCHASE.equals(evt.getActionCommand())) {
            System.out.println("Purchase Book Entry button clicked");
            // Handle Purchase Book Entry action
        } else if (mainMenuViewModel.CALCULATE_REVENUE.equals(evt.getActionCommand())) {
            System.out.println("Calculate Revenue");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change updates from the ViewModel
        // For example, you can update button states based on the ViewModel state
    }
}