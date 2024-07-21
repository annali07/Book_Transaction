package use_case.rent_book.ReturnOrBorrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class RobInteractorTest {

    private RobOutputBoundary presenter;
    private RobInteractor interactor;

    @BeforeEach
    void setUp() {
        presenter = mock(RobOutputBoundary.class);
        interactor = new RobInteractor(presenter);
    }

    @Test
    void testCancel() {
        interactor.cancel();
        verify(presenter).prepareCancelView();
    }

    @Test
    void testReturnBook() {
        interactor.returnBook();
        verify(presenter).returnBook();
    }

    @Test
    void testBorrowBook() {
        interactor.borrowBook();
        verify(presenter).borrowBook();
    }
}
