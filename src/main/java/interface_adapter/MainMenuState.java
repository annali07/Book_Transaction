package interface_adapter;

public class MainMenuState {
    private String activeButton;

    public MainMenuState(MainMenuState copy) {
        this.activeButton = copy.activeButton;
    }
    public MainMenuState() {}

    public void setActiveButton(String activeButton) {
        this.activeButton = activeButton;
    }

}
