import java.util.Scanner;


public class UserInterface {

    public UserInterface(String init) {
        if (init == "default") {
            displayMainMenu();
        } else {
            System.out.println("I can not find the menu!");
        }
    }

    public void printHeader() {
        System.out.println(" ---------------------");
        System.out.println("|       WELCOME       |");
        System.out.println("|     to the Shop     |");
        System.out.println(" ---------------------");
    }

    public void printMenu() {
        System.out.println("Make a selection:");
        System.out.println("1.Display all products");
        System.out.println("2.Display all products of category X");
        System.out.println("3.Display all products where stock is under minimum");
        System.out.println("4.Display all products out of stock");
        System.out.println("5.List all customers");

        System.out.println("0.Exit");
    }

    public void printSubMenu() {
        System.out.println("Do you want to go back to the Main Menu?");
        System.out.println("1: Yes");
        System.out.println("2: No");

    }

    public void displayMainMenu() {
        printHeader();
        printMenu();
    }

    public void displaySubMenu() {
        printSubMenu();
    }


    public int getUserInput() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter choice: ");
        while (choice < 0 || choice > 5) {
            try {

                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Wrong input, can only be numeric.");

            }

            if (choice<0 || choice>5){
                System.out.println("Wrong input, try it again!");
                choice=-1;
            }
        }
        return choice;
    }


    public void performAction(int choice) {
        boolean exit = false;
        while (!exit) {
            switch (choice) {
                case 1: {
                        new GenerateData();
                        Shop aa=GenerateData.GenerateProductData();
                        aa.listProducts(1);


                    System.out.println("Thanks for running the Application!");
                    exit = true;
                    break;
                }
                case 2: {
                    String choosedCategory;
                    choosedCategory=GenerateData.inputCategory();
                    if (choosedCategory!="") {
                        new GenerateData();
                        Shop aa = GenerateData.GenerateProductData();
                        aa.listProductCategory(choosedCategory);
                    }
                    System.out.println("Thanks for running the Application!");
                    exit = true;
                    break;
                }
                case 3: {
                    new GenerateData();
                    Shop aa=GenerateData.GenerateProductData();
                    aa.listProducts(2);

                    System.out.println("Thanks for running the Application!");
                    exit = true;
                    break;
                }
                case 4: {
                    new GenerateData();
                    Shop aa=GenerateData.GenerateProductData();
                    aa.listProducts(3);

                    System.out.println("Thanks for running the Application!");
                    exit = true;
                    break;
                }
                case 5: {                                     //user list
                    new GenerateData();
                    Shop aa=GenerateData.GenerateProductData();
                    aa.userList();

                    System.out.println("Thanks for running the Application!");
                    exit = true;
                    break;
                }

                case 0: {
                    System.out.println("Thanks for running the Application!");
                    exit = true;
                    break;
                }

            }
        }
    }





}
