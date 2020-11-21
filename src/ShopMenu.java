/**
 * call the methods to display the main menu and get the choice of user
 * finally calls performAction to start the selected activity
 */
public class ShopMenu {
    public static void main(String[] args) {

        UserInterface menu = new UserInterface("default");
        int choice=0;
        choice=menu.getUserInput();
        menu.performAction(choice);
    }
}
