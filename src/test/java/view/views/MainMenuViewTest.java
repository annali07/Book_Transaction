package view.views;

import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.add_book.AddBookViewModel;
import interface_adapter.calculate_revenue.RevenueViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.purchase_book.PurchaseViewModel;
import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuViewTest {

    private MainMenuView mainMenuView;
    private MainMenuViewModel mainMenuViewModel;
    private AddBookViewModel addBookViewModel;
    private ViewManagerModel viewManagerModel;
    private RentMenuViewModel rentMenuViewModel;
    private PurchaseViewModel purchaseViewModel;
    private RevenueViewModel revenueViewModel;

    @BeforeEach
    void setUp() {
        mainMenuViewModel = new MainMenuViewModel();
        addBookViewModel = new AddBookViewModel();
        viewManagerModel = new ViewManagerModel();
        rentMenuViewModel = new RentMenuViewModel();
        purchaseViewModel = new PurchaseViewModel();
        revenueViewModel = new RevenueViewModel();

        mainMenuView = new MainMenuView(mainMenuViewModel, addBookViewModel, viewManagerModel, rentMenuViewModel, purchaseViewModel, revenueViewModel);
    }

    @Test
    void testAddBookButtonAction() {
        ActionEvent event = new ActionEvent(mainMenuViewModel.ADD_BOOK, ActionEvent.ACTION_PERFORMED, mainMenuViewModel.ADD_BOOK);
        mainMenuView.actionPerformed(event);

        assertEquals(addBookViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    void testAddRentButtonAction() {
        ActionEvent event = new ActionEvent(mainMenuViewModel.ADD_RENT, ActionEvent.ACTION_PERFORMED, mainMenuViewModel.ADD_RENT);
        mainMenuView.actionPerformed(event);

        assertEquals(rentMenuViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    void testAddPurchaseButtonAction() {
        ActionEvent event = new ActionEvent(mainMenuViewModel.ADD_PURCHASE, ActionEvent.ACTION_PERFORMED, mainMenuViewModel.ADD_PURCHASE);
        mainMenuView.actionPerformed(event);

        assertEquals(purchaseViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    void testCalculateRevenueButtonAction() {
        ActionEvent event = new ActionEvent(mainMenuViewModel.CALCULATE_REVENUE, ActionEvent.ACTION_PERFORMED, mainMenuViewModel.CALCULATE_REVENUE);
        mainMenuView.actionPerformed(event);

        assertEquals(revenueViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    void testPropertyChange() {
        // Simulate a property change event
        PropertyChangeEvent event = new PropertyChangeEvent(mainMenuViewModel, "someProperty", null, "newValue");
        mainMenuView.propertyChange(event);

        // Implement assertions based on what should happen during a property change
    }
}
