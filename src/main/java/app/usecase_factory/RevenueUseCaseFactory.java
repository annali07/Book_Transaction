package app.usecase_factory;

import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;
import data_access.database_rental_entry.DatabaseRentalEntryDataAccessObject;
import data_access.database_transaction_entry.DataTransactionEntryDataAccessObject;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;

import interface_adapter.calculate_revenue.RevenueController;
import interface_adapter.calculate_revenue.RevenuePresenter;
import interface_adapter.calculate_revenue.RevenueViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.calculate_revenue.RevenueInputBoundary;
import use_case.calculate_revenue.RevenueInteractor;
import use_case.calculate_revenue.RevenueOutputDataBoundary;
import view.views.RevenueView;

import javax.swing.*;
import java.io.IOException;

/**
 * Factory class for creating instances related to the Revenue use case.
 */
public class RevenueUseCaseFactory {
    private RevenueUseCaseFactory() {}

    /**
     * Creates an instance of RevenueView.
     *
     * @param viewManagerModel the model managing views
     * @param revenueViewModel the view model for revenue
     * @param mainMenuViewModel the view model for the main menu
     * @return an instance of RevenueView
     */
    public static RevenueView create(ViewManagerModel viewManagerModel, RevenueViewModel revenueViewModel, MainMenuViewModel mainMenuViewModel) {
        RevenueController revenueController = createRevenueUsecase(viewManagerModel, revenueViewModel, mainMenuViewModel);
        return new RevenueView(revenueViewModel, revenueController);
    }

    /**
     * Creates an instance of RevenueController.
     *
     * @param viewManagerModel the model managing views
     * @param revenueViewModel the view model for revenue
     * @param mainMenuViewModel the view model for the main menu
     * @return an instance of RevenueController
     */
    private static RevenueController createRevenueUsecase(ViewManagerModel viewManagerModel, RevenueViewModel revenueViewModel, MainMenuViewModel mainMenuViewModel) {
        DatabaseRentalEntryDataAccessInterface databaseRentalEntryDataAccessInterface = new DatabaseRentalEntryDataAccessObject();
        DatabaseTransactionEntryDataAccessInterface databaseTransactionEntryDataAccessInterface = new DataTransactionEntryDataAccessObject();

        RevenueOutputDataBoundary revenuePresenter = new RevenuePresenter(revenueViewModel, viewManagerModel, mainMenuViewModel);
        RevenueInputBoundary revenueInteractor = new RevenueInteractor(databaseRentalEntryDataAccessInterface, databaseTransactionEntryDataAccessInterface, revenuePresenter);
        return new RevenueController(revenueInteractor);
    }
}
