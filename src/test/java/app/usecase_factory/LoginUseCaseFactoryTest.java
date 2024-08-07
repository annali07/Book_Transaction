package app.usecase_factory;

import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.views.AddBookView;
import view.views.LoginView;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class LoginUseCaseFactoryTest {

    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private LoginViewModel mockLoginViewModel;
    @Mock
    private MainMenuViewModel mockMainMenuViewModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        LoginView view = LoginUseCaseFactory.create(mockViewManagerModel, mockLoginViewModel, mockMainMenuViewModel);
        assertNotNull(view, "BorrowBookView should not be null");
        // Since we cannot directly check the BorrowBookController, we verify interactions or
        // ensure that methods expected to be called on the ViewModel are indeed called,
        // which would indirectly confirm that the controller and view are interacting correctly.
        verify(mockLoginViewModel, atLeastOnce()).addPropertyChangeListener(any(PropertyChangeListener.class));
    }

}