package interface_adapter.main_menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuViewModelTest {

    private MainMenuViewModel mainMenuViewModel;

    @BeforeEach
    void setUp() {
        mainMenuViewModel = new MainMenuViewModel();
    }

    @Test
    void testInitialValues() {
        assertEquals("CommonBook Transaction Manager for CommonBook Store", mainMenuViewModel.TITLE_LABEL);
        assertEquals("Add CommonBook Entry", mainMenuViewModel.ADD_BOOK);
        assertEquals("Rent CommonBook Entry", mainMenuViewModel.ADD_RENT);
        assertEquals("Purchase CommonBook Entry", mainMenuViewModel.ADD_PURCHASE);
        assertEquals("Calculate Revenue", mainMenuViewModel.CALCULATE_REVENUE);
        assertEquals("main menu", mainMenuViewModel.getViewName());
        assertNotNull(mainMenuViewModel.getState());
    }

    @Test
    void testSetState() {
        MainMenuState newState = new MainMenuState();
        newState.setActiveButton("homeButton");
        mainMenuViewModel.setState(newState);
        assertEquals(newState, mainMenuViewModel.getState());
    }

    @Test
    void testFirePropertyChanged() {
        TestPropertyChangeListener listener = new TestPropertyChangeListener();
        mainMenuViewModel.addPropertyChangeListener(listener);

        MainMenuState newState = new MainMenuState();
        newState.setActiveButton("settingsButton");
        mainMenuViewModel.setState(newState);
        mainMenuViewModel.firePropertyChanged();

        assertTrue(listener.propertyChangeCalled);
        assertEquals("state", listener.event.getPropertyName());
        assertEquals(newState, listener.event.getNewValue());
    }

    private static class TestPropertyChangeListener implements PropertyChangeListener {
        boolean propertyChangeCalled = false;
        PropertyChangeEvent event;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            propertyChangeCalled = true;
            event = evt;
        }
    }
}
