package interface_adapter.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Manages the active view in the application and notifies listeners of changes.
 */
public class ViewManagerModel {

    private String activeViewName;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String getActiveView() {
        return activeViewName;
    }
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    /**
     * Notifies listeners that the active view has changed.
     * This is typically called by the Login Presenter to alert the ViewModel and the View.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
        System.out.println("Current View: " + this.activeViewName);
    }

    /**
     * Adds a property change listener to the support.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}