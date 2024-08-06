package app.usecase_factory.rent;

import static org.junit.jupiter.api.Assertions.*;

import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.Test;
import view.views.RentMenuView;

class RentMenuUseCaseFactoryTest {

    @Test
    void testCreateRentMenuViewSuccess() {
        // Assuming dependencies internally are properly set up to not throw exceptions
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        RentMenuViewModel rentMenuViewModel = new RentMenuViewModel();
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        ReturnOrBorrowViewModel returnOrBorrowViewModel = new ReturnOrBorrowViewModel();

        RentMenuView result = RentMenuUseCaseFactory.create(viewManagerModel, rentMenuViewModel, mainMenuViewModel, returnOrBorrowViewModel);
        assertNotNull(result, "RentMenuView should not be null on successful creation");
    }
}
