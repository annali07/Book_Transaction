package interface_adapter.add_book;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddBookPresenterTest {

    private AddBookViewModel addBookViewModel;
    private ViewManagerModel viewManagerModel;
    private MainMenuViewModel mainMenuViewModel;
    private AddBookPresenter addBookPresenter;

    @BeforeEach
    void setUp() {
        addBookViewModel = mock(AddBookViewModel.class);
        viewManagerModel = mock(ViewManagerModel.class);
        mainMenuViewModel = mock(MainMenuViewModel.class);

        when(mainMenuViewModel.getViewName()).thenReturn("MainMenu");

        addBookPresenter = new AddBookPresenter(addBookViewModel, viewManagerModel, mainMenuViewModel);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void prepareSuccessView() {
        addBookPresenter.prepareSuccessView();

        verify(viewManagerModel).setActiveView("MainMenu");
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    void prepareFailView() {
        String error = "Failed to add book";

        addBookPresenter.prepareFailView(error);
    }

    @Test
    void prepareCancelView() {
        addBookPresenter.prepareCancelView();

        verify(viewManagerModel).setActiveView("MainMenu");
        verify(viewManagerModel).firePropertyChanged();
    }
}