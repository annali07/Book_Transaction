package app.usecase_factory.rent;

import data_access.database_borrow_book.DatabaseBorrowInterface;
import data_access.database_borrow_book.DatabaseBorrowObject;
import interface_adapter.RentInformation.borrowbook.BorrowBookController;
import interface_adapter.RentInformation.borrowbook.BorrowBookPresenter;
import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.BorrowBook.BorrowBookInputBoundary;
import use_case.rent_book.BorrowBook.BorrowBookInteractor;
import use_case.rent_book.BorrowBook.BorrowBookOutputBoundary;
import view.views.BorrowBookView;

import java.io.IOException;
import java.text.ParseException;

/**
 * A use case factory for creating BorrowBookView
 */
public class BorrowBookUseCaseFactory {
    private BorrowBookUseCaseFactory(){}

    /**
     * Creates the BorrowBookView with viewManagerModel, returnOrBorrowViewModel, borrowBookViewModel, and mainMenuViewModel
     * @param viewManagerModel
     * @param returnOrBorrowViewModel
     * @param borrowBookViewModel
     * @param mainMenuViewModel
     *
     * @return BorrowBookView
     */
    public static BorrowBookView create(ViewManagerModel viewManagerModel, BorrowBookViewModel borrowBookViewModel, MainMenuViewModel mainMenuViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) throws IOException, ParseException {
        BorrowBookController borrowBookController = createReturnBookUseCase(viewManagerModel, borrowBookViewModel, mainMenuViewModel, returnOrBorrowViewModel);
        return new BorrowBookView(borrowBookViewModel, borrowBookController);
    }

    /**
     * Creates the BorrowBookController with viewManagerModel, returnOrBorrowViewModel,
     * borrowBookViewModel, and mainMenuViewModel
     * @param viewManagerModel
     * @param returnOrBorrowViewModel
     * @param borrowBookViewModel
     * @param mainMenuViewModel
     *
     * @return BorrowBookController
     */
    private static BorrowBookController createReturnBookUseCase(ViewManagerModel viewManagerModel, BorrowBookViewModel borrowBookViewModel, MainMenuViewModel mainMenuViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel){
        DatabaseBorrowInterface databaseBorrow = new DatabaseBorrowObject();
        BorrowBookOutputBoundary borrowPresenter = new BorrowBookPresenter(viewManagerModel, mainMenuViewModel, borrowBookViewModel, returnOrBorrowViewModel);
        BorrowBookInputBoundary borrowBookInteractor = new BorrowBookInteractor(databaseBorrow, borrowPresenter);
        return new BorrowBookController(borrowBookInteractor);
    }
}
