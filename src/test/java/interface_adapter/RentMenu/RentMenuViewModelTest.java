package interface_adapter.RentMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RentMenuViewModelTest {

    private RentMenuViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new RentMenuViewModel();
        mockListener = mock(PropertyChangeListener.class);
    }

    @Test
    void testDefaultConstructor() {
        assertEquals("rent book menu", viewModel.getViewName());
        assertNotNull(viewModel.getState());
    }

    @Test
    void testSetState() {
        RentMenuState newState = new RentMenuState();
        newState.setBookID(123);
        newState.setBookIDError(1);

        viewModel.setState(newState);
        assertEquals(123, viewModel.getState().getBookID());
        assertEquals(1, viewModel.getState().getBookIDError());
    }

    @Test
    void testFirePropertyChanged() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void testAddPropertyChangeListener() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void testGetState() {
        RentMenuState state = viewModel.getState();
        assertNotNull(state);
        assertEquals(0, state.getBookID());
        assertEquals(0, state.getBookIDError());
    }
}
