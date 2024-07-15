package view.views;

import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A panel representing the main menu view. It contains buttons for various actions
 * such as adding a book, renting a book, purchasing a book, and calculating revenue.
 * It listens to property changes from the MainMenuViewModel and updates the UI accordingly.
 */
public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "main menu";
    private final MainMenuViewModel mainMenuViewModel;
    private final ViewManagerModel viewManagerModel;
    private final AddBookViewModel addBookViewModel;
    private final RentMenuViewModel rentMenuViewModel;

    private final JButton addBookButton;
    private final JButton addRentButton;
    private final JButton addPurchaseButton;
    private final JButton calculateRevenueButton;

    /**
     * Constructs a MainMenuView with the specified MainMenuViewModel, AddBookViewModel, and ViewManagerModel.
     * Initializes the UI components and sets up listeners.
     *
     * @param mainMenuViewModel the view model for the main menu view
     * @param addBookViewModel the view model for adding books
     * @param viewManagerModel the view manager model to manage active views
     */
    public MainMenuView(MainMenuViewModel mainMenuViewModel, AddBookViewModel addBookViewModel, ViewManagerModel viewManagerModel, RentMenuViewModel rentMenuViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;
        this.mainMenuViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;
        this.addBookViewModel = addBookViewModel;
        this.rentMenuViewModel = rentMenuViewModel;

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

    /**
     * Returns the preferred size of this component.
     *
     * @return the preferred size of this component
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

    /**
     * Reacts to a button click that results in an ActionEvent.
     * Handles actions for add book, add rent, add purchase, and calculate revenue.
     *
     * @param evt the action event triggered by button clicks
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (mainMenuViewModel.ADD_BOOK.equals(evt.getActionCommand())) {
            System.out.println("Add Book Entry button clicked");
            viewManagerModel.setActiveView(addBookViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        } else if (mainMenuViewModel.ADD_RENT.equals(evt.getActionCommand())) {
            System.out.println("Rent Book Entry button clicked");
            viewManagerModel.setActiveView(rentMenuViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
            // Handle Rent Book Entry action
        } else if (mainMenuViewModel.ADD_PURCHASE.equals(evt.getActionCommand())) {
            System.out.println("Purchase Book Entry button clicked");
            // Handle Purchase Book Entry action
        } else if (mainMenuViewModel.CALCULATE_REVENUE.equals(evt.getActionCommand())) {
            System.out.println("Calculate Revenue");
        }
    }

    /**
     * Reacts to property changes in the MainMenuViewModel.
     * Updates the UI based on the new state.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change updates from the ViewModel
        // For example, you can update button states based on the ViewModel state
    }
}
