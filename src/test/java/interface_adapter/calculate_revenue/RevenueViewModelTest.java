package interface_adapter.calculate_revenue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interface_adapter.calculate_revenue.RevenueState;
import interface_adapter.calculate_revenue.RevenueViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

public class RevenueViewModelTest {

    private RevenueViewModel viewModel;
    private RevenueState initialState;
    private boolean propertyChangeFired;

    @BeforeEach
    void setUp() {
        viewModel = new RevenueViewModel();
        initialState = new RevenueState("2023-07-01", "2023-07-31");
        propertyChangeFired = false;
    }

    @Test
    void testGetState() {
        viewModel.setState(initialState);
        assertEquals(initialState, viewModel.getState());
    }

    @Test
    void testSetState() {
        RevenueState newState = new RevenueState("2023-08-01", "2023-08-31");
        viewModel.setState(newState);
        assertEquals(newState, viewModel.getState());
    }

    @Test
    void testFirePropertyChanged() {
        PropertyChangeListener listener = evt -> propertyChangeFired = true;
        viewModel.addPropertyChangeListener(listener);

        viewModel.setState(initialState);
        viewModel.firePropertyChanged();

        assertTrue(propertyChangeFired);
    }

    @Test
    void testAddPropertyChangeListener() {
        PropertyChangeListener listener = evt -> propertyChangeFired = true;
        viewModel.addPropertyChangeListener(listener);

        viewModel.setState(initialState);
        viewModel.firePropertyChanged();

        assertTrue(propertyChangeFired);
    }
}

