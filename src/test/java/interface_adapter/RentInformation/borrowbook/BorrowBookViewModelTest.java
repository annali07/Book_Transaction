package interface_adapter.RentInformation.borrowbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BorrowBookViewModelTest {

    private BorrowBookViewModel viewModel;
    private BorrowBookState state;

    @BeforeEach
    void setUp() {
        viewModel = new BorrowBookViewModel();
        state = new BorrowBookState();
    }

    @Test
    void testGetState() {
        viewModel.setState(state);
        assertEquals(state, viewModel.getState());
    }

    @Test
    void testSetState() {
        BorrowBookState newState = new BorrowBookState();
        newState.setBookID(123);
        viewModel.setState(newState);
        assertEquals(newState, viewModel.getState());
        assertEquals(123, viewModel.getState().getBookID());
    }

    @Test
    void testFirePropertyChanged() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);

        viewModel.firePropertyChanged();

        verify(listener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void testAddPropertyChangeListener() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);

        viewModel.firePropertyChanged();

        verify(listener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void testStatePropertyChangeEvent() {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("state", evt.getPropertyName());
                assertNull(evt.getOldValue());
                assertEquals(state, evt.getNewValue());
            }
        };

        viewModel.addPropertyChangeListener(listener);
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }
}
