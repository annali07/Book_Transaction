package interface_adapter.add_book;

import interface_adapter.ViewManagerModel;

public class AddBookPresenter {
    private final AddBookViewModel addBookViewModel;
    private ViewManagerModel viewManagerModel;

    public AddBookPresenter(AddBookViewModel addBookViewModel, ViewManagerModel viewManagerModel) {
        this.addBookViewModel = addBookViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(){
        viewManagerModel.setActiveView(addBookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched to Add Book View");
    }
}
