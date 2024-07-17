package app.usecase_factory.rent;

import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.add_book_repository.BookRepositoryDataAccessObject;
import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;
import data_access.database_rental_entry.DatabaseRentalEntryDataAccessObject;
import interface_adapter.RentMenu.RentMenuController;
import interface_adapter.RentMenu.RentMenuPresenter;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.RentMenu.RentMenuInteractor;
import use_case.rent_book.RentMenu.RentMenuInputBoundary;
import use_case.rent_book.RentMenu.RentMenuOutputBoundary;
import view.views.RentMenuView;

import javax.swing.*;
import java.io.IOException;

public class RentMenuUseCaseFactory {
    private RentMenuUseCaseFactory(){}

    public static RentMenuView create(ViewManagerModel viewManagerModel, RentMenuViewModel rentMenuViewModel, MainMenuViewModel mainMenuViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        try {
            RentMenuController rentMenuController = createUserRentMenuUseCase(viewManagerModel, rentMenuViewModel, mainMenuViewModel, returnOrBorrowViewModel);
            return new RentMenuView(rentMenuViewModel, rentMenuController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Wrong.");
        }
        return null;
    }
    private static RentMenuController createUserRentMenuUseCase(ViewManagerModel viewManagerModel, RentMenuViewModel rentMenuViewModel, MainMenuViewModel mainMenuViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) throws IOException {
        BookRepositoryDataAccessInterface bookRepositoryDataAccessObj = new BookRepositoryDataAccessObject();
        DatabaseRentalEntryDataAccessInterface userGateway = new DatabaseRentalEntryDataAccessObject();

        RentMenuOutputBoundary rentMenuOutputBoundary = new RentMenuPresenter(viewManagerModel,rentMenuViewModel, mainMenuViewModel, returnOrBorrowViewModel);
        RentMenuInputBoundary rentMenuInteractor = new RentMenuInteractor(userGateway, rentMenuOutputBoundary);

        return new RentMenuController(rentMenuInteractor);
    }
}
