package app.usecase_factory;

import interface_adapter.login.LoginViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.purchase_book.PurchaseViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.views.FailedToPurchaseView;
import view.views.LoginView;
import view.views.PurchaseView;
import view.views.SuccessfullyPurchaseTheBookView;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class PurchaseBookCaseFactoryTest {

    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private PurchaseViewModel mockPurchaseViewModel;
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
    void createSuccessfully() {
        SuccessfullyPurchaseTheBookView view = PurchaseBookCaseFactory.createSuccessfully(mockViewManagerModel, mockPurchaseViewModel, mockMainMenuViewModel);
        assertNotNull(view, "BorrowBookView should not be null");
        // Since we cannot directly check the BorrowBookController, we verify interactions or
        // ensure that methods expected to be called on the ViewModel are indeed called,
        // which would indirectly confirm that the controller and view are interacting correctly.
        verify(mockPurchaseViewModel, atLeastOnce()).addPropertyChangeListener(any(PropertyChangeListener.class));
    }

    @Test
    void create() {
        PurchaseView view = PurchaseBookCaseFactory.create(mockViewManagerModel, mockPurchaseViewModel, mockMainMenuViewModel);
        assertNotNull(view, "BorrowBookView should not be null");
        // Since we cannot directly check the BorrowBookController, we verify interactions or
        // ensure that methods expected to be called on the ViewModel are indeed called,
        // which would indirectly confirm that the controller and view are interacting correctly.
        verify(mockPurchaseViewModel, atLeastOnce()).addPropertyChangeListener(any(PropertyChangeListener.class));
    }

    @Test
    void failedCreate() {
        FailedToPurchaseView view = PurchaseBookCaseFactory.failedCreate(mockViewManagerModel, mockPurchaseViewModel, mockMainMenuViewModel);
        assertNotNull(view, "BorrowBookView should not be null");
        // Since we cannot directly check the BorrowBookController, we verify interactions or
        // ensure that methods expected to be called on the ViewModel are indeed called,
        // which would indirectly confirm that the controller and view are interacting correctly.
        verify(mockPurchaseViewModel, atLeastOnce()).addPropertyChangeListener(any(PropertyChangeListener.class));
    }
}