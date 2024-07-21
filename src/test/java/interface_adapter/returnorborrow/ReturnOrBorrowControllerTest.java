package interface_adapter.returnorborrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.rent_book.ReturnOrBorrow.RobInteractor;
import static org.mockito.Mockito.*;
public class ReturnOrBorrowControllerTest {
    private RobInteractor robInteractor;
    private ReturnOrBorrowController returnOrBorrowController;
    @BeforeEach
    void setUp(){
        robInteractor= mock(RobInteractor.class);
        returnOrBorrowController = new ReturnOrBorrowController(robInteractor);
    }

    @Test
    void borrowBook(){

        returnOrBorrowController.borrowBook();

        verify(robInteractor).borrowBook();
    }

    @Test
    void returnBook(){
        returnOrBorrowController.returnBook();

        verify(robInteractor).returnBook();
    }
    @Test
    void cancel(){
        returnOrBorrowController.cancel();
        verify(robInteractor).cancel();
    }
}
