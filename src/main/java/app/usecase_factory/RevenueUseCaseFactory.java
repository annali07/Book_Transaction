package app.usecase_factory;

import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;

import interface_adapter.calculate_revenue.RevenueController;
import interface_adapter.calculate_revenue.RevenuePresenter;
import interface_adapter.calculate_revenue.RevenueViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.calculate_revenue.RevenueDataBoundary;
import use_case.calculate_revenue.RevenueInteractor;
import use_case.calculate_revenue.RevenueOutputDataBoundary;
import view.views.RevenueView;


public class RevenueUseCaseFactory {
    private RevenueUseCaseFactory() {}

    public static RevenueView create(ViewManagerModel viewManagerModel, RevenueViewModel revenueViewModel, MainMenuViewModel mainMenuViewModel) {
        RevenueController revenueController = createRevenueUsecase(viewManagerModel, revenueViewModel, mainMenuViewModel);
        return new RevenueView(revenueViewModel, revenueController);
    }

    private static RevenueController createRevenueUsecase(ViewManagerModel viewManagerModel, RevenueViewModel revenueViewModel, MainMenuViewModel mainMenuViewModel) {
        RevenueOutputDataBoundary revenuePresenter = new RevenuePresenter(revenueViewModel, viewManagerModel, mainMenuViewModel);
        return new RevenueController(new RevenueInteractor(revenuePresenter));
    }
}
