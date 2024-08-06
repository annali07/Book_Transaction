package view.views;

import data.misc_info.TemproraryInfo;
import interface_adapter.RentInformation.returnbook.ReturnBookController;
import interface_adapter.RentInformation.returnbook.ReturnBookState;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import view.helper_functions.LabelTextPanel;
import view.helper_functions.LabelTextPanelInt;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * The ReturnBookView class represents the user interface for returning a book.
 * It handles user input and interactions for returning a book.
 *
 */
public class ReturnBookView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "return book";
    private final ReturnBookViewModel returnBookViewModel;
    private final ReturnBookController returnBookController;

    /**
     * Input field for the book ID of the book to be returned.
     */
    final JTextField isbookIDInputField = new JTextField(20);

    /**
     * Input field for the start date of the borrowing period.
     */
    final JTextField isbookStartDate = new JTextField(20);

    /**
     * Input field for the book name of the book to be returned.
     */
    final JTextField isbookNameField = new JTextField(20);

    /**
     * Input field for the return date of the book.
     */
    private JFormattedTextField isbookReturnDate = new JFormattedTextField();

    /**
     * Input field for the end date of the borrowing period.
     */

    final JTextField isbookEndDate = new JTextField(20);

    /**
     * Field for displaying error messages.
     */
    final JTextField isErrorMessage = new JTextField(20);

    /**
     * Constructs a ReturnBookView object with the specified view model and controller.
     *
     * @param returnBookViewModel the view model for returning a book
     * @param returnBookController the controller for returning a book
     * @throws ParseException if the date format is invalid
     */
    public ReturnBookView(ReturnBookViewModel returnBookViewModel, ReturnBookController returnBookController) throws ParseException {
        this.returnBookViewModel = returnBookViewModel;
        this.returnBookViewModel.addPropertyChangeListener(this);
        this.returnBookController = returnBookController;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(returnBookViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        LabelTextPanelInt isbookIDInfo = new LabelTextPanelInt(
                new JLabel(returnBookViewModel.BOOKID_LABEL), isbookIDInputField);
        LabelTextPanel isbookStartDateInfo = new LabelTextPanel(
                new JLabel(returnBookViewModel.START_DATE), isbookStartDate);
        LabelTextPanel isbookNameInfo = new LabelTextPanel(
                new JLabel(returnBookViewModel.BOOK_NAME), isbookNameField);
        LabelTextPanel isErrorMessageInfo = new LabelTextPanel(
                new JLabel(returnBookViewModel.ERROR_MESSAGE), isErrorMessage);
        LabelTextPanel isbookEndDateInfo = new LabelTextPanel(
                new JLabel(returnBookViewModel.END_DATE), isbookEndDate);
        this.add(isbookIDInfo);
        this.add(isbookNameInfo);
        this.add(isbookStartDateInfo);
        this.add(isErrorMessageInfo);
        this.add(isbookEndDateInfo);

        isbookIDInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(TemproraryInfo.bookID);
                ReturnBookState currentState = returnBookViewModel.getState();
                String bookID = isbookIDInputField.getText();

                // Fixing bookID automatically
                if (!bookID.isEmpty()) {
                    isbookIDInputField.setText(TemproraryInfo.update().get("bookID"));
                    currentState.setBookID(Integer.parseInt(isbookIDInputField.getText()));
                    //isbookIDInputField.setEditable(false);

                }

            }
        });

        isbookNameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                ReturnBookState currentState = returnBookViewModel.getState();
                String bookName = isbookNameField.getText();

                // Fixing bookID automatically
                if (!bookName.isEmpty()) {
                    isbookNameField.setText(TemproraryInfo.update().get("bookName"));
                    currentState.setBookName(isbookNameField.getName());
                    //isbookNameField.setEditable(false);

                }

            }
        });

        isbookStartDate.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                ReturnBookState currentState = returnBookViewModel.getState();
                String startDate = isbookStartDate.getText();

                // Fixing bookID automatically
                if (TemproraryInfo.update().get("isRented").equals("true")) {
                    if (!startDate.isEmpty()) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        System.out.println(TemproraryInfo.update().get("Start Date"));
                        isbookStartDate.setText(TemproraryInfo.update().get("Start Date"));
                        try {
                            currentState.setStartDate(formatter.parse(isbookStartDate.getText()));
                        } catch (ParseException ex) {
                            System.out.println("Error parsing date: " + ex.getMessage());
                        }
                        //isbookStartDate.setEditable(false);

                    }
                } else {
                    if (!startDate.isEmpty()) {
                        isbookStartDate.setText("");
                        currentState.setStartDate(null);
                        //isbookStartDate.setEditable(false);
                        isErrorMessage.setText("CommonBook is not rented");
                    }

                }

            }
        });

        isbookEndDate.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                ReturnBookState currentState = returnBookViewModel.getState();
                String endDate = isbookEndDate.getText();

                // Fixing bookID automatically
                if (TemproraryInfo.update().get("isRented").equals("true")) {
                    if (!endDate.isEmpty()) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        System.out.println(TemproraryInfo.update().get("End Date"));
                        isbookEndDate.setText(TemproraryInfo.update().get("End Date"));
                        try {
                            currentState.setEndDate(formatter.parse(isbookEndDate.getText()));
                        } catch (ParseException ex) {
                            System.out.println("Error parsing date: " + ex.getMessage());
                        }
                        //isbookEndDate.setEditable(false);

                    }
                } else {
                    if (!endDate.isEmpty()) {
                        isbookEndDate.setText("");
                        currentState.setEndDate(null);
                        //isbookEndDate.setEditable(false);
                        isErrorMessage.setText("CommonBook is not rented");
                    }

                }

            }
        });

        try {
            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
            dateFormatter.setPlaceholderCharacter('_');
            isbookReturnDate = new JFormattedTextField(dateFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        isbookReturnDate.setColumns(20);

        LabelTextPanel isbookReturnDateInfo = new LabelTextPanel(
                new JLabel(returnBookViewModel.RETURN_DATE), isbookReturnDate);
        this.add(isbookReturnDateInfo);

        isbookReturnDate.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleInput();
            }
        });
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton returnBookButton = new JButton(returnBookViewModel.RETURN_BOOK);
        buttons.add(returnBookButton);
        JButton cancelButton = new JButton(returnBookViewModel.CANCEL_LABEL);
        buttons.add(cancelButton);

        returnBookButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.add(buttons);
        this.add(Box.createVerticalGlue());

        this.add(Box.createRigidArea(new Dimension(0, 20)));
    }


    /**
     * Handles the input for the return date field and updates the view model state accordingly.
     */
    private void handleInput() {
        ReturnBookState currentState = returnBookViewModel.getState();
        String returnDate = isbookReturnDate.getText().trim();

        if (TemproraryInfo.update().get("isRented").equals("true")) {
            if (!returnDate.isEmpty() && isValidDateFormat(returnDate)) {
                isErrorMessage.setText("");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);

                try {
                    System.out.println(returnDate);
                    Date date = dateFormat.parse(returnDate);
                    // If parsing succeeds, the input is a valid date
                    currentState.setReturnDate(date);
                    System.out.println(currentState.getReturnDate());
                    returnBookViewModel.setState(currentState);
                } catch (ParseException ex) {
                    // Handle invalid input if necessary
                    currentState.setReturnDate(null);
                    isErrorMessage.setText("Invalid input: Please enter a valid return date in yyyy-MM-dd format");
                }
            } else {
                isErrorMessage.setText("Return Date is Empty: Please type in return date");
            }
        } else {
            if (!returnDate.isEmpty()) {
                // isbookReturnDate.setText("1111-11-11");
                currentState.setReturnDate(null);
                isErrorMessage.setText("CommonBook is not rented. You can type in return date, but it does not represent anything");
            }
        }
    }

    /**
     * Handles action events for the return and cancel buttons.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (returnBookViewModel.RETURN_BOOK.equals(e.getActionCommand())) {
            if (TemproraryInfo.update().get("isRented").equals("true")) {
                System.out.println("return CommonBook button clicked");
                ReturnBookState state = returnBookViewModel.getState();
                if (state == null) {
                    throw new IllegalStateException("ReturnBookState is null");
                }

                int bookID = state.getBookID();
                if (bookID == 0) {
                    System.out.println("bookID is null");
                    return;
                }
                Date date_return = state.getReturnDate();
                Date date_start = state.getStartDate();
                if (date_return == null) {
                    isErrorMessage.setText("Invalid input: Please enter a valid return date");
                    return;
                } else if (date_return.before(date_start)) {
                    isErrorMessage.setText("Invalid input: Return Date should be after rental start date");
                    return;
                }

                Date date_end = state.getEndDate();
                if (date_return.after(date_end)) {
                    long diffInMillies = Math.abs(date_return.getTime() - date_end.getTime());
                    long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                    isErrorMessage.setText("your return date is too late. You need to pay" + diffInDays + "dollars");
                } else {
                    isErrorMessage.setText("No charge. you are free to cancel this page");
                }
                isbookIDInputField.setText("");
                isbookStartDate.setText("");
                isbookReturnDate.setText("");
                isbookNameField.setText("");
                isbookEndDate.setText("");
                isErrorMessage.setText("");
                returnBookController.execute(bookID, date_return, date_end, date_start);

            } else {
                System.out.println("the book is not rented");
            }
        } else if (returnBookViewModel.CANCEL_LABEL.equals(e.getActionCommand())){
            returnBookController.cancel();



        }
    }

    /**
     * Checks if the provided date string is in the valid format yyyy-MM-dd.
     *
     * @param date the date string to check
     * @return true if the date is in valid format, false otherwise
     */
    private boolean isValidDateFormat(String date) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        return Pattern.matches(regex, date);
    }

    /**
     * Handles property change events from the view model.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ReturnBookState state = (ReturnBookState) evt.getNewValue();
        setFields(state);

    }

    /**
     * Sets the fields in the view based on the given state.
     *
     * @param state the current state of the view model
     */
    private void setFields(ReturnBookState state) {
        isbookIDInputField.setText(String.valueOf(state.getBookID()));
        isbookStartDate.setText(String.valueOf(state.getStartDate()));
        isbookReturnDate.setText(String.valueOf(state.getReturnDate()));
        isbookNameField.setText(String.valueOf(state.getBookName()));
        isbookEndDate.setText(String.valueOf(state.getEndDate()));
    }

}
