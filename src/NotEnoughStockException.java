public class NotEnoughStockException extends Exception {

    public NotEnoughStockException(){
        super("There is not enough stock to purchase!");
    }

}
