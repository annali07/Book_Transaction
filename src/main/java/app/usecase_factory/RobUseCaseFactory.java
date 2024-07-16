package app.usecase_factory;

import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;
import data_access.database_rental_entry.DatabaseRentalEntryDataAccessObject;
import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuController;
import interface_adapter.RentMenu.RentMenuPresenter;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowController;
import interface_adapter.returnorborrow.ReturnOrBorrowPresenter;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.RentMenu.RentMenuInputBoundary;
import use_case.rent_book.RentMenu.RentMenuInteractor;
import use_case.rent_book.RentMenu.RentMenuOutputBoundary;
import use_case.rent_book.ReturnOrBorrow.RobInteractor;
import use_case.rent_book.ReturnOrBorrow.RobOutputBoundary;
import view.views.RentMenuView;
import view.views.ReturnOrBorrowView;

import javax.swing.*;
import java.io.IOException;

public class RobUseCaseFactory {
    private RobUseCaseFactory(){}

    public static ReturnOrBorrowView create(ViewManagerModel viewManagerModel, ReturnOrBorrowViewModel returnOrBorrowViewModel, RentMenuViewModel rentMenuViewModel, ReturnBookViewModel returnBookViewModel, BorrowBookViewModel borrowBookViewModel) {
        try {
            ReturnOrBorrowController returnOrBorrowController = createUserRobUseCase(viewManagerModel, returnOrBorrowViewModel, rentMenuViewModel, returnBookViewModel, borrowBookViewModel);
            return new ReturnOrBorrowView(returnOrBorrowViewModel, returnOrBorrowController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Wrong.");
        }
        return null;
    }

    private static ReturnOrBorrowController createUserRobUseCase(ViewManagerModel viewManagerModel, ReturnOrBorrowViewModel returnOrBorrowViewModel, RentMenuViewModel rentMenuViewModel, ReturnBookViewModel returnBookViewModel, BorrowBookViewModel borrowBookViewModel) throws IOException {
        RobOutputBoundary returnOrBorrowPresenter = new ReturnOrBorrowPresenter(returnOrBorrowViewModel, viewManagerModel, rentMenuViewModel, returnBookViewModel, borrowBookViewModel);
        RobInteractor robInteractor = new RobInteractor(returnOrBorrowPresenter);
        return new ReturnOrBorrowController(robInteractor);
    }

}
