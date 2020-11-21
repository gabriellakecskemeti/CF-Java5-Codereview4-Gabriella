import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {

    private int userId;
    private String userFirstName;
    private String userLastname;
    private String userEmail;
    private String userAddress;
    private String userZip;
    private String userPhone;


    private static int numberForUser=0;  //user gets automatic ID number

    //array list for tracking of purchases of user
    private ArrayList<Purchase> purchaseHistory;


    public User(String userFirstName, String userLastname, String userEmail, String userAddress, String userZip, String userPhone) {
        numberForUser++;
        this.userId = numberForUser;
        this.userFirstName = userFirstName;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userZip = userZip;
        this.userPhone = userPhone;
        this.purchaseHistory = new ArrayList<>();
    }

    public void listPurchaseHistory(){
        System.out.println("\n"+this.getUserId()+"  "+this.getUserFirstName()+"  "+this.getUserLastname());
        System.out.println("Purchase History:");
        int count=0;
        for (Purchase item:this.purchaseHistory) {
            count++;
            System.out.println("Product ID: "+item.getProductId()+"  "+
                    Shop.formatMyString(15,item.getProductName())+"  pieces: "+item.getPieces()+
                    "   Price: "+Shop.formatMyDouble(10,item.getProductPrice())
                    +"   Datum: "+item.getDateOfPurchase());
        }
        if (count==0){
            System.out.println("NO ITEMS FOUND!");
        }

    }


    /**
     * BONUS
     * Print report about purchase history of specified user
     *
     */
    public boolean printReport(String nameOfFile) {
        int count=0;
        try {
            FileWriter file = new FileWriter(nameOfFile);

            file.write("\n" + this.getUserId() + "  " + this.getUserFirstName()+ "  " +
                    this.getUserLastname()+System.lineSeparator());
            file.write("Purchase History:"+System.lineSeparator());

            for (Purchase item : this.purchaseHistory) {
                count++;
                file.write("Product ID: " + item.getProductId() +" "+
                        Shop.formatMyString(15,item.getProductName())+ "  pieces: " + item.getPieces()
                        +"   Price: "+Shop.formatMyDouble(10,item.getProductPrice())+ "  Datum: " +
                        item.getDateOfPurchase()+System.lineSeparator());
            }
            if (count == 0) {
                file.write("NO ITEMS FOUND!"+System.lineSeparator());
            }
            file.close();
            System.out.println("\nSuccessfully wrote to file.");
            return true;
        } catch (IOException e) {
            System.err.println("An error occurred during writing into the file.");
            e.printStackTrace();
            return false;
        }

    }


        public int getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public static int getNumberForUser() {
        return numberForUser;
    }

    public static void setNumberForUser(int numberForUser) {
        User.numberForUser = numberForUser;
    }

    public ArrayList<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }


}
