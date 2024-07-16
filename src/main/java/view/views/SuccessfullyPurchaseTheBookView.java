package view.views;

import interface_adapter.purchase_book.PurchaseControllor;
import interface_adapter.purchase_book.PurchaseViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SuccessfullyPurchaseTheBookView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "SuccessfullyPurchaseView";
    private final PurchaseViewModel purchaseViewModel;
    private final PurchaseControllor purchaseControllor;

    public SuccessfullyPurchaseTheBookView(PurchaseViewModel purchaseViewModel, PurchaseControllor purchaseControllorr){
        this.purchaseViewModel = purchaseViewModel;
        this.purchaseControllor = purchaseControllorr;
        this.purchaseViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(purchaseViewModel.PURCHASE_SUCCESS_LABLE);
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



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        purchaseControllor.cancel();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
