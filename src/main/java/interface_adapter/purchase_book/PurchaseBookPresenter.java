package interface_adapter.purchase_book;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.purchase_book.PurchaseOutputData;
import use_case.purchase_book.PurchaseOutputDataBoundary;


/**
 * PurchaseBookPresenter class implements the PurchaseOutputDataBoundary interface to handle the result of book purchases.
 *
 * @version 1.0
 */
public class PurchaseBookPresenter implements PurchaseOutputDataBoundary{
    private final PurchaseViewModel purchaseViewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    private int CANCELLED = 0;
    private int SUCCESS = 1;
    private int FAILED = 2;


    /**
     * Constructs a PurchaseBookPresenter object.
     *
     * @param purchaseViewModel the PurchaseViewModel object
     * @param viewManagerModel the ViewManagerModel object
     * @param mainMenuViewModel the MainMenuViewModel object
     */
    public PurchaseBookPresenter(PurchaseViewModel purchaseViewModel, ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.purchaseViewModel = purchaseViewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    /**
     * Handles the view for a successful purchase.
     */
    @Override
    public int prepareSuccessView(){
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Purchase Success");
        return SUCCESS;
    }

    /**
     * Handles the view for a failed purchase.
     */
    @Override
    public int prepareFailView(){
        System.out.println("Failed to find the book");
        return FAILED;
    }

    /**
     * Handles the view for a canceled purchase.
     */
    public int prepareCancelView(){
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Cancel Purchase");
        return CANCELLED;
    }
}
