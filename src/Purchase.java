import java.time.LocalDateTime;

public class Purchase {

    private int userId;
    private int productId;
    private String productName;
    private int pieces;
    private Double productPrice;
    LocalDateTime dateOfPurchase;


    public Purchase(int userId, int productId, int pieces,Double price,String productName) {
        this.userId = userId;
        this.productId = productId;
        this.productName=productName;
        this.pieces = pieces;
        this.productPrice=price;
        this.dateOfPurchase = LocalDateTime.now();
    }

    public int getUserId() {
        return userId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
