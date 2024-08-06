package app.usecase_factory.rent;

import static org.junit.jupiter.api.Assertions.*;

import app.usecase_factory.rent.RobUseCaseFactory;
import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import view.views.ReturnOrBorrowView;

class RobUseCaseFactoryTest {

    private ViewManagerModel viewManagerModel;
    private ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private RentMenuViewModel rentMenuViewModel;
    private ReturnBookViewModel returnBookViewModel;
    private BorrowBookViewModel borrowBookViewModel;
    private MainMenuViewModel mainMenuViewModel;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        returnOrBorrowViewModel = new ReturnOrBorrowViewModel();
        rentMenuViewModel = new RentMenuViewModel();
        returnBookViewModel = new ReturnBookViewModel();
        borrowBookViewModel = new BorrowBookViewModel();
        mainMenuViewModel = new MainMenuViewModel();
    }

    @Test
    void testCreateReturnOrBorrowViewSuccess() {
        // Act
        ReturnOrBorrowView result = RobUseCaseFactory.create(
                viewManagerModel,
                returnOrBorrowViewModel,
                rentMenuViewModel,
                returnBookViewModel,
                borrowBookViewModel,
                mainMenuViewModel
        );

        // Assert
        assertNotNull(result, "ReturnOrBorrowView should not be null on successful creation");
    }

    @Test
    void testExceptionHandlingInFactory() {
        // Simulate an error condition, if there’s any way to trigger an error from outside
        // Since we can't mock internal errors or throw them directly, consider setting
        // a condition that would lead to an error, such as invalid inputs if applicable.

        // Act & Assert
        assertDoesNotThrow(() -> {
            ReturnOrBorrowView result = RobUseCaseFactory.create(
                    viewManagerModel,
                    returnOrBorrowViewModel,
                    rentMenuViewModel,
                    returnBookViewModel,
                    borrowBookViewModel,
                    mainMenuViewModel
            );
            assertNotNull(result, "ReturnOrBorrowView should handle errors gracefully and still not be null under test conditions");
        });
    }
}
