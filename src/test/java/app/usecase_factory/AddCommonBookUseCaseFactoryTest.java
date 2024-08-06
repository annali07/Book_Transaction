package app.usecase_factory;

import app.usecase_factory.rent.BorrowBookUseCaseFactory;
import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.api.ExternalBookApi;
import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.add_book.AddBookController;
import interface_adapter.add_book.AddBookPresenter;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import use_case.add_book.AddBookInputBoundary;
import use_case.add_book.AddBookInteractor;
import use_case.add_book.AddBookOutputBoundary;
import view.views.AddBookView;
import view.views.BorrowBookView;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddCommonBookUseCaseFactoryTest {

    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private AddBookViewModel mockAddBookViewModel;
    @Mock
    private MainMenuViewModel mockMainMenuViewModel;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create_ShouldReturnAddBookViewInstance() {
        AddBookView view = AddBookUseCaseFactory.create(mockViewManagerModel, mockAddBookViewModel, mockMainMenuViewModel);
        assertNotNull(view, "BorrowBookView should not be null");
        // Since we cannot directly check the BorrowBookController, we verify interactions or
        // ensure that methods expected to be called on the ViewModel are indeed called,
        // which would indirectly confirm that the controller and view are interacting correctly.
        verify(mockAddBookViewModel, atLeastOnce()).addPropertyChangeListener(any(PropertyChangeListener.class));
    }

    @Test
    void create_ShouldShowErrorDialogOnIOException() {

    }
}
