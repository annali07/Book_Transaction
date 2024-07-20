package app.usecase_factory.rent;

import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowController;
import interface_adapter.returnorborrow.ReturnOrBorrowPresenter;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.ReturnOrBorrow.RobInteractor;
import use_case.rent_book.ReturnOrBorrow.RobOutputBoundary;
import view.views.ReturnOrBorrowView;

import javax.swing.*;
import java.io.IOException;

/**
 * A use case factory for creating ReturnOrBorrowView
 */
public class RobUseCaseFactory {
    private RobUseCaseFactory(){}

    /**
     * Creates the ReturnOrBorrowView with viewManagerModel, returnOrBorrowViewModel,
     * rentMenuViewModel, returnBookViewModel, borrowBookViewModel, and mainMenuViewModel
     * @param viewManagerModel
     * @param returnOrBorrowViewModel
     * @param rentMenuViewModel
     * @param returnBookViewModel
     * @param borrowBookViewModel
     * @param mainMenuViewModel
     *
     * @return ReturnOrBorrowView
     */
    public static ReturnOrBorrowView create(ViewManagerModel viewManagerModel, ReturnOrBorrowViewModel returnOrBorrowViewModel, RentMenuViewModel rentMenuViewModel, ReturnBookViewModel returnBookViewModel, BorrowBookViewModel borrowBookViewModel, MainMenuViewModel mainMenuViewModel) {
        try {
            ReturnOrBorrowController returnOrBorrowController = createUserRobUseCase(viewManagerModel, returnOrBorrowViewModel, rentMenuViewModel, returnBookViewModel, borrowBookViewModel, mainMenuViewModel);
            return new ReturnOrBorrowView(returnOrBorrowViewModel, returnOrBorrowController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Wrong.");
        }
        return null;
    }

    /**
     * Creates the ReturnOrBorrowController with viewManagerModel, returnOrBorrowViewModel,
     * rentMenuViewModel, returnBookViewModel, borrowBookViewModel, and mainMenuViewModel
     * @param viewManagerModel
     * @param returnOrBorrowViewModel
     * @param rentMenuViewModel
     * @param returnBookViewModel
     * @param borrowBookViewModel
     * @param mainMenuViewModel
     *
     * @return ReturnOrBorrowController
     */
    private static ReturnOrBorrowController createUserRobUseCase(ViewManagerModel viewManagerModel, ReturnOrBorrowViewModel returnOrBorrowViewModel, RentMenuViewModel rentMenuViewModel, ReturnBookViewModel returnBookViewModel, BorrowBookViewModel borrowBookViewModel, MainMenuViewModel mainMenuViewModel) throws IOException {
        RobOutputBoundary returnOrBorrowPresenter = new ReturnOrBorrowPresenter(returnOrBorrowViewModel, viewManagerModel, rentMenuViewModel, returnBookViewModel, borrowBookViewModel, mainMenuViewModel);
        RobInteractor robInteractor = new RobInteractor(returnOrBorrowPresenter);
        return new ReturnOrBorrowController(robInteractor);
    }

}
