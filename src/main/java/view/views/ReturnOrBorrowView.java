package view.views;

import interface_adapter.RentMenu.RentMenuController;
import interface_adapter.RentMenu.RentMenuState;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowController;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A panel representing the return or borrow view. It contains buttons to return the book, borrow the book
 * or cancel the operation. It listens to property changes
 * from the ReturnOrBorrowViewModel and updates the UI accordingly.
 */

public class ReturnOrBorrowView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "return or borrow";
    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private final ReturnOrBorrowController returnOrBorrowController;

    /**
     * Constructs a ReturnOrBorrowView with the specified returnOrBorrowViewModel and returnOrBorrowController.
     * Initializes the UI components and sets up listeners.
     *
     * @param returnOrBorrowViewModel the view model for the return or borrow view
     * @param returnOrBorrowController the controller to handle return or borrow actions
     */
    public ReturnOrBorrowView(ReturnOrBorrowViewModel returnOrBorrowViewModel, ReturnOrBorrowController returnOrBorrowController){
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
        this.returnOrBorrowViewModel.addPropertyChangeListener(this);
        this.returnOrBorrowController = returnOrBorrowController;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(returnOrBorrowViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton borrowBookButton = new JButton(returnOrBorrowViewModel.BORROW);
        buttons.add(borrowBookButton);
        JButton returnBookButton = new JButton(returnOrBorrowViewModel.RETURN);
        buttons.add(returnBookButton);
        JButton cancelButton = new JButton(returnOrBorrowViewModel.CANCEL_LABEL);
        buttons.add(cancelButton);

        borrowBookButton.addActionListener(this);
        cancelButton.addActionListener(this);
        returnBookButton.addActionListener(this);

        this.add(buttons);
        this.add(Box.createVerticalGlue());
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

    /**
     * Reacts to a button click that results in an ActionEvent.
     * Handles return, borrow, and cancel actions.
     *
     * @param e the action event triggered by button clicks
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (returnOrBorrowViewModel.RETURN.equals(e.getActionCommand())) {
            System.out.println("Return Book button clicked");
            returnOrBorrowController.returnBook();
        }else if (returnOrBorrowViewModel.BORROW.equals(e.getActionCommand())){
            System.out.println("Return Book button clicked");
            returnOrBorrowController.borrowBook();
        }else if (returnOrBorrowViewModel.CANCEL_LABEL.equals(e.getActionCommand())) {
            returnOrBorrowController.cancel();

        }
    }

    /**
     * Reacts to property changes in the ReturnOrBorrowViewModel.
     * Updates the UI fields based on the new state.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
