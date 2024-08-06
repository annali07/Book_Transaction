package interface_adapter.add_book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AddCommonBookViewModelTest {
    private AddBookViewModel addBookViewModel;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        addBookViewModel = new AddBookViewModel();
        listener = mock(PropertyChangeListener.class);
        addBookViewModel.addPropertyChangeListener(listener);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setState() {
        AddBookState state = new AddBookState();
        state.setISBN("1234567890");
        state.setPrice(29);

        addBookViewModel.setState(state);

        assertEquals(state, addBookViewModel.getState());
    }

    @Test
    void firePropertyChanged() {
        AddBookState state = new AddBookState();
        state.setISBN("1234567890");
        state.setPrice(29);
        addBookViewModel.setState(state);

        addBookViewModel.firePropertyChanged();

        verify(listener).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void addPropertyChangeListener() {
        PropertyChangeListener newListener = mock(PropertyChangeListener.class);

        addBookViewModel.addPropertyChangeListener(newListener);
        addBookViewModel.firePropertyChanged();

        verify(newListener).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void getState() {
        AddBookState state = new AddBookState();
        state.setISBN("1234567890");
        state.setPrice(29);

        addBookViewModel.setState(state);

        assertEquals(state, addBookViewModel.getState());
    }

}