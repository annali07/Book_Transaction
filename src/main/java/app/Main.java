package app;

import app.usecase_factory.AddBookUseCaseFactory;
import app.usecase_factory.LoginUseCaseFactory;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import view.views.LoginView;
import view.views.MainMenuView;
import view.view_manager.ViewManager;
import view.views.AddBookView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // Main Application Window
        JFrame application = new JFrame("Book Transaction");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


         CardLayout cardLayout = new CardLayout();
//        FlowLayout layout = new FlowLayout();

        // View objects. One view visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will be observed by the Views.

        LoginViewModel loginViewModel = new LoginViewModel();
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        AddBookViewModel addBookViewModel = new AddBookViewModel();

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, mainMenuViewModel);
        MainMenuView mainMenuView = new MainMenuView(mainMenuViewModel, addBookViewModel, viewManagerModel);
        AddBookView addBookView = AddBookUseCaseFactory.create(viewManagerModel, addBookViewModel, mainMenuViewModel);

        views.add(loginView, loginView.viewName);
        views.add(mainMenuView, mainMenuView.viewName);
        views.add(addBookView, addBookView.viewName);

        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}