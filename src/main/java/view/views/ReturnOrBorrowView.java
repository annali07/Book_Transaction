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
 * The ReturnOrBorrowView class represents the user interface for deciding between returning or borrowing a book.
 * It handles user interactions for selecting to return or borrow a book.
 *
 */
public class ReturnOrBorrowView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "return or borrow";
    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private final ReturnOrBorrowController returnOrBorrowController;

    /**
     * Constructs a ReturnOrBorrowView object with the specified view model and controller.
     *
     * @param returnOrBorrowViewModel the view model for returning or borrowing a book
     * @param returnOrBorrowController the controller for returning or borrowing a book
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

    /**
     * Gets the preferred size for this component.
     *
     * @return the preferred size
     */
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }


    /**
     * Handles action events for the borrow, return, and cancel buttons.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (returnOrBorrowViewModel.RETURN.equals(e.getActionCommand())) {
            System.out.println("Return CommonBook button clicked");
            returnOrBorrowController.returnBook();
        }else if (returnOrBorrowViewModel.BORROW.equals(e.getActionCommand())){
            System.out.println("Return CommonBook button clicked");
            returnOrBorrowController.borrowBook();
        }else if (returnOrBorrowViewModel.CANCEL_LABEL.equals(e.getActionCommand())) {
            returnOrBorrowController.cancel();

        }
    }

    /**
     * Handles property change events from the view model.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
