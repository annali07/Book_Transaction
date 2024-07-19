package app.usecase_factory;

import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.add_book_repository.BookRepositoryDataAccessObject;
import data_access.api.ExternalBookApi;
import interface_adapter.add_book.AddBookController;
import interface_adapter.add_book.AddBookPresenter;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.add_book.AddBookInputBoundary;
import use_case.add_book.AddBookInteractor;
import use_case.add_book.AddBookOutputBoundary;
import view.views.AddBookView;
import view.views.MainMenuView;

import javax.swing.*;
import java.io.IOException;

public class AddBookUseCaseFactory {
    /** Prevent instantiation. */
    private AddBookUseCaseFactory() {}

    public static AddBookView create(ViewManagerModel viewManagerModel, AddBookViewModel addBookViewModel, MainMenuViewModel mainMenuViewModel) {
        try {
            AddBookController addBookController = createAddBookUsecase(viewManagerModel, addBookViewModel, mainMenuViewModel);
            return new AddBookView(addBookViewModel, addBookController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static AddBookController createAddBookUsecase(ViewManagerModel viewManagerModel, AddBookViewModel addBookViewModel, MainMenuViewModel mainMenuViewModel) throws IOException {
        BookRepositoryDataAccessInterface bookRepositoryDataAccessObj = new BookRepositoryDataAccessObject();
        ExternalBookApi externalBookApi = new ExternalBookApi();

        AddBookOutputBoundary addBookOutputBoundary = new AddBookPresenter(addBookViewModel, viewManagerModel, mainMenuViewModel);
        AddBookInputBoundary addBookInteractor = new AddBookInteractor(
                bookRepositoryDataAccessObj, externalBookApi, addBookOutputBoundary);

        return new AddBookController(addBookInteractor);
    }
}
