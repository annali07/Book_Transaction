package app.usecase_factory;

import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.add_book_repository.BookRepositoryDataAccessObject;
import data_access.database_transaction_entry.DataTransactionEntryDataAccessObject;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.purchase_book.PurchaseBookPresenter;
import interface_adapter.purchase_book.PurchaseControllor;
import interface_adapter.purchase_book.PurchaseViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.purchase_book.PurchaseInputDataBoundary;
import use_case.purchase_book.PurchaseOutputDataBoundary;
import use_case.purchase_book.PurchaseInteractor;
import view.views.FailedToPurchaseView;
import view.views.PurchaseView;
import view.views.SuccessfullyPurchaseTheBookView;

import javax.swing.*;
import java.io.IOException;

/**
 * Factory class for creating instances related to the PurchaseBook use case.
 */
public class PurchaseBookCaseFactory {
    private PurchaseBookCaseFactory() {
    }

    /**
     * Creates an instance of PurchaseView.
     *
     * @param viewManagerModel the model managing views
     * @param purchaseViewModel the view model for purchase
     * @param mainMenuViewModel the view model for the main menu
     * @return an instance of PurchaseView, or null if an IOException occurs
     */
    public static PurchaseView create(ViewManagerModel viewManagerModel, PurchaseViewModel purchaseViewModel, MainMenuViewModel mainMenuViewModel) {

        try {
            PurchaseControllor purchaseControllor = createPurchaseUseCase(viewManagerModel, purchaseViewModel, mainMenuViewModel);
            return new PurchaseView(purchaseViewModel, purchaseControllor);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;

    }

    /**
     * Creates an instance of PurchaseControllor.
     *
     * @param viewManagerModel the model managing views
     * @param purchaseViewModel the view model for purchase
     * @param mainMenuViewModel the view model for the main menu
     * @return an instance of PurchaseControllor
     * @throws IOException if an error occurs while creating the data access objects
     */
    private static PurchaseControllor createPurchaseUseCase(ViewManagerModel viewManagerModel, PurchaseViewModel purchaseViewModel, MainMenuViewModel mainMenuViewModel) throws IOException {
        BookRepositoryDataAccessInterface bookRepositoryDataAccessObj = new BookRepositoryDataAccessObject();
        DatabaseTransactionEntryDataAccessInterface dataTransactionEntryDataAccessObject = new DataTransactionEntryDataAccessObject();

        PurchaseOutputDataBoundary purchaseOutputDataBoundary = new PurchaseBookPresenter(purchaseViewModel, viewManagerModel, mainMenuViewModel);
        PurchaseInputDataBoundary purchaseInteractor = new PurchaseInteractor(bookRepositoryDataAccessObj, dataTransactionEntryDataAccessObject, purchaseOutputDataBoundary);

        return new PurchaseControllor(purchaseInteractor);
    }

    /**
     * Creates an instance of SuccessfullyPurchaseTheBookView.
     *
     * @param viewManagerModel the model managing views
     * @param purchaseViewModel the view model for purchase
     * @param mainMenuViewModel the view model for the main menu
     * @return an instance of SuccessfullyPurchaseTheBookView, or null if an IOException occurs
     */
    public static SuccessfullyPurchaseTheBookView createSuccessfully(ViewManagerModel viewManagerModel, PurchaseViewModel purchaseViewModel, MainMenuViewModel mainMenuViewModel) {

        try {
            PurchaseControllor purchaseControllor = createPurchaseUseCase(viewManagerModel, purchaseViewModel, mainMenuViewModel);
            return new SuccessfullyPurchaseTheBookView(purchaseViewModel, purchaseControllor);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Successfully purchased.");
        }

        return null;
    }

    /**
     * Creates an instance of FailedToPurchaseView.
     *
     * @param viewManagerModel the model managing views
     * @param purchaseViewModel the view model for purchase
     * @param mainMenuViewModel the view model for the main menu
     * @return an instance of FailedToPurchaseView, or null if an IOException occurs
     */
    public static FailedToPurchaseView failedCreate(ViewManagerModel viewManagerModel, PurchaseViewModel purchaseViewModel, MainMenuViewModel mainMenuViewModel) {

        try {
            PurchaseControllor purchaseControllor = createPurchaseUseCase(viewManagerModel, purchaseViewModel, mainMenuViewModel);
            return new FailedToPurchaseView(purchaseViewModel, purchaseControllor);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to purchase.");
        }

        return null;
    }
}



