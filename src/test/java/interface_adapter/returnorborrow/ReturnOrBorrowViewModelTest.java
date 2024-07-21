package interface_adapter.returnorborrow;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReturnOrBorrowViewModelTest {

    private ReturnOrBorrowViewModel viewModel;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        viewModel = new ReturnOrBorrowViewModel();
        listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);
    }

    @Test
    void testDefaultConstructor() {
        assertEquals("return or borrow", viewModel.getViewName());
        assertNotNull(viewModel.getState());
        assertEquals(0, viewModel.getState().getBookId());
    }

    @Test
    void testSetState() {
        ReturnOrBorrowState newState = new ReturnOrBorrowState();
        newState.setBookId(123);
        viewModel.setState(newState);

        assertEquals(123, viewModel.getState().getBookId());
    }

    @Test
    void testFirePropertyChanged() {
        viewModel.firePropertyChanged();

        verify(listener).propertyChange(any());
    }

    @Test
    void testAddPropertyChangeListener() {
        PropertyChangeListener newListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(newListener);

        viewModel.firePropertyChanged();

        verify(listener).propertyChange(any());
        verify(newListener).propertyChange(any());
    }
}
