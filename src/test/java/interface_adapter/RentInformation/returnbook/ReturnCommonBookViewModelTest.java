package interface_adapter.RentInformation.returnbook;

import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReturnCommonBookViewModelTest {

    private ReturnBookViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = new ReturnBookViewModel();
    }

    @Test
    void testGetAndSetState() {
        ReturnBookState state = new ReturnBookState();
        state.setBookID(123);
        state.setBookName("Harry Potter");
        state.setStartDate(new Date());
        viewModel.setState(state);

        ReturnBookState retrievedState = viewModel.getState();
        assertEquals(123, retrievedState.getBookID());
        assertEquals("Harry Potter", retrievedState.getBookName());
        assertNotNull(retrievedState.getStartDate());
    }

    @Test
    void testFirePropertyChanged() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);

        viewModel.firePropertyChanged();

        verify(listener).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void testAddPropertyChangeListener() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);

        viewModel.firePropertyChanged();

        verify(listener).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void testPropertyChangeEventContent() {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                assertEquals("state", event.getPropertyName());
                assertNull(event.getOldValue());
                assertEquals(viewModel.getState(), event.getNewValue());
            }
        };
        viewModel.addPropertyChangeListener(listener);

        ReturnBookState newState = new ReturnBookState();
        newState.setBookID(789);
        viewModel.setState(newState);
        viewModel.firePropertyChanged();
    }
}
