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

public class ReturnOrBorrowView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "return or borrow";
    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private final ReturnOrBorrowController returnOrBorrowController;

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
