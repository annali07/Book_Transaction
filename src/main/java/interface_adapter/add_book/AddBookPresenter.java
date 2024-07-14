package interface_adapter.add_book;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.add_book.AddBookOutputBoundary;

/**
 * Presenter for handling the output of the add book use case.
 * It updates the view models and manages view transitions based on the result of the use case execution.
 */
public class AddBookPresenter implements AddBookOutputBoundary {
    private final AddBookViewModel addBookViewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    /**
     * Constructs an AddBookPresenter with the specified view models.
     *
     * @param addBookViewModel the view model for the add book view
     * @param viewManagerModel the view manager model for managing view transitions
     * @param mainMenuViewModel the view model for the main menu view
     */
    public AddBookPresenter(AddBookViewModel addBookViewModel, ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.addBookViewModel = addBookViewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    /**
     * Prepares the view for a successful add book operation.
     * Switches the active view to the add book view.
     */
    public void prepareSuccessView(){
        viewManagerModel.setActiveView(addBookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched to Add Book View");
    }

    /**
     * Prepares the view for a failed add book operation.
     * Displays an error message.
     *
     * @param error the error message to display
     */
    @Override
    public void prepareFailView(String error) {
        System.out.println("Failed to add book");
    }

    /**
     * Prepares the view for a canceled add book operation.
     * Switches the active view to the main menu view.
     */
    @Override
    public void prepareCancelView(){
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Add Book View to Main Menu");
    }
}
