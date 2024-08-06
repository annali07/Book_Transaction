package interface_adapter.RentInformation.borrowbook;

import use_case.rent_book.BorrowBook.BorrowBookInputBoundary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.rent_book.BorrowBook.BorrowBookInputData;

import java.util.Date;

import static org.mockito.Mockito.*;

public class BorrowCommonBookControllerTest {
    private BorrowBookController borrowBookController;
    private BorrowBookInputBoundary borrowBookInputBoundary;

    @BeforeEach
    void setUp() {
        borrowBookInputBoundary = mock(BorrowBookInputBoundary.class);
        borrowBookController = new BorrowBookController(borrowBookInputBoundary);
    }

    @Test
    void execute() {
        int bookID = 4;
        Date date_start = new Date(2003, 9, 29);
        Date date_end = new Date(2010, 10,12);
        String borrowerNumber = "18005172668";
        String borrowerName = "Kenny";

        borrowBookController.execute(bookID, date_start, date_end, borrowerNumber, borrowerName);

        verify(borrowBookInputBoundary).execute(any(BorrowBookInputData.class));
    }

    @Test
    void cancel() {
        borrowBookInputBoundary.cancel();
        verify(borrowBookInputBoundary).cancel();
    }
}
