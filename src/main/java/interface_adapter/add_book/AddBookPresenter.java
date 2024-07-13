package interface_adapter.add_book;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.add_book.AddBookOutputBoundary;
import view.views.MainMenuView;

public class AddBookPresenter implements AddBookOutputBoundary {
    private final AddBookViewModel addBookViewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    public AddBookPresenter(AddBookViewModel addBookViewModel, ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.addBookViewModel = addBookViewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    public void prepareSuccessView(){
        viewManagerModel.setActiveView(addBookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched to Add Book View");
    }
}
