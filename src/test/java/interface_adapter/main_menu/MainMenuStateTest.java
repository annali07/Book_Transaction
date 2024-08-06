package interface_adapter.main_menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuStateTest {

    private MainMenuState mainMenuState;

    @BeforeEach
    void setUp() {
        mainMenuState = new MainMenuState();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(mainMenuState);
        assertNull(mainMenuState.getActiveButton());
    }

    @Test
    void testCopyConstructor() {
        mainMenuState.setActiveButton("homeButton");
        MainMenuState copiedState = new MainMenuState(mainMenuState);

        assertEquals("homeButton", copiedState.getActiveButton());
    }

    @Test
    void testSetAndGetActiveButton() {
        mainMenuState.setActiveButton("settingsButton");
        assertEquals("settingsButton", mainMenuState.getActiveButton());
    }
}

