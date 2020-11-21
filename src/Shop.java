import java.util.ArrayList;

public class Shop {


    private String nameOfShop;
    private String address;

    private static final int maxProduct = 15;
    private static final int minProduct = 5;

    private ArrayList<Product> products;
    private ArrayList<User> users;

    public Shop(String nameOfShop, String address) {

        this.nameOfShop = nameOfShop;
        this.address = address;
        this.products = new ArrayList<>();  //all products in the shop
        this.users = new ArrayList<>();     //all users in this shop
    }

    /**
     * Method to listProducts
     *
     * @param option
     * option 1= all product
     *      * option 2= product where stock is under minimum, also out of stock
     *      * option 3= out of stock
     */
    public void listProducts(int option) {
        int count = 0;
        switch (option) {
            case 1: {
                System.out.println("\nLIST OF ALL PRODUCTS");
                break;
            }
            case 2: {
                System.out.println("\nProduct stock is smaller than " + minProduct);
                break;
            }
            case 3: {
                System.out.println("\nProducts out of stock");
                break;
            }
        }
        System.out.println(this.nameOfShop + "  " + this.address);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Name of Product     in Stock       Price        Description");
        System.out.println("---------------------------------------------------------------------------------");
        for (Product item : this.products) {

            if (option == 1 || (option == 2 && item.getNumberOfProducts() <= minProduct) || (option == 3 && item.getNumberOfProducts() == 0)) {
                count++;
                System.out.println(Shop.formatMyString(20, item.getProductName()) +
                        "    " + Shop.formatMyString(5, String.valueOf(item.getNumberOfProducts())) + "     " +
                        Shop.formatMyDouble(10, item.getProductPrice()) + "      " +
                        item.getProductDescription());
            }
        }
        if (count == 0) {
            System.out.println("NO ITEMS FOUND!");
        }

    }


    /**
     * listProductCategory method creates list about products belonging given category
     *
     * @param prodcat list only the given category
     */
    public void listProductCategory(String prodcat) {
        int numberOfItems = 0;
        System.out.println("\nList of Products in Category:  " + prodcat);
        System.out.println("Product ID  Name of Product    Stock     Price    Category     Description");
        System.out.println("------------------------------------------------------------------------------");

        for (Product element : this.products) {
            if (prodcat.equals(element.getProdCat().name())) {
                numberOfItems++;
                System.out.println(formatMyString(10, String.valueOf(element.getProductId())) + "   "
                        + formatMyString(20, element.getProductName()) + "  "
                        + element.getNumberOfProducts() + "  " +
                        formatMyDouble(10, element.getProductPrice()) + "   " +
                        formatMyString(12, element.getProdCat().name()) +
                        "  " + element.getProductDescription());
            }
        }
        if (numberOfItems == 0) {
            System.out.println("There are no Products to list in category  " + prodcat + "!");
        }
    }

    /**
     * Method to list all users in the defined shop
     */
    public void userList() {
        System.out.println("\nList of all users in the shop");
        System.out.println("----------------------------------------------------");
        int count = 0;

        for (User item : this.users) {
            count++;
            System.out.println(formatMyString(15,item.getUserFirstName()) + "  "
                    +formatMyString(15,item.getUserLastname())+item.getUserEmail());

        }
        if (count == 0) {
            System.out.println("NO USERS FOUND!");
        }
    }

    /**
     * Method to increase the Stock of existing product
     * @param productId
     * for defined product
     * @param pieces
     * pieces to add to existing stock
     * @throws StockLimitReachedException
     *
     */
    public void increaseStock(int productId, int pieces) throws StockLimitReachedException {

        int oldStock;
        for (Product item : this.products) {
            if (item.getProductId() == productId) {
                oldStock = item.getNumberOfProducts();
                if (oldStock + pieces <= maxProduct) {
                    item.setNumberOfProducts((oldStock + pieces));
                    System.out.println("\nStock is changed: ");
                    System.out.println("Product : " + item.getProductId() + "  " + item.getProductName() + "  Old stock: " + oldStock + " new stock: " + item.getNumberOfProducts());
                } else {
                    System.out.println("\nI can not add " + pieces + " to Product ID: " + item.getProductId() + "  " + item.getProductName() +
                            "  stock: " + item.getNumberOfProducts() + "  you can try to add: " + (maxProduct - item.getNumberOfProducts()));
                    throw new StockLimitReachedException();
                }

            }

        }
    }

    /**
     * exception handling for increaseStock Method
     * @param productId
     * @param pieces
     */
    public void increaseStockNow(int productId, int pieces) {
        try {
            this.increaseStock(productId, pieces);
        } catch (StockLimitReachedException e) {
            System.out.println(e.getMessage());
        }
    }


    public void purchaseProduct(int userID, int productId, int pieces) throws NotEnoughStockException, MinimumStockAchieved {

        int oldStock = 0;
        for (User element: this.users) {
            if(element.getUserId()==userID){
                //System.out.println("\n"+element.getUserFirstName()+"  "+element.getUserLastname());
                element.listPurchaseHistory();
            }
        }

        for (Product item : this.products) {
            if (item.getProductId() == productId) {
                oldStock = item.getNumberOfProducts();
                if (oldStock - pieces >= 0) {
                    item.setNumberOfProducts((oldStock - pieces));
                    System.out.println("bought following product");
                    System.out.println("Product : " + item.getProductId() + "  " + item.getProductName() + "  Old stock: " + oldStock + " new stock: " + item.getNumberOfProducts());

                    for (User element: this.users) {
                        if(element.getUserId()==userID){
                            element.getPurchaseHistory().add(new Purchase(element.getUserId(),productId,pieces,item.getProductPrice(),item.getProductName()));
                            element.listPurchaseHistory();
                        }
                    }


                    if (oldStock - pieces <= minProduct) {
                        throw new MinimumStockAchieved();
                    }
                } else {
                    System.out.println("\nI can not purchase " + pieces + " from Product ID: " + item.getProductId() + "  " + item.getProductName() +
                            "  stock: " + item.getNumberOfProducts());
                    throw new NotEnoughStockException();
                }
            }
        }
    }

    /**
     * Exception handling for purchaseProduct Method
     * @param userId
     * @param productId
     * @param pieces
     */
    public void purchaseProductNow(int userId, int productId, int pieces) {

        try{
            this.purchaseProduct(userId, productId, pieces);
        }catch(
        MinimumStockAchieved e)
        {
            System.out.println(e.getMessage());
        }catch(NotEnoughStockException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public String getNameOfShop() {
        return nameOfShop;
    }

    public void setNameOfShop(String nameOfShop) {
        this.nameOfShop = nameOfShop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }



    /**
     * method formatMyString makes the string for given length for your lists
     * if the string is shorter than the length in the argument, than some empty char will be added
     * if it is shorter, the end of string will be cut away
     * @param length
     * @param myString
     * @return
     */
    public static String formatMyString(int length,String myString){
        String x="";
        for (int n=0;n<length;n++){
            x=x+" ";
        }
        String formattedString=myString+x; //field to help formatting name  20 char long in the list
        formattedString=formattedString.substring(0,length-1);

        return formattedString;
    }

    /**
     * formatMyDouble method makes the number right aligned and gives back a String for the list
     * in the given length, if the number is longer than the given length, a longer string will be
     * returned, because this method, do not gives back wrong values.
     *
     * @param length
     * @param number
     * @return
     */
    public static String formatMyDouble(int length,Double number){
        String x="";
        for (int n=0;n<length;n++){
            x=x+" ";
        }
        String niceDouble = String.valueOf(number); //field to format and right aline the given number

        if (niceDouble.length()<length) {
            int y=niceDouble.length()+length;
            niceDouble = (x+niceDouble).substring(y-length,y);  //right align the number
        }

        return niceDouble;
    }



}
