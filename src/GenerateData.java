import java.util.Scanner;


/**
 * Class for different method calls, like generating test data or input Product category
 */
public class GenerateData {


    public GenerateData(){

    }

    public static Shop GenerateProductData() {
        Shop s1 = new Shop("City Flair", "Vienna, Kärtner Str. 25");


        //Presentation of adding new Product to the Shop
        s1.getProducts().add(new Product("Nice T-shirt", "T-shirt made from Bio material", 11.00, 10, Product.ProdCategory.TSHIRTS));
        s1.getProducts().add(new Product("Winter Jacket", "Animal friendly Jacket", 99.00, 10, Product.ProdCategory.JACKETS));
        s1.getProducts().add(new Product("Happy Skirt", "Skirt made from Bio material", 39.00, 10, Product.ProdCategory.SKIRTS));
        s1.getProducts().add(new Product("Hyperflex Jeans", "Jeans made from recycled Pet bottles", 119.00, 2, Product.ProdCategory.TROUSERS));
        s1.getProducts().add(new Product("Night line dress", "Woman dress made from Bio Material", 129.00, 0, Product.ProdCategory.DRESSES));

        User u1=new User("Angela","Wallisch","aw@gmail.at","Vienna Singer Str 5.","1010","00436648889991");
        User u2=new User("Peter","Malinek","pm@gmail.at","Vienna Lobau Str 8.","1220","00436648889977");
        User u3=new User("Theodora","Clever","tc@gmail.at","Vienna Lasalle Str 38.","1020","00436648889988");
        User u4=new User("Samuel","Grügek","sg@gmail.at","Vienna Sommer Str 19.","1190","00436648889666");
        User u5=new User("Katrin","Lang","kl@gmail.at","Vienna Wagramer Str 108.","1220","00436648889555");

        s1.getUsers().add(u1);
        s1.getUsers().add(u2);
        s1.getUsers().add(u3);
        s1.getUsers().add(u4);
        s1.getUsers().add(u5);

        return s1;
    }


    public static String inputCategory() {

        String choice = "";
        String again="Y";
        System.out.println("Possible product categories:");

        for (Product.ProdCategory myVar : Product.ProdCategory.values()) {
            System.out.println(myVar);
        }
        Scanner scanner = new Scanner(System.in);

        while (again.equalsIgnoreCase("Y")) {
            System.out.println("Enter choice: ");
            again="";
            choice = scanner.next();
            boolean foundCategory = false;
            for (Product.ProdCategory myVar : Product.ProdCategory.values()) {
                if (choice.toUpperCase().equals(myVar.name()) ) {
                    foundCategory = true;
                }
            }
            if (foundCategory) {
                return choice.toUpperCase();
            } else {
                while ( !again.equalsIgnoreCase("Y") && !again.equalsIgnoreCase("N")) {
                    System.out.println("Wrong Input, do you want to try again?  Enter Y/N");
                    again = scanner.next();

                }
                if (again.equalsIgnoreCase("N")) {
                    return "";
                }

            }
        }


        return choice.toUpperCase();
    }






}
