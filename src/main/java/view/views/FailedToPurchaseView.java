package view.views;

import interface_adapter.add_book.AddBookController;
import interface_adapter.add_book.AddBookState;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.purchase_book.PurchaseControllor;
import interface_adapter.purchase_book.PurchaseState;
import interface_adapter.purchase_book.PurchaseViewModel;
import view.helper_functions.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import interface_adapter.purchase_book.PurchaseControllor;

/**
 * The FailedToPurchaseView class represents the user interface for a failed book purchase.
 * It handles user interactions when a book purchase fails.
 *
 */
public class FailedToPurchaseView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "FailedToPurchaseView";
    private final PurchaseViewModel purchaseViewModel;
    private final PurchaseControllor purchaseControllor;

    /**
     * Constructs a FailedToPurchaseView object with the specified view model and controller.
     *
     * @param purchaseViewModel the view model for purchasing a book
     * @param purchaseControllor the controller for purchasing a book
     */
    public FailedToPurchaseView(PurchaseViewModel purchaseViewModel, PurchaseControllor purchaseControllor){
        this.purchaseViewModel = purchaseViewModel;
        this.purchaseControllor = purchaseControllor;
        this.purchaseViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(purchaseViewModel.SEARCH_FAILURE_LABLE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        this.add(Box.createRigidArea(new Dimension(0, 20)));
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton cancelButton = new JButton(purchaseViewModel.CANCEL_LABLE);
        buttons.add(cancelButton);

        cancelButton.addActionListener(this);
        this.add(buttons);
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
     * Handles action events for the cancel button.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        purchaseControllor.cancel();
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
