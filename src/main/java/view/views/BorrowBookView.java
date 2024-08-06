package view.views;

import data.misc_info.TemproraryInfo;
import interface_adapter.RentInformation.borrowbook.BorrowBookController;
import interface_adapter.RentInformation.borrowbook.BorrowBookState;
import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
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
import java.util.Date;
import java.util.regex.Pattern;

/**
 * The BorrowBookView class represents the user interface for borrowing a book.
 * It handles user input and interactions for borrowing a book.
 *
 */
public class BorrowBookView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "borrow book";
    private final BorrowBookViewModel borrowBookViewModel;
    private final BorrowBookController borrowBookController;

    /**
     * Input field for the book ID of the book to be borrowed.
     */
    final JTextField isbookIDInputField = new JTextField(20);

    /**
     * Input field for the book name of the book to be borrowed.
     */
    final JTextField isbookNameField = new JTextField(20);

    /**
     * Input field for the start date of the borrowing period.
     */
    private JFormattedTextField isbookStartDate = new JFormattedTextField();

    /**
     * Input field for the end date of the borrowing period.
     */
    private JFormattedTextField isbookEndDate = new JFormattedTextField();

    /**
     * Field for displaying error messages.
     */
    final JTextField isErrorMessage = new JTextField(20);

    /**
     * Input field for the borrower's contact number.
     */
    private JTextField isBorrowerNumber = new JTextField(20);

    /**
     * Input field for the borrower's name.
     */
    private JTextField isBorrowerName = new JTextField(20);

    /**
     * Constructs a BorrowBookView object with the specified view model and controller.
     *
     * @param borrowBookViewModel the view model for borrowing a book
     * @param borrowBookController the controller for borrowing a book
     * @throws ParseException if the date format is invalid
     */
    public BorrowBookView(BorrowBookViewModel borrowBookViewModel, BorrowBookController borrowBookController) throws ParseException {
        this.borrowBookViewModel = borrowBookViewModel;
        this.borrowBookViewModel.addPropertyChangeListener(this);
        this.borrowBookController = borrowBookController;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(borrowBookViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        LabelTextPanelInt isbookIDInfo = new LabelTextPanelInt(
                new JLabel(borrowBookViewModel.BOOKID_LABEL), isbookIDInputField);
        LabelTextPanel isbookNameInfo = new LabelTextPanel(
                new JLabel(borrowBookViewModel.BOOK_NAME), isbookNameField);
        LabelTextPanel isErrorMessageInfo = new LabelTextPanel(
                new JLabel(borrowBookViewModel.ERROR_MESSAGE), isErrorMessage);
        LabelTextPanel isBorrowerNameInfo = new LabelTextPanel(
                new JLabel(borrowBookViewModel.BORROWER_NAME), isBorrowerName);
        LabelTextPanelInt isBorrowerNumberInfo = new LabelTextPanelInt(
                new JLabel(borrowBookViewModel.BORROWER_NUMBER), isBorrowerNumber);

        this.add(isbookIDInfo);
        this.add(isbookNameInfo);
        this.add(isErrorMessageInfo);
        this.add(isBorrowerNameInfo);
        this.add(isBorrowerNumberInfo);


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
                BorrowBookState currentState = borrowBookViewModel.getState();
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
                BorrowBookState currentState = borrowBookViewModel.getState();
                String bookName = isbookNameField.getText();

                // Fixing bookID automatically
                if (!bookName.isEmpty()) {
                    isbookNameField.setText(TemproraryInfo.update().get("bookName"));
                    currentState.setBookName(isbookNameField.getName());
                    //isbookNameField.setEditable(false);

                }

            }
        });

        isBorrowerName.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (isBorrowerName.getText().equals("")){
                    isErrorMessage.setText("Input is empty: Please enter a Borrower Name");
                }
                BorrowBookState currentState = borrowBookViewModel.getState();
                String text = isBorrowerName.getText();

                // Check if text is empty or not a valid integer
                if (!text.isEmpty()) {
                    isErrorMessage.setText("");
                    try {
                        String name = text;
                        currentState.setBorrowerName(name);
                        borrowBookViewModel.setState(currentState);
                    } catch (NumberFormatException ex) {
                        // Handle invalid input if necessary
                        isErrorMessage.setText("Invalid input: Please enter a valid borrower Name");
                        isBorrowerName.setText("");
                    }
                } else {
                    isErrorMessage.setText("Input is empty: Please enter a Borrower Name");
                    isBorrowerName.setText("");
                }
            }


            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {}
        });

        isBorrowerNumber.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (isBorrowerNumber.getText().equals("")){
                    isErrorMessage.setText("Input is empty: Please enter a Borrower Name");
                }
                BorrowBookState currentState = borrowBookViewModel.getState();
                String text = isBorrowerNumber.getText();

                // Check if text is empty or not a valid integer
                if (!text.isEmpty()) {
                    isErrorMessage.setText("");
                    System.out.println(text);
                    try {
                        long borrowerNumber = Long.parseLong(text);
                        currentState.setBorrowerNumber(Long.toString(borrowerNumber));
                        borrowBookViewModel.setState(currentState);
                    } catch (NumberFormatException ex) {
                        // Handle invalid input if necessary
                        isErrorMessage.setText("Invalid input: Please enter a valid borrower number");
                        isBorrowerNumber.setText("");
                    }
                } else {
                    isErrorMessage.setText("Input is empty: Please enter Borrower Phone Number");
                    isBorrowerNumber.setText("");
                }
            }


            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {}
        });

        try {
            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
            dateFormatter.setPlaceholderCharacter('_');
            isbookStartDate = new JFormattedTextField(dateFormatter);
            isbookEndDate = new JFormattedTextField(dateFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        isbookStartDate.setColumns(20);
        isbookEndDate.setColumns(20);

        LabelTextPanel isbookStartDateInfo = new LabelTextPanel(
                new JLabel(borrowBookViewModel.START_DATE), isbookStartDate);
        this.add(isbookStartDateInfo);

        LabelTextPanel isbookEndDateInfo = new LabelTextPanel(
                new JLabel(borrowBookViewModel.END_DATE), isbookEndDate);
        this.add(isbookEndDateInfo);

        isbookStartDate.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleInputStart();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleInputStart();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleInputStart();
            }
        });

        isbookEndDate.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleInputEnd();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleInputEnd();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleInputEnd();
            }
        });

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton borrowBookButton = new JButton(borrowBookViewModel.BORROW_BOOK);
        buttons.add(borrowBookButton);
        JButton cancelButton = new JButton(borrowBookViewModel.CANCEL_LABEL);
        buttons.add(cancelButton);

        borrowBookButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.add(buttons);
        this.add(Box.createVerticalGlue());

        this.add(Box.createRigidArea(new Dimension(0, 20)));

    }

    private void handleInputStart() {
        BorrowBookState currentState = borrowBookViewModel.getState();
        String startDate = isbookStartDate.getText().trim();

        if (TemproraryInfo.update().get("isRented").equals("false")) {
            if (!startDate.isEmpty() && isValidDateFormat(startDate)) {
                isErrorMessage.setText("");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);

                try {
                    System.out.println(startDate);
                    Date date = dateFormat.parse(startDate);
                    // If parsing succeeds, the input is a valid date
                    currentState.setRentStartDate(date);
                    System.out.println(currentState.getRentStartDate());
                    borrowBookViewModel.setState(currentState);
                } catch (ParseException ex) {
                    // Handle invalid input if necessary
                    currentState.setRentStartDateError(null);
                    isErrorMessage.setText("Invalid input: Please enter a valid start date in yyyy-MM-dd format");
                }
            } else {
                isErrorMessage.setText("Start Date is Empty: Please type in start date");
            }
        } else {
            if (!startDate.isEmpty()) {
                // isbookReturnDate.setText("1111-11-11");
                currentState.setRentStartDate(null);
                isErrorMessage.setText("CommonBook is already rented. You can type in start date, but it does not represent anything");
            }
        }
    }

    private void handleInputEnd() {
        BorrowBookState currentState = borrowBookViewModel.getState();
        String endDate = isbookEndDate.getText().trim();

        if (TemproraryInfo.update().get("isRented").equals("false")) {
            if (!endDate.isEmpty() && isValidDateFormat(endDate)) {
                isErrorMessage.setText("");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);

                try {
                    System.out.println(endDate);
                    Date date = dateFormat.parse(endDate);
                    // If parsing succeeds, the input is a valid date
                    currentState.setRentEndDate(date);
                    System.out.println(currentState.getRentEndDate());
                    borrowBookViewModel.setState(currentState);
                } catch (ParseException ex) {
                    // Handle invalid input if necessary
                    currentState.setRentEndDate(null);
                    isErrorMessage.setText("Invalid input: Please enter a valid return date in yyyy-MM-dd format");
                }
            } else {
                isErrorMessage.setText("Return Date is Empty: Please type in return date");
            }
        } else {
            if (!endDate.isEmpty()) {
                // isbookReturnDate.setText("1111-11-11");
                currentState.setRentEndDate(null);
                isErrorMessage.setText("CommonBook is already rented. You can type in end date, but it does not represent anything");
            }
        }
    }

    private boolean isValidDateFormat(String date) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        return Pattern.matches(regex, date);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (borrowBookViewModel.BORROW_BOOK.equals(e.getActionCommand())) {
            if (TemproraryInfo.update().get("isRented").equals("false")) {
                System.out.println("borrow CommonBook button clicked");
                BorrowBookState state = borrowBookViewModel.getState();
                if (state == null) {
                    throw new IllegalStateException("BorrowBookState is null");
                }

                int bookID = state.getBookID();
                if (bookID == 0) {
                    System.out.println("bookID is null");
                    return;
                }
                Date date_start = state.getRentStartDate();
                Date date_end = state.getRentEndDate();
                if (date_start == null) {
                    isErrorMessage.setText("Invalid input: Please enter a valid start date");
                    return;
                } else if (date_end == null) {
                    isErrorMessage.setText("Invalid input: Please enter a valid end date");
                    return;
                } else if (date_end.before(date_start)) {
                    isErrorMessage.setText("Invalid input: end date should come after start date");
                    return;
                }
                String borrowerName = state.getBorrowerName();
                String borrowerNumber = state.getBorrowerNumber();
                if (borrowerNumber.isEmpty()) {
                    isErrorMessage.setText("Invalid input: Please enter a valid borrower number");
                    return;
                } else if (borrowerName.isEmpty()) {
                    isErrorMessage.setText("Invalid input: Please enter a valid borrower name");
                    return;
                }
                isbookIDInputField.setText("");
                isbookStartDate.setText("");
                isbookNameField.setText("");
                isbookEndDate.setText("");
                isBorrowerNumber.setText("");
                isBorrowerName.setText("");
                isErrorMessage.setText("");
                borrowBookController.execute(bookID, date_start, date_end, borrowerNumber, borrowerName);
            }
            else {
                System.out.println("the book has been rented and not returned");
            }
        } else if (borrowBookViewModel.CANCEL_LABEL.equals(e.getActionCommand())) {
            isbookIDInputField.setText("");
            isbookStartDate.setText("");
            isbookNameField.setText("");
            isbookEndDate.setText("");
            isBorrowerNumber.setText("");
            isBorrowerName.setText("");
            isErrorMessage.setText("");

            borrowBookController.cancel();
        }
    }



    public void propertyChange(PropertyChangeEvent evt) {
        BorrowBookState state = (BorrowBookState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(BorrowBookState state) {
        isbookIDInputField.setText(String.valueOf(state.getBookID()));
        isbookStartDate.setText(String.valueOf(state.getRentStartDate()));
        isbookNameField.setText(String.valueOf(state.getBookName()));
        isbookEndDate.setText(String.valueOf(state.getRentEndDate()));
        isBorrowerNumber.setText(String.valueOf(state.getBorrowerNumber()));
        isBorrowerName.setText(String.valueOf(state.getBorrowerName()));

    }



}