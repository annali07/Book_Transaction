package app;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import app.usecase_factory.AddBookUseCaseFactory;
import app.usecase_factory.LoginUseCaseFactory;
import app.usecase_factory.PurchaseBookCaseFactory;
import app.usecase_factory.RevenueUseCaseFactory;

import app.usecase_factory.rent.BorrowBookUseCaseFactory;
import app.usecase_factory.rent.RentMenuUseCaseFactory;
import app.usecase_factory.rent.ReturnBookUseCaseFactory;
import app.usecase_factory.rent.RobUseCaseFactory;
import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.calculate_revenue.RevenueViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.purchase_book.PurchaseViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import view.views.*;
import view.view_manager.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

//        Dotenv dotenv = Dotenv.load();
//        String mongoUri = dotenv.get("MONGO_URI");
//
//        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
//            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
//            MongoCollection<Document> collection = database.getCollection("comments");
//            Document doc = collection.find(eq("name", "Mercedes Tyler")).first();
//            if (doc != null) {
//                System.out.println(doc.toJson());
//            } else {
//                System.out.println("No matching documents found.");
//            }
//        }

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

        // ViewModels
        LoginViewModel loginViewModel = new LoginViewModel();
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        AddBookViewModel addBookViewModel = new AddBookViewModel();
        PurchaseViewModel purchaseViewModel = new PurchaseViewModel();
        RevenueViewModel revenueViewModel = new RevenueViewModel();

        RentMenuViewModel rentMenuViewModel = new RentMenuViewModel();
        ReturnOrBorrowViewModel returnOrBorrowViewModel = new ReturnOrBorrowViewModel();
        ReturnBookViewModel returnBookViewModel = new ReturnBookViewModel();
        BorrowBookViewModel borrowBookViewModel = new BorrowBookViewModel();

        // Views
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, mainMenuViewModel);
        MainMenuView mainMenuView = new MainMenuView(mainMenuViewModel, addBookViewModel, viewManagerModel, rentMenuViewModel, purchaseViewModel, revenueViewModel);

        SuccessfullyPurchaseTheBookView successfullyPurchaseTheBookView =
                PurchaseBookCaseFactory.createSuccessfully(viewManagerModel, purchaseViewModel, mainMenuViewModel);
        FailedToPurchaseView failedToPurchaseView =
                PurchaseBookCaseFactory.failedCreate(viewManagerModel, purchaseViewModel, mainMenuViewModel);

        AddBookView addBookView = AddBookUseCaseFactory.create(viewManagerModel, addBookViewModel, mainMenuViewModel);
        PurchaseView purchaseView = PurchaseBookCaseFactory.create(viewManagerModel, purchaseViewModel, mainMenuViewModel);
        RevenueView revenueView = RevenueUseCaseFactory.create(viewManagerModel, revenueViewModel, mainMenuViewModel);

        RentMenuView rentMenuView = RentMenuUseCaseFactory.create(viewManagerModel, rentMenuViewModel, mainMenuViewModel, returnOrBorrowViewModel);
        ReturnOrBorrowView returnOrBorrowView = RobUseCaseFactory.create(viewManagerModel, returnOrBorrowViewModel, rentMenuViewModel, returnBookViewModel, borrowBookViewModel, mainMenuViewModel);
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

        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}