public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    public static enum ProdCategory {
        TSHIRTS,
        TROUSERS,
        SKIRTS,
        SHIRTS,
        DRESSES,
        JACKETS};

    ProdCategory prodCat;
    private int numberOfProducts;     //how much pieces  of this product can you find in the shop
    private static int lastID=0;

    public Product() {


    }

    public Product(String productName, String productDescription, Double productPrice, int numberOfProduct, ProdCategory prodCat) {
        lastID++;
        this.productId = lastID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.numberOfProducts = numberOfProduct;   //product in Stock
        this.prodCat = prodCat;
        System.out.println("New product was added, ID: "+this.productId+"  name: "+this.productName+"   Stock: "+this.numberOfProducts);
    }


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public ProdCategory getProdCat() {
        return prodCat;
    }

    public void setProdCat(ProdCategory prodCat) {
        this.prodCat = prodCat;
    }





}
