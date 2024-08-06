package app.usecase_factory.rent;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import view.views.BorrowBookView;

import java.beans.PropertyChangeListener;

class BorrowBookUseCaseFactoryTest {

    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private BorrowBookViewModel mockBorrowBookViewModel;
    @Mock
    private MainMenuViewModel mockMainMenuViewModel;
    @Mock
    private ReturnOrBorrowViewModel mockReturnOrBorrowViewModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        // Assuming the factory uses some internal logic to instantiate these
    }

    @Test
    void testCreateBorrowBookView() throws Exception {
        // Arrange
        // This step might require using a Mockito extension to capture the instantiation of internal objects
        // However, since we don't have direct access to the controller, we'll focus on what we can check.
        BorrowBookView view = BorrowBookUseCaseFactory.create(mockViewManagerModel, mockBorrowBookViewModel, mockMainMenuViewModel, mockReturnOrBorrowViewModel);

        // Act & Assert
        assertNotNull(view, "BorrowBookView should not be null");
        // Since we cannot directly check the BorrowBookController, we verify interactions or
        // ensure that methods expected to be called on the ViewModel are indeed called,
        // which would indirectly confirm that the controller and view are interacting correctly.
        verify(mockBorrowBookViewModel, atLeastOnce()).addPropertyChangeListener(any(PropertyChangeListener.class));
    }
}
