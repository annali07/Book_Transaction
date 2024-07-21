package interface_adapter.RentInformation.returnbook;

import use_case.rent_book.ReturnBook.ReturnBookInputBoundary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.rent_book.ReturnBook.ReturnBookInputData;

import java.util.Date;

import static org.mockito.Mockito.*;

public class ReturnBookControllerTest {
    private ReturnBookController returnBookController;
    private ReturnBookInputBoundary returnBookInputBoundary;

    @BeforeEach
    void setUp(){
        returnBookInputBoundary = mock(ReturnBookInputBoundary.class);
        returnBookController = new ReturnBookController(returnBookInputBoundary);
    }

    @Test
    void execute(){
        int bookID = 4;
        Date start_date = new Date(2003, 9, 29);
        Date end_date = new Date(2004,10,20);
        Date return_date = new Date(2005, 10, 12);

        returnBookController.execute(bookID, return_date, end_date, start_date);
        verify(returnBookInputBoundary).execute(any(ReturnBookInputData.class));
    }

    @Test
    void cancel(){
        returnBookController.cancel();
        verify(returnBookInputBoundary).cancel();
    }



}
