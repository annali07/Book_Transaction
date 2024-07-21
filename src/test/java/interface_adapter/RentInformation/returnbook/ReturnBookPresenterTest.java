package interface_adapter.RentInformation.returnbook;

import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.rent_book.ReturnBook.ReturnBookOutputData;


import static org.mockito.Mockito.*;

public class ReturnBookPresenterTest {
    private ViewManagerModel viewManagerModel;
    private MainMenuViewModel mainMenuViewModel;
    private ReturnBookViewModel returnBookViewModel;
    private ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private ReturnBookPresenter returnBookPresenter;

    @BeforeEach
    void setUp(){
        viewManagerModel = mock(ViewManagerModel.class);
        mainMenuViewModel = mock(MainMenuViewModel.class);
        returnBookViewModel = mock(ReturnBookViewModel.class);
        returnOrBorrowViewModel = mock(ReturnOrBorrowViewModel.class);
        returnBookPresenter = new ReturnBookPresenter(viewManagerModel, mainMenuViewModel, returnBookViewModel, returnOrBorrowViewModel);
    }

    @AfterEach
    void tearDown() {
        // No resources to release in this case
    }

    @Test
    void prepareSuccessView() {
        // Arrange
        ReturnBookOutputData outputData = new ReturnBookOutputData(5,10);
        ReturnBookState returnBookState = mock(ReturnBookState.class);
        MainMenuState mainMenuState = mock(MainMenuState.class);

        when(returnBookViewModel.getState()).thenReturn(returnBookState);
        when(mainMenuViewModel.getState()).thenReturn(mainMenuState);

        // Act
        returnBookPresenter.prepareSuccessView(outputData);

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
        returnBookPresenter.prepareCancelView();

        // Assert
        verify(viewManagerModel).setActiveView(returnOrBorrowViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }
}
