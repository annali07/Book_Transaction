package view.views;

import interface_adapter.add_book.AddBookState;
import interface_adapter.purchase_book.PurchaseControllor;
import interface_adapter.purchase_book.PurchaseState;
import interface_adapter.purchase_book.PurchaseViewModel;
import view.helper_functions.LabelTextPanel;
import view.helper_functions.LabelTextPanelInt;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The PurchaseView class represents the user interface for purchasing a book.
 * It handles user input and interactions for searching and purchasing a book.
 *
 */
public class PurchaseView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "purchase book";
    private final PurchaseViewModel purchaseViewModel;
    private final PurchaseControllor purchaseControllor;

    /**
     * Input field for the book ID of the book to be purchased.
     */
    final JTextField bookidInputField = new JTextField(15);

    /**
     * Field for displaying error messages related to the book ID.
     */
    private final JLabel bookidErrorField = new JLabel();

    /**
     * Constructs a PurchaseView object with the specified view model and controller.
     *
     * @param purchaseViewModel the view model for purchasing a book
     * @param purchaseControllor the controller for purchasing a book
     */
    public PurchaseView(PurchaseViewModel purchaseViewModel, PurchaseControllor purchaseControllor) {
        this.purchaseViewModel = purchaseViewModel;
        this.purchaseViewModel.addPropertyChangeListener(this);

        this.purchaseControllor = purchaseControllor;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(purchaseViewModel.TITLE_LABELE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        LabelTextPanelInt bookid = new LabelTextPanelInt(
                new JLabel(purchaseViewModel.ID_BOX_LABLE), bookidInputField);
        this.add(bookid);

        this.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton confirmButton = new JButton(purchaseViewModel.CONFIREM_LABLE);
        buttons.add(confirmButton);
        JButton cancelButton = new JButton(purchaseViewModel.CANCEL_LABLE);
        buttons.add(cancelButton);

        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.add(buttons);
        this.add(Box.createVerticalGlue());

    }

    /**
     * Gets the preferred size for this component.
     *
     * @return the preferred size
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

    /**
     * Handles action events for the confirm and cancel buttons.
     *
     * @param evt the action event
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (purchaseViewModel.CONFIREM_LABLE.equals(evt.getActionCommand())){
            System.out.println("Confirmed to search for the book");
            PurchaseState state = purchaseViewModel.getPurchaseState();
            if (state == null){
                throw new IllegalStateException("PurchaseState is null");
            }

            int bookid;
            try {
                bookid = Integer.parseInt(bookidInputField.getText());
            } catch (NumberFormatException e) {
                System.out.println("Invalid bookid input");
                return;
            }

            purchaseControllor.execute(bookid);
        }else if (purchaseViewModel.CANCEL_LABLE.equals(evt.getActionCommand())){
            // #TODO Clean up the input boxes
            System.out.println("Canceled to search for the book");
            purchaseControllor.cancel();
        }
    }

    /**
     * Handles property change events from the view model.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PurchaseState state = (PurchaseState) evt.getNewValue();
        setFields(state);
    }

    /**
     * Sets the fields in the view based on the given state.
     *
     * @param state the current state of the view model
     */
    private void setFields(PurchaseState state){
        bookidInputField.setText(Integer.toString(state.getBookId()));
    }
}

