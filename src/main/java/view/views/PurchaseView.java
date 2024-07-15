package view.views;

import interface_adapter.add_book.AddBookState;
import interface_adapter.purchase_book.PurchaseControllor;
import interface_adapter.purchase_book.PurchaseState;
import interface_adapter.purchase_book.PurchaseViewModel;
import view.helper_functions.LabelTextPanel;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PurchaseView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "purchase book";
    private final PurchaseViewModel purchaseViewModel;
    private final PurchaseControllor purchaseControllor;

    final JTextField bookidInputField = new JTextField(15);
    private final JLabel bookidErrorField = new JLabel();

    public PurchaseView(PurchaseViewModel purchaseViewModel, PurchaseControllor purchaseControllor) {
        this.purchaseViewModel = purchaseViewModel;
        this.purchaseControllor = purchaseControllor;
        this.purchaseViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(purchaseViewModel.TITLE_LABELE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        LabelTextPanel bookid = new LabelTextPanel(
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

        bookidInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                PurchaseState currentState = purchaseViewModel.getPurchaseState();
                try{
                    currentState.setPurchaseState(Integer.parseInt(bookidInputField.getText()));
                } catch (NumberFormatException ex){

                }

                purchaseViewModel.setPurchaseState(currentState);;
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

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
            System.out.println("Canceled to search for the book");
            purchaseControllor.cancel();
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PurchaseState state = (PurchaseState) evt.getNewValue();
        setFields(state);
    }

    //TODO: this has problem on @Override ?
    private void setFields(PurchaseState state){
        bookidInputField.setText(Integer.toString(state.getBookId()));
    }
}
