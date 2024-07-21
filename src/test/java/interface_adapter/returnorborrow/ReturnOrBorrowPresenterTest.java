package interface_adapter.returnorborrow;

import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowPresenter;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ReturnOrBorrowPresenterTest {
    private ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private ViewManagerModel viewManagerModel;
    private RentMenuViewModel rentMenuViewModel;
    private ReturnBookViewModel returnBookViewModel;
    private BorrowBookViewModel borrowBookViewModel;
    private MainMenuViewModel mainMenuViewModel;
    private ReturnOrBorrowPresenter returnOrBorrowPresenter;

    @BeforeEach
    void setUp() {
        returnOrBorrowViewModel = mock(ReturnOrBorrowViewModel.class);
        viewManagerModel = mock(ViewManagerModel.class);
        rentMenuViewModel = mock(RentMenuViewModel.class);
        returnBookViewModel = mock(ReturnBookViewModel.class);
        borrowBookViewModel = mock(BorrowBookViewModel.class);
        mainMenuViewModel = mock(MainMenuViewModel.class);
        returnOrBorrowPresenter = new ReturnOrBorrowPresenter(
                returnOrBorrowViewModel, viewManagerModel, rentMenuViewModel,
                returnBookViewModel, borrowBookViewModel, mainMenuViewModel
        );
    }

    @AfterEach
    void tearDown() {
        // No resources to release in this case
    }

    @Test
    void returnBook() {
        // Act
        returnOrBorrowPresenter.returnBook();

        // Assert
        verify(viewManagerModel).setActiveView(returnBookViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    void borrowBook() {
        // Act
        returnOrBorrowPresenter.borrowBook();

        // Assert
        verify(viewManagerModel).setActiveView(borrowBookViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    void prepareCancelView() {
        // Act
        returnOrBorrowPresenter.prepareCancelView();

        // Assert
        verify(viewManagerModel).setActiveView(mainMenuViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }
}
