package view.views;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import view.helper_functions.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A panel representing the login view. It contains input fields for username and password,
 * and buttons to submit or cancel the login process. It listens to property changes
 * from the LoginViewModel and updates the UI accordingly.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;

    /**
     * The username chosen by the user.
     */
    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    /**
     * The password.
     */
    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    final JButton logIn;
    final JButton cancel;

    /**
     * Constructs a LoginView with the specified LoginViewModel and LoginController.
     * Initializes the UI components and sets up listeners.
     *
     * @param loginViewModel the view model for the login view
     * @param controller the controller to handle login actions
     */
    public LoginView(LoginViewModel loginViewModel, LoginController controller) {
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        this.loginController = controller;

        JLabel title = new JLabel(loginViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(loginViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(loginViewModel.PASSWORD_LABEL), passwordInputField);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        logIn = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);
        cancel = new JButton(loginViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        logIn.addActionListener(this);
        cancel.addActionListener(this);

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                loginViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue()); // Adds vertical space to center components
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 20))); // Space between title and username field
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(Box.createRigidArea(new Dimension(0, 10))); // Space between fields
        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(Box.createRigidArea(new Dimension(0, 20))); // Space between password field and buttons
        this.add(buttons);
        this.add(Box.createVerticalGlue()); // Adds vertical space to center components
    }

    /**
     * Reacts to a button click that results in an ActionEvent.
     * Handles login and cancel actions.
     *
     * @param evt the action event triggered by button clicks
     */
    public void actionPerformed(ActionEvent evt) {
        if (loginViewModel.LOGIN_BUTTON_LABEL.equals(evt.getActionCommand())) {
            String username = usernameInputField.getText();
            String password = new String(passwordInputField.getPassword());
            loginController.execute(username, password);
        } else if (loginViewModel.CANCEL_BUTTON_LABEL.equals(evt.getActionCommand())) {
            System.exit(0);
        }
    }

    /**
     * Reacts to property changes in the LoginViewModel.
     * Updates the UI fields based on the new state.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    /**
     * Updates the input fields based on the provided LoginState.
     *
     * @param state the new state to set in the input fields
     */
    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField.setText(state.getPassword());
    }
}
