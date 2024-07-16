package app;

import app.usecase_factory.AddBookUseCaseFactory;
import app.usecase_factory.LoginUseCaseFactory;
import app.usecase_factory.PurchaseBookCaseFactory;
import app.usecase_factory.RevenueUseCaseFactory;

import app.usecase_factory.*;
import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.calculate_revenue.RevenueViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.purchase_book.PurchaseControllor;
import interface_adapter.purchase_book.PurchaseViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.purchase_book.PurchaseUseCase;
import view.views.*;
import view.views.*;
import view.view_manager.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        // Main Application Window
        JFrame application = new JFrame("Book Transaction");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

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
        PurchaseViewModel purchaseViewModel = new PurchaseViewModel();
        RevenueViewModel revenueViewModel = new RevenueViewModel();
        RentMenuViewModel rentMenuViewModel = new RentMenuViewModel();
        ReturnOrBorrowViewModel returnOrBorrowViewModel = new ReturnOrBorrowViewModel();
        ReturnBookViewModel returnBookViewModel = new ReturnBookViewModel();
        BorrowBookViewModel borrowBookViewModel = new BorrowBookViewModel();

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, mainMenuViewModel);
        // last argument originally purchase view model
        MainMenuView mainMenuView = new MainMenuView(mainMenuViewModel, addBookViewModel, viewManagerModel, rentMenuViewModel, purchaseViewModel, revenueViewModel);
        SuccessfullyPurchaseTheBookView successfullyPurchaseTheBookView =
                PurchaseBookCaseFactory.createSuccessfully(viewManagerModel, purchaseViewModel, mainMenuViewModel);
        FailedToPurchaseView failedToPurchaseView =
                PurchaseBookCaseFactory.failedCreate(viewManagerModel, purchaseViewModel, mainMenuViewModel);

        AddBookView addBookView = AddBookUseCaseFactory.create(viewManagerModel, addBookViewModel, mainMenuViewModel);
        PurchaseView purchaseView = PurchaseBookCaseFactory.create(viewManagerModel, purchaseViewModel, mainMenuViewModel);
        RevenueView revenueView = RevenueUseCaseFactory.create(viewManagerModel, revenueViewModel, mainMenuViewModel);

        RentMenuView rentMenuView = RentMenuUseCaseFactory.create(viewManagerModel, rentMenuViewModel, mainMenuViewModel, returnOrBorrowViewModel);
        ReturnOrBorrowView returnOrBorrowView = RobUseCaseFactory.create(viewManagerModel, returnOrBorrowViewModel, rentMenuViewModel, returnBookViewModel, borrowBookViewModel);
        ReturnBookView returnBookView = ReturnBookUseCaseFactory.create(viewManagerModel, returnBookViewModel, mainMenuViewModel, returnOrBorrowViewModel);
        BorrowBookView borrowBookView = BorrowBookUseCaseFactory.create(viewManagerModel, borrowBookViewModel, mainMenuViewModel, returnOrBorrowViewModel);


        views.add(loginView, loginView.viewName);
        views.add(mainMenuView, mainMenuView.viewName);
        views.add(addBookView, addBookView.viewName);
        views.add(purchaseView, purchaseView.viewName);
        views.add(successfullyPurchaseTheBookView, successfullyPurchaseTheBookView.viewName);
        views.add(failedToPurchaseView, failedToPurchaseView.viewName);
        views.add(revenueView, revenueView.viewName);


        views.add(rentMenuView, rentMenuView.viewName);
        views.add(returnOrBorrowView, returnOrBorrowView.viewName);
        views.add(returnBookView, returnBookView.viewName);
        views.add(borrowBookView, borrowBookView.viewName);
        // Need to add some more views

        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();





        application.pack();
        application.setVisible(true);



    }
}