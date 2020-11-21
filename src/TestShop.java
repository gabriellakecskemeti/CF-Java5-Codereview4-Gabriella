/**
 * to test all functions in the shop, like purchase product or increase stock
 */
public class TestShop {
    public static void main(String[] args) {

        Shop s1= new Shop("City Flair","Vienna, Kärtner Str. 25");


        //Presentation of adding new Product to the Shop
        s1.getProducts().add(new Product("Nice T-shirt","T-shirt made from Bio material",11.00,10, Product.ProdCategory.TSHIRTS));
        s1.getProducts().add(new Product("Winter Jacket","Animal friendly Jacket",99.00,10, Product.ProdCategory.JACKETS));
        s1.getProducts().add(new Product("Happy Skirt","Skirt made from Bio material",39.00,10, Product.ProdCategory.SKIRTS));
        s1.getProducts().add(new Product("Hyperflex Jeans","Jeans made from recycled Pet bottles",119.00,2, Product.ProdCategory.TROUSERS));
        s1.getProducts().add(new Product("Night line dress","Woman dress made from Bio Material",129.00,0, Product.ProdCategory.DRESSES));


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

        s1.userList();  //Display all user

        s1.listProductCategory("TSHIRTS");  //display products from category TSHIRT
        s1.listProductCategory("SHIRTS");

        s1.listProducts(1);  // option 1 means: all Products
        s1.listProducts(3);  //option 3 means: stock=0
        s1.listProducts(2);   //option2 means: stock <5


        s1.purchaseProductNow(3,1,2);
        s1.purchaseProductNow(3,2,1);


        s1.increaseStockNow(3, 3);
        s1.increaseStockNow(3,5);

        s1.listProducts(1);  // option 1 means: all Products after purchasing and other stock changes

        u3.printReport("C:\\CF W4D3\\PurchaseHistory.txt");   //list the selected user purchase
                                                                // history into a file


    }


}
