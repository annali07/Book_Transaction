package view.views;

import interface_adapter.add_book.AddBookController;
import interface_adapter.add_book.AddBookState;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import view.helper_functions.LabelTextPanel;
import view.helper_functions.LabelTextPanelInt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The AddBookView class represents the user interface for adding a book.
 * It handles user input and interactions for adding a book.
 *
 */
public class AddBookView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "add book";
    private final AddBookViewModel addBookViewModel;
    private final AddBookController addBookController;

    /**
     * Input ISBN given to the manager
     */
    final JTextField isbnInputField = new JTextField(15);
    /**
     * Input field for price of the book
     */
    final JTextField priceInputField = new JTextField(15);
    private final JLabel isbnErrorField = new JLabel();

    /**
     * Constructs an AddBookView object with the specified view model and controller.
     *
     * @param addBookViewModel the view model for adding a book
     * @param addBookController the controller for adding a book
     */
    public AddBookView(AddBookViewModel addBookViewModel, AddBookController addBookController) {
        this.addBookViewModel = addBookViewModel;
        this.addBookViewModel.addPropertyChangeListener(this);
        this.addBookController = addBookController;

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
//                currentState.setPrice(Integer.parseInt(priceInputField.getText()));
                addBookViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
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
     * Handles action events for the add book and cancel buttons.
     *
     * @param evt the action event
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (addBookViewModel.ADD_BOOK_LABEL.equals(evt.getActionCommand())) {
            System.out.println("Add CommonBook Entry button clicked");
            AddBookState state = addBookViewModel.getState();
            if (state == null) {
                throw new IllegalStateException("AddBookState is null");
            }

//            String isbn = state.getISBN();
            String isbn = isbnInputField.getText();
            if (isbn == null || isbn.isEmpty()) {
                System.out.println("ISBN is empty or null");
                return;
            }

            double price;
            try {
                price = Double.parseDouble(priceInputField.getText());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price input");
                return;
            }

            addBookController.execute(isbn, price);
        } else if (addBookViewModel.CANCEL_LABEL.equals(evt.getActionCommand())) {
            addBookController.cancel();
        }
    }

    /**
     * Handles property change events from the view model.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddBookState state = (AddBookState) evt.getNewValue();
        setFields(state);
    }

    /**
     * Sets the fields in the view based on the given state.
     *
     * @param state the current state of the view model
     */
    private void setFields(AddBookState state) {
        isbnInputField.setText(String.valueOf(state.getISBN()));
        priceInputField.setText(String.valueOf(state.getPrice()));
    }
}
