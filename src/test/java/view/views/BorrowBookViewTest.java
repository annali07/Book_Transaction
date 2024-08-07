//package view.views;
//
//import interface_adapter.RentInformation.borrowbook.BorrowBookController;
//import interface_adapter.RentInformation.borrowbook.BorrowBookState;
//import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import use_case.rent_book.BorrowBook.BorrowBookInteractor;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.beans.PropertyChangeEvent;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BorrowBookViewTest {
//
//    private BorrowBookView borrowBookView;
//    private BorrowBookViewModel borrowBookViewModel;
//    private BorrowBookController borrowBookController;
//
//    @BeforeEach
//    void setUp() throws ParseException {
//        borrowBookViewModel = new BorrowBookViewModel();
//        borrowBookInteractor = new BorrowBookInteractor();
//        borrowBookController = new BorrowBookController() {
//            @Override
//            public void execute(int bookId, Date startDate, Date endDate, String borrowerNumber, String borrowerName) {
//                // Simulate execute action
//                System.out.println("Executing borrow book action with bookId: " + bookId);
//            }
//
//            @Override
//            public void cancel() {
//                // Simulate cancel action
//                System.out.println("Cancel action triggered");
//            }
//        };
//        borrowBookView = new BorrowBookView(borrowBookViewModel, borrowBookController);
//    }
//
//    @Test
//    void testBorrowBookButtonAction() throws ParseException {
//        borrowBookViewModel.getState().setBookID(1);
//        borrowBookViewModel.getState().setBookName("Test Book");
//        borrowBookViewModel.getState().setBorrowerName("John Doe");
//        borrowBookViewModel.getState().setBorrowerNumber("1234567890");
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = sdf.parse("2023-01-01");
//        Date endDate = sdf.parse("2023-01-10");
//
//        borrowBookViewModel.getState().setRentStartDate(startDate);
//        borrowBookViewModel.getState().setRentEndDate(endDate);
//
//        ActionEvent event = new ActionEvent(borrowBookView, ActionEvent.ACTION_PERFORMED, borrowBookViewModel.BORROW_BOOK);
//        borrowBookView.actionPerformed(event);
//
//        assertEquals("", borrowBookView.isbookIDInputField.getText());
//        assertEquals("", borrowBookView.isbookStartDate.getText());
//        assertEquals("", borrowBookView.isbookNameField.getText());
//        assertEquals("", borrowBookView.isbookEndDate.getText());
//        assertEquals("", borrowBookView.isBorrowerNumber.getText());
//        assertEquals("", borrowBookView.isBorrowerName.getText());
//        assertEquals("", borrowBookView.isErrorMessage.getText());
//    }
//
//    @Test
//    void testCancelButtonAction() {
//        borrowBookView.isbookIDInputField.setText("1");
//        borrowBookView.isbookStartDate.setText("2023-01-01");
//        borrowBookView.isbookNameField.setText("Test Book");
//        borrowBookView.isbookEndDate.setText("2023-01-10");
//        borrowBookView.isBorrowerNumber.setText("1234567890");
//        borrowBookView.isBorrowerName.setText("John Doe");
//        borrowBookView.isErrorMessage.setText("Some error");
//
//        ActionEvent event = new ActionEvent(borrowBookView, ActionEvent.ACTION_PERFORMED, borrowBookViewModel.CANCEL_LABEL);
//        borrowBookView.actionPerformed(event);
//
//        assertEquals("", borrowBookView.isbookIDInputField.getText());
//        assertEquals("", borrowBookView.isbookStartDate.getText());
//        assertEquals("", borrowBookView.isbookNameField.getText());
//        assertEquals("", borrowBookView.isbookEndDate.getText());
//        assertEquals("", borrowBookView.isBorrowerNumber.getText());
//        assertEquals("", borrowBookView.isBorrowerName.getText());
//        assertEquals("", borrowBookView.isErrorMessage.getText());
//    }
//
//    @Test
//    void testPropertyChange() {
//        BorrowBookState newState = new BorrowBookState();
//        newState.setBookID(1);
//        newState.setBookName("Test Book");
//        newState.setBorrowerName("John Doe");
//        newState.setBorrowerNumber("1234567890");
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = null;
//        Date endDate = null;
//        try {
//            startDate = sdf.parse("2023-01-01");
//            endDate = sdf.parse("2023-01-10");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        newState.setRentStartDate(startDate);
//        newState.setRentEndDate(endDate);
//
//        PropertyChangeEvent event = new PropertyChangeEvent(borrowBookViewModel, "state", null, newState);
//        borrowBookView.propertyChange(event);
//
//        assertEquals("1", borrowBookView.isbookIDInputField.getText());
//        assertEquals("Test Book", borrowBookView.isbookNameField.getText());
//        assertEquals("John Doe", borrowBookView.isBorrowerName.getText());
//        assertEquals("1234567890", borrowBookView.isBorrowerNumber.getText());
//        assertEquals("2023-01-01", borrowBookView.isbookStartDate.getText());
//        assertEquals("2023-01-10", borrowBookView.isbookEndDate.getText());
//    }
//}
