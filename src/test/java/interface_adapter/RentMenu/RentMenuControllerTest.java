package interface_adapter.RentMenu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.rent_book.RentMenu.RentMenuInputBoundary;
import use_case.rent_book.RentMenu.RentMenuInputData;

import static org.mockito.Mockito.*;

public class RentMenuControllerTest {
    private RentMenuInputBoundary rentMenuInputBoundary;
    private RentMenuController rentMenuController;

    @BeforeEach
    void setUp(){
        rentMenuInputBoundary = mock(RentMenuInputBoundary.class);
        rentMenuController = new RentMenuController(rentMenuInputBoundary);
    }

    @Test
    void execute(){
        int bookID = 5;
        rentMenuController.execute(bookID);

        verify(rentMenuInputBoundary).execute(any(RentMenuInputData.class));
    }

    @Test
    void cancel(){
        rentMenuController.cancel();
        verify(rentMenuInputBoundary).cancel();
    }
}
