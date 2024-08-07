package view.view_manager;

import interface_adapter.view.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.*;

public class ViewManagerTest {

    private ViewManager viewManager;
    private JPanel views;
    private CardLayout cardLayout;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    void setUp() {
        cardLayout = new CardLayout();
        views = new JPanel(cardLayout);
        viewManagerModel = new ViewManagerModel();

        // Add some sample views to the CardLayout
        views.add(new JLabel("View 1"), "View1");
        views.add(new JLabel("View 2"), "View2");
        views.add(new JLabel("View 3"), "View3");

        viewManager = new ViewManager(views, cardLayout, viewManagerModel);
    }

    @Test
    void testPropertyChange() {
        // Initial state: no view is shown
        cardLayout.show(views, "View1");
        Component initialView = getVisibleComponent();
        assertTrue(initialView instanceof JLabel);
        assertEquals("View 1", ((JLabel) initialView).getText());

        // Change the view to "View2"
        PropertyChangeEvent evt = new PropertyChangeEvent(viewManagerModel, "view", null, "View2");
        viewManager.propertyChange(evt);

        // Verify that the CardLayout shows "View2"
        Component currentView = getVisibleComponent();
        assertTrue(currentView instanceof JLabel);
        assertEquals("View 2", ((JLabel) currentView).getText());
    }

    private Component getVisibleComponent() {
        for (Component comp : views.getComponents()) {
            if (comp.isVisible()) {
                return comp;
            }
        }
        return null;
    }
}
