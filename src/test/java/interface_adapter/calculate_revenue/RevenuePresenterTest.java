package interface_adapter.calculate_revenue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import interface_adapter.calculate_revenue.RevenuePresenter;
import interface_adapter.calculate_revenue.RevenueViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.calculate_revenue.RevenueOutputDataBoundary;

import static org.mockito.Mockito.*;

public class RevenuePresenterTest {

    private RevenueViewModel viewModel;
    private ViewManagerModel viewManagerModel;
    private MainMenuViewModel mainMenuViewModel;
    private RevenuePresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = mock(RevenueViewModel.class);
        viewManagerModel = mock(ViewManagerModel.class);
        mainMenuViewModel = mock(MainMenuViewModel.class);
        presenter = new RevenuePresenter(viewModel, viewManagerModel, mainMenuViewModel);
    }

    @Test
    void testPrepareSuccessView() {
        presenter.prepareSuccessView("Revenue: 1000.0");

        verify(viewModel, never()).firePropertyChanged();
        // You can also add assertions to check if the JOptionPane was displayed
    }

    @Test
    void testPrepareFailView() {
        presenter.prepareFailView("Error occurred");

        verify(viewModel, never()).firePropertyChanged();
        // You can also add assertions to check if the JOptionPane was displayed
    }

    @Test
    void testPrepareCancelView() {
        when(mainMenuViewModel.getViewName()).thenReturn("MainMenu");

        presenter.prepareCancelView();

        verify(viewManagerModel).setActiveView("MainMenu");
        verify(viewManagerModel).firePropertyChanged();
        // You can also add assertions to check the console output
    }
}




