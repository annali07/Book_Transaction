package app.usecase_factory;

import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.calculate_revenue.RevenueViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.views.AddBookView;
import view.views.RevenueView;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class RevenueUseCaseFactoryTest {
    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private RevenueViewModel mockRevenueViewModel;
    @Mock
    private MainMenuViewModel mockMainMenuViewModel;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create_ShouldReturnAddBookViewInstance() {
        RevenueView view = RevenueUseCaseFactory.create(mockViewManagerModel, mockRevenueViewModel, mockMainMenuViewModel);
        assertNotNull(view, "BorrowBookView should not be null");
        // Since we cannot directly check the BorrowBookController, we verify interactions or
        // ensure that methods expected to be called on the ViewModel are indeed called,
        // which would indirectly confirm that the controller and view are interacting correctly.
        verify(mockRevenueViewModel, atLeastOnce()).addPropertyChangeListener(any(PropertyChangeListener.class));
    }

}