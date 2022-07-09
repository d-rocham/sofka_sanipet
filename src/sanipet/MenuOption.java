package sanipet;

public abstract class MenuOption {
    int optionID;
    String optionDescription;

    //TODO: check return value

    public MenuOption(int optionID, String optionDescription) {
        this.optionID = optionID;
        this.optionDescription = optionDescription;
    }


}
