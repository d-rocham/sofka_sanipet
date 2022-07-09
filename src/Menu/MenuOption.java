package Menu;

public abstract class MenuOption {
    int optionID;
    String optionDescription;

    public MenuOption(int optionID, String optionDescription) {
        this.optionID = optionID;
        this.optionDescription = optionDescription;
    }


}
