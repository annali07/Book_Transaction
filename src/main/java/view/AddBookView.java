package view;

import interface_adapter.add_book.AddBookState;
import interface_adapter.add_book.AddBookViewModel;

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
//    private final AddDBUseCase addDbUseCase;

    /**
     * Input ISBN given to the manager
     */
    final JTextField isbnInputField = new JTextField(15);
    private final JLabel isbnErrorField = new JLabel();

    private final JButton addBookButton;
    private final JButton cancelButton;

    public AddBookView(AddBookViewModel addBookViewModel) {
        this.addBookViewModel = addBookViewModel;
        this.addBookViewModel.addPropertyChangeListener(this);
//        UserLoginDataAccessInterface userGateway = new UserLoginDataAccess();
//        LoginPresenter presenter = new LoginPresenter(viewManagerModel, loginViewModel, mainMenuViewModel);
//
//        // Initialize LoginInteractor
//        this.loginUseCase = new LoginInteractor(userGateway, presenter);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(addBookViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        LabelTextPanel isbnInfo = new LabelTextPanel(
                new JLabel(addBookViewModel.ADD_BOOK_LABEL), isbnInputField);
        this.add(isbnInfo);

        this.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between title and buttons

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        addBookButton = new JButton(addBookViewModel.ADD_BOOK_LABEL);
        buttons.add(addBookButton);
        cancelButton = new JButton(addBookViewModel.CANCEL_LABEL);
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
            // Handle Add Book Entry action
        } else if (addBookViewModel.CANCEL_LABEL.equals(evt.getActionCommand())) {
            System.out.println("Cancel Entry button clicked");
            // Handle Rent Book Entry action
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }


}
