



public class MainMenu {

    public static void main(String[] args) {

        UserInterface menu = new UserInterface("default");
        int choice=0;
        choice=menu.getUserInput();
        menu.performAction(choice);
    }



}
