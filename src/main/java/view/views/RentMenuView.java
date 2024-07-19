
package view.views;

import interface_adapter.RentMenu.RentMenuController;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.RentMenu.RentMenuState;
import view.helper_functions.LabelTextPanel;
import view.helper_functions.LabelTextPanelInt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A panel representing the rent menu view. It contains input fields for bookID,
 * and buttons to search book or cancel the process. It listens to property changes
 * from the RentMenuViewModel and updates the UI accordingly.
 */
public class RentMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "rent book menu";
    private final RentMenuViewModel rentMenuViewModel;
    private final RentMenuController rentMenuController;

    /**
     * Input bookID given to the manager
     */
    final JTextField isbookIDInputField = new JTextField(15);
    private final JTextField isbookIDErrorField = new JTextField(15);

    /**
     * Constructs a rentMenuView with the specified rentMenuViewModel and rentMenuController.
     * Initializes the UI components and sets up listeners.
     *
     * @param rentMenuViewModel the view model for the rent menu view
     * @param rentMenuController the controller to handle rent menu actions
     */
    public RentMenuView(RentMenuViewModel rentMenuViewModel, RentMenuController rentMenuController) {
        this.rentMenuViewModel = rentMenuViewModel;
        this.rentMenuViewModel.addPropertyChangeListener(this);
        this.rentMenuController = rentMenuController;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(rentMenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        LabelTextPanelInt isbookIDInfo = new LabelTextPanelInt(
                new JLabel(rentMenuViewModel.BOOKID_LABEL), isbookIDInputField);
        LabelTextPanel isbookIDErrorInfo = new LabelTextPanel(
                new JLabel(rentMenuViewModel.ERROR_MEESAGE), isbookIDErrorField);
        this.add(isbookIDInfo);
        this.add(isbookIDErrorInfo);
        isbookIDErrorField.setText("Input is empty: Please enter a book ID");


        this.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between title and buttons

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton searchBookButton = new JButton(rentMenuViewModel.SEARCH_LABEL);
        buttons.add(searchBookButton);
        JButton cancelButton = new JButton(rentMenuViewModel.CANCEL_LABEL);
        buttons.add(cancelButton);

        searchBookButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.add(buttons);
        this.add(Box.createVerticalGlue());
        resetFields();

        isbookIDInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                RentMenuState currentState = rentMenuViewModel.getState();
                String text = isbookIDInputField.getText();

                // Check if text is empty or not a valid integer
                if (!text.isEmpty()) {
                    isbookIDErrorField.setText("");
                    try {
                        int bookID = Integer.parseInt(text);
                        currentState.setBookID(bookID);
                        rentMenuViewModel.setState(currentState);
                    } catch (NumberFormatException ex) {
                        // Handle invalid input if necessary
                        isbookIDErrorField.setText("Invalid input: Please enter a valid number");
                    }
                } else {
                    isbookIDErrorField.setText("Input is empty: Please enter a book ID");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {}
        });

    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

    /**
     * Reacts to a button click that results in an ActionEvent.
     * Handles search and cancel actions.
     *
     * @param e the action event triggered by button clicks
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (rentMenuViewModel.SEARCH_LABEL.equals(e.getActionCommand())) {
            System.out.println("Search Book button clicked");
            RentMenuState state = rentMenuViewModel.getState();
            if (state == null) {
                throw new IllegalStateException("RentMenuState is null");
            }
            int bookID = state.getBookID();
            if (bookID == 0) {
                System.out.println("bookID is null");
                return;
            }

            boolean indicator = rentMenuController.execute(bookID);

            if (!indicator){
                isbookIDErrorField.setText("There is no such book in library.");
            }

        }else if (rentMenuViewModel.CANCEL_LABEL.equals(e.getActionCommand())) {
            resetFields();
            rentMenuController.cancel();
        }

    }

    /**
     * Reacts to property changes in the RentMenuViewModel.
     * Updates the UI fields based on the new state.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        RentMenuState state = (RentMenuState) evt.getNewValue();
        setFields(state);
    }

    /**
     * Updates the input fields based on the provided RentMenuState.
     *
     * @param state the new state to set in the input fields
     */
    private void setFields(RentMenuState state) {
        isbookIDInputField.setText(String.valueOf(state.getBookID()));

    }

    /**
     * Clear the input fields
     *
     */
    private void resetFields() {
        this.isbookIDInputField.setText("");
        this.isbookIDErrorField.setText("");
    }

}

