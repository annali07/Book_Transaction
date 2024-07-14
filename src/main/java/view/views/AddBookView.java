package view.views;

import interface_adapter.add_book.AddBookController;
import interface_adapter.add_book.AddBookState;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "add book";
    private final AddBookViewModel addBookViewModel;
    private final AddBookController addBookController;
    private final MainMenuViewModel mainMenuViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Input ISBN given to the manager
     */
    final JTextField isbnInputField = new JTextField(15);
    final JTextField priceInputField = new JTextField(15);
    private final JLabel isbnErrorField = new JLabel();

    public AddBookView(AddBookViewModel addBookViewModel, AddBookController addBookController, ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.addBookViewModel = addBookViewModel;
        this.addBookViewModel.addPropertyChangeListener(this);
        this.addBookController = addBookController;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(addBookViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        LabelTextPanel isbnInfo = new LabelTextPanel(
                new JLabel(addBookViewModel.ISBN_LABEL), isbnInputField);
        LabelTextPanelInt bookPrice = new LabelTextPanelInt(
                new JLabel(addBookViewModel.PRICE_LABEL), priceInputField);
        this.add(isbnInfo);
        this.add(bookPrice);

        this.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between title and buttons

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addBookButton = new JButton(addBookViewModel.ADD_BOOK_LABEL);
        buttons.add(addBookButton);
        JButton cancelButton = new JButton(addBookViewModel.CANCEL_LABEL);
        buttons.add(cancelButton);

        addBookButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.add(buttons);
        this.add(Box.createVerticalGlue());

        isbnInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                AddBookState currentState = addBookViewModel.getState();
                currentState.setISBN(isbnInputField.getText());
                // #TODO make safer
                currentState.setPrice(Integer.parseInt(priceInputField.getText()));
                addBookViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {}

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
        if (addBookViewModel.ADD_BOOK_LABEL.equals(evt.getActionCommand())) {
            System.out.println("Add Book Entry button clicked");
            // String isbn = addBookViewModel.getState().getISBN();
            String isbn = isbnInputField.getText();
            int price = Integer.parseInt(priceInputField.getText()); // Safe b/c the input box ensures integer input
            addBookController.execute(isbn, price);
        } else if (addBookViewModel.CANCEL_LABEL.equals(evt.getActionCommand())) {
            // #TODO MODIFY
            System.out.println("Cancel Entry button clicked");
            viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }


}
