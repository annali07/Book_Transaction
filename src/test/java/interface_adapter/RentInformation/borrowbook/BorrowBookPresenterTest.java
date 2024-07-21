package interface_adapter.RentInformation.borrowbook;

import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.rent_book.BorrowBook.BorrowBookOutputData;

import java.util.Date;

import static org.mockito.Mockito.*;

public class BorrowBookPresenterTest {
    private ViewManagerModel viewManagerModel;
    private MainMenuViewModel mainMenuViewModel;
    private BorrowBookViewModel borrowBookViewModel;
    private ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private BorrowBookPresenter borrowBookPresenter;

    @BeforeEach
    void setUp(){
        viewManagerModel = mock(ViewManagerModel.class);
        mainMenuViewModel = mock(MainMenuViewModel.class);
        borrowBookViewModel = mock(BorrowBookViewModel.class);
        returnOrBorrowViewModel = mock(ReturnOrBorrowViewModel.class);
        borrowBookPresenter = new BorrowBookPresenter(viewManagerModel, mainMenuViewModel, borrowBookViewModel, returnOrBorrowViewModel);
    }

    @AfterEach
    void tearDown() {
        // No resources to release in this case
    }

    @Test
    void prepareSuccessView() {
        // Arrange
        BorrowBookOutputData outputData = new BorrowBookOutputData(5, new Date(2003 - 1900, 4, 25),
                new Date(2004 - 1900, 5, 15), "Zhenyi", "1800517268");
        BorrowBookState borrowBookState = mock(BorrowBookState.class);
        MainMenuState mainMenuState = mock(MainMenuState.class);

        when(borrowBookViewModel.getState()).thenReturn(borrowBookState);
        when(mainMenuViewModel.getState()).thenReturn(mainMenuState);

        // Act
        borrowBookPresenter.prepareSuccessView(outputData);

        // Assert
        verify(mainMenuState).setActiveButton(outputData.defaultButton());
        verify(mainMenuViewModel).setState(mainMenuState);
        verify(mainMenuViewModel).firePropertyChanged();
        verify(viewManagerModel).setActiveView(mainMenuViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    void prepareCancelView() {
        // Act
        borrowBookPresenter.prepareCancelView();

        // Assert
        verify(viewManagerModel).setActiveView(returnOrBorrowViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }
}