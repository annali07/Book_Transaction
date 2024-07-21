package interface_adapter.RentMenu;

import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.rent_book.RentMenu.RentMenuOutputData;

import static org.mockito.Mockito.*;

public class RentMenuPresenterTest {
    private RentMenuViewModel rentMenuViewModel;
    private ViewManagerModel viewManagerModel;
    private MainMenuViewModel mainMenuViewModel;
    private ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private RentMenuPresenter rentMenuPresenter;

    @BeforeEach
    void setUp() {
        rentMenuViewModel = mock(RentMenuViewModel.class);
        viewManagerModel = mock(ViewManagerModel.class);
        mainMenuViewModel = mock(MainMenuViewModel.class);
        returnOrBorrowViewModel = mock(ReturnOrBorrowViewModel.class);
        rentMenuPresenter = new RentMenuPresenter(viewManagerModel, rentMenuViewModel, mainMenuViewModel, returnOrBorrowViewModel);
    }

    @AfterEach
    void tearDown() {
        // No resources to release in this case
    }

    @Test
    void prepareSuccessView() {
        // Arrange
        RentMenuOutputData outputData = new RentMenuOutputData(5, false);
        RentMenuState rentMenuState = mock(RentMenuState.class);
        MainMenuState mainMenuState = mock(MainMenuState.class);

        when(rentMenuViewModel.getState()).thenReturn(rentMenuState);
        when(mainMenuViewModel.getState()).thenReturn(mainMenuState);

        // Act
        rentMenuPresenter.prepareSuccessView(outputData);

        // Assert
        verify(mainMenuState).setActiveButton(outputData.defaultButton());
        verify(mainMenuViewModel).setState(mainMenuState);
        verify(mainMenuViewModel).firePropertyChanged();
        verify(viewManagerModel).setActiveView(returnOrBorrowViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    void prepareFailView() {
        // Act
        rentMenuPresenter.prepareFailView("Error Message");

        // Assert
        // Since the method only prints an error message to the console, there's no state to verify
        // This is a place where you might consider adding state or a way to verify the error handling
    }

    @Test
    void prepareCancelView() {
        // Act
        rentMenuPresenter.prepareCancelView();

        // Assert
        verify(viewManagerModel).setActiveView(mainMenuViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }
}
