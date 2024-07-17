package app.usecase_factory.rent;

import data_access.data_base_return_book.DataBaseReturnObejct;
import data_access.data_base_return_book.DatabaseReturnInterface;
import interface_adapter.RentInformation.returnbook.ReturnBookController;
import interface_adapter.RentInformation.returnbook.ReturnBookPresenter;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.ReturnBook.ReturnBookInputBoundary;
import use_case.rent_book.ReturnBook.ReturnBookInteractor;
import use_case.rent_book.ReturnBook.ReturnBookOutputBoundary;
import view.views.ReturnBookView;

import java.io.IOException;
import java.text.ParseException;

public class ReturnBookUseCaseFactory {
    private ReturnBookUseCaseFactory(){}

    public static ReturnBookView create(ViewManagerModel viewManagerModel, ReturnBookViewModel returnBookViewModel, MainMenuViewModel mainMenuViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) throws IOException, ParseException {
        ReturnBookController returnBookController = createReturnBookUseCase(viewManagerModel, returnBookViewModel, mainMenuViewModel, returnOrBorrowViewModel);
        return new ReturnBookView(returnBookViewModel, returnBookController);
    }

    private static ReturnBookController createReturnBookUseCase(ViewManagerModel viewManagerModel, ReturnBookViewModel returnBookViewModel, MainMenuViewModel mainMenuViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel){
        DatabaseReturnInterface databaseReturn = new DataBaseReturnObejct();
        ReturnBookOutputBoundary returnBookPresenter = new ReturnBookPresenter(viewManagerModel, mainMenuViewModel, returnBookViewModel, returnOrBorrowViewModel);
        ReturnBookInputBoundary  returnBookInteractor = new ReturnBookInteractor(databaseReturn ,returnBookPresenter);
        return new ReturnBookController(returnBookInteractor);
    }


}
