package Menu;

public class ExitOption extends MenuOption{
    public ExitOption(int optionID, String optionDescription) {
        super(optionID, optionDescription);
    }

    void exitApplication() {
        System.out.println("Goodbye!");
        return;
    }

}
