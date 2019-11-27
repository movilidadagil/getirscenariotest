package pageobjects.android;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public interface BasketPageObjectInterface  extends PageObjectInterface{

    void chooseProducts(String product);
    String[] getChosenProducts();
    String[] getProductsFromBasket();
    void deleteProductsFromBasket(String[] products);
    public  boolean isListed(String[] products);
    public boolean isEmpty();
    void goBack();


}
