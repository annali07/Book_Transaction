package view.view_manager;

import interface_adapter.view.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/*
    A listener and controller for managing UI view changes.
    ViewManager (this class) switches displayed view in response to changes in ViewManagerModel.
    When the model indicates a new view should be displayed (by changing the "view" property), this class responds by updating the CardLayout to show the corresponding panel.
*/
public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        if (evt.getPropertyName().equals("view")) {
//            String viewModelName = (String) evt.getNewValue();
//            cardLayout.show(views, viewModelName);
//        }
//    }
    public void propertyChange(PropertyChangeEvent evt) {
        if ("view".equals(evt.getPropertyName())) {
            cardLayout.show(views, (String) evt.getNewValue());
        }
    }
}