package interface_adapter.calculate_revenue;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.calculate_revenue.RevenueOutputDataBoundary;

import javax.swing.*;

/**
 * The RevenuePresenter class handles the presentation logic for the revenue calculation results.
 * It interacts with the view model and the view manager to display success, failure, and cancel views.
 *
 */
public class RevenuePresenter implements RevenueOutputDataBoundary {
    private final RevenueViewModel viewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    /**
     * Constructs a RevenuePresenter object with the specified view model, view manager, and main menu view model.
     *
     * @param viewModel the view model for revenue presentation
     * @param viewManagerModel the view manager model
     * @param mainMenuViewModel the main menu view model
     */
    public RevenuePresenter(RevenueViewModel viewModel, ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    /**
     * Prepares and displays the success view with the specified display string.
     *
     * @param displayString the string to display in the success view
     */
    @Override
    public void prepareSuccessView(String displayString) {
        JOptionPane.showMessageDialog(null, displayString, "Revenue", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Prepares and displays the failure view with the specified error message.
     *
     * @param error the error message to display in the failure view
     */
    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Prepares and switches to the cancel view.
     */
    @Override
    public void prepareCancelView(){
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Revenue View to Main Menu");
    }
}
