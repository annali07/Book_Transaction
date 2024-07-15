package app.usecase_factory;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.purchase_book.PurchaseBookPresenter;
import interface_adapter.purchase_book.PurchaseControllor;
import interface_adapter.purchase_book.PurchaseViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.purchase_book.PurchaseInputDataBoundary;
import use_case.purchase_book.PurchaseOutputDataBoundary;
import use_case.purchase_book.PurchaseUseCase;
import view.views.FailedToPurchaseView;
import view.views.PurchaseView;
import view.views.SuccessfullyPurchaseTheBookView;

import javax.swing.*;
import java.io.IOException;

public class PurchaseBookCaseFactory {
    private PurchaseBookCaseFactory() {
    }

    public static PurchaseView create(ViewManagerModel viewManagerModel, PurchaseViewModel purchaseViewModel, MainMenuViewModel mainMenuViewModel) {

        try {
            PurchaseControllor purchaseControllor = createPurchaseUseCase(viewManagerModel, purchaseViewModel, mainMenuViewModel);
            return new PurchaseView(purchaseViewModel, purchaseControllor);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;

    }

    private static PurchaseControllor createPurchaseUseCase(ViewManagerModel viewManagerModel, PurchaseViewModel purchaseViewModel, MainMenuViewModel mainMenuViewModel) throws IOException {

        PurchaseOutputDataBoundary purchaseOutputDataBoundary = new PurchaseBookPresenter(purchaseViewModel, viewManagerModel, mainMenuViewModel);
        PurchaseInputDataBoundary purchaseInteractor = new PurchaseUseCase(purchaseOutputDataBoundary);

        return new PurchaseControllor(purchaseInteractor);
    }

    public static SuccessfullyPurchaseTheBookView createSuccessfully(ViewManagerModel viewManagerModel, PurchaseViewModel purchaseViewModel, MainMenuViewModel mainMenuViewModel) {

        try {
            PurchaseControllor purchaseControllor = createPurchaseUseCase(viewManagerModel, purchaseViewModel, mainMenuViewModel);
            return new SuccessfullyPurchaseTheBookView(purchaseViewModel, purchaseControllor);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Successfully purchased.");
        }

        return null;
    }

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



