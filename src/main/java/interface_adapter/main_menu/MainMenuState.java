package interface_adapter.main_menu;

/**
 * The MainMenuState class represents the state of the main menu.
 * It includes the active button in the main menu.
 *
 */
public class MainMenuState {
    private String activeButton;

    /**
     * Constructs a new MainMenuState object by copying another MainMenuState object.
     *
     * @param copy the MainMenuState object to copy
     */
    public MainMenuState(MainMenuState copy) {
        this.activeButton = copy.activeButton;
    }

    /**
     * Constructs a new MainMenuState object with default values.
     */
    public MainMenuState() {}

    /**
     * Sets the active button in the main menu.
     *
     * @param activeButton the active button to set
     */
    public void setActiveButton(String activeButton) {
        this.activeButton = activeButton;
    }

}
