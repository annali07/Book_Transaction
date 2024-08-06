package app.usecase_factory;

import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.api.ExternalBookApi;
import interface_adapter.add_book.AddBookController;
import interface_adapter.add_book.AddBookPresenter;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import use_case.add_book.AddBookInputBoundary;
import use_case.add_book.AddBookInteractor;
import use_case.add_book.AddBookOutputBoundary;
import view.views.AddBookView;

import javax.swing.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddBookUseCaseFactoryTest {

    private ViewManagerModel viewManagerModel;
    private AddBookViewModel addBookViewModel;
    private MainMenuViewModel mainMenuViewModel;

    @BeforeEach
    void setUp() {
        viewManagerModel = mock(ViewManagerModel.class);
        addBookViewModel = mock(AddBookViewModel.class);
        mainMenuViewModel = mock(MainMenuViewModel.class);
    }

    @Test
    void create_ShouldReturnAddBookViewInstance() {

    }

    @Test
    void create_ShouldShowErrorDialogOnIOException() {

    }
}
