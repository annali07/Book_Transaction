package interface_adapter.calculate_revenue;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.calculate_revenue.RevenueOutputDataBoundary;

import javax.swing.*;

public class RevenuePresenter implements RevenueOutputDataBoundary {
    private final RevenueViewModel viewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;


    public RevenuePresenter(RevenueViewModel viewModel, ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    @Override
    public void prepareSuccessView(String displayString) {
        JOptionPane.showMessageDialog(null, displayString, "Revenue", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void prepareCancelView(){
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Revenue View to Main Menu");
    }
}
