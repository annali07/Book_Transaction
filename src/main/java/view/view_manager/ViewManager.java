package view.view_manager;

import interface_adapter.view.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A listener and controller for managing UI view changes.
 * The ViewManager class switches the displayed view in response to changes in the ViewManagerModel.
 * When the model indicates a new view should be displayed (by changing the "view" property),
 * this class responds by updating the CardLayout to show the corresponding panel.
 */
public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;

    /**
     * Constructs a ViewManager with the specified views, card layout, and view manager model.
     *
     * @param views the JPanel containing the card layout with different views
     * @param cardLayout the CardLayout used to manage the views
     * @param viewManagerModel the model that holds the view state and notifies listeners of changes
     */
    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        viewManagerModel.addPropertyChangeListener(this);
    }

    /**
     * Responds to property change events from the ViewManagerModel.
     * If the "view" property changes, the CardLayout is updated to show the new view.
     *
     * @param evt the event that describes the property change
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("view".equals(evt.getPropertyName())) {
            cardLayout.show(views, (String) evt.getNewValue());
        }
    }
}
