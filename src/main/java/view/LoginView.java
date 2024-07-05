package view;

import data_access.UserLoginDataAccess;
import data_access.UserLoginDataAccessInterface;
import interface_adapter.*;
import use_case.LoginUseCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginUseCase loginUseCase;

    /**
     * The username chosen by the user
     */
    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();
    /**
     * The password
     */
    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    final JButton logIn;
    final JButton cancel;

    /**
     * A window with a title and a JButton.
     */
    public LoginView(LoginViewModel loginViewModel, ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);
        UserLoginDataAccessInterface userGateway = new UserLoginDataAccess();
        LoginPresenter presenter = new LoginPresenter(viewManagerModel, loginViewModel, mainMenuViewModel);

        // Initialize LoginUseCase
        this.loginUseCase = new LoginUseCase(userGateway, presenter);

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

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
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (loginViewModel.LOGIN_BUTTON_LABEL.equals(evt.getActionCommand())) {
            String username = usernameInputField.getText();
            String password = new String(passwordInputField.getPassword());
            loginUseCase.login(username, password);
        } else if (loginViewModel.CANCEL_BUTTON_LABEL.equals(evt.getActionCommand())) {
            System.exit(0);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField.setText(state.getPassword());
    }
}
