package interface_adapter.purchase_book;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseBookPresenterTest {

    private PurchaseBookPresenter presenter;
    private TestPurchaseViewModel purchaseViewModel;
    private TestViewManagerModel viewManagerModel;
    private TestMainMenuViewModel mainMenuViewModel;

    @BeforeEach
    void setUp() {
        purchaseViewModel = new TestPurchaseViewModel();
        viewManagerModel = new TestViewManagerModel();
        mainMenuViewModel = new TestMainMenuViewModel();
        presenter = new PurchaseBookPresenter(purchaseViewModel, viewManagerModel, mainMenuViewModel);
    }

    @Test
    void testPrepareSuccessView() {
        int result = presenter.prepareSuccessView();
        assertEquals(mainMenuViewModel.getViewName(), viewManagerModel.getActiveView());
        assertTrue(viewManagerModel.propertyChangedFired);
        assertEquals(1, result);
    }

    @Test
    void testPrepareFailView() {
        int result = presenter.prepareFailView();
        assertEquals(2, result);
    }

    @Test
    void testPrepareCancelView() {
        int result = presenter.prepareCancelView();
        assertEquals(mainMenuViewModel.getViewName(), viewManagerModel.getActiveView());
        assertTrue(viewManagerModel.propertyChangedFired);
        assertEquals(0, result);
    }

    // Test classes for PurchaseViewModel, ViewManagerModel, and MainMenuViewModel

    private static class TestPurchaseViewModel extends PurchaseViewModel {
        // Implement any necessary methods if required
    }

    private static class TestViewManagerModel extends ViewManagerModel {
        private String activeView;
        boolean propertyChangedFired = false;

        @Override
        public void setActiveView(String viewName) {
            this.activeView = viewName;
        }

        @Override
        public String getActiveView() {
            return activeView;
        }

        @Override
        public void firePropertyChanged() {
            propertyChangedFired = true;
        }
    }

    private static class TestMainMenuViewModel extends MainMenuViewModel {
        @Override
        public String getViewName() {
            return "main menu";
        }

        // Implement any necessary methods if required
    }
}

