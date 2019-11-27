package pageobjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class BasketPageObject extends PageObject implements BasketPageObjectInterface {
    ArrayList<String> products = new ArrayList<>();
    public BasketPageObject(WebDriver browser) throws Exception {
        super(browser);
    }

    public BasketPageObject() throws Exception {
        super();
    }

    @Override
    public void navigateTo() throws Exception {

    }

    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public boolean isEmpty() {

        return browser.findElement(By.id("com.getir.getirtestingcasestudy:id/empty_textview")).getText().equalsIgnoreCase("Your card is empty!") ;


    }

    @Override
    public void goBack() {
        browser.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
    }

    @Override
    public boolean isListed(String[] productItems) {
        boolean flag=false;
        for(int i=0;i<products.size();i++){
            if(productItems[i].equalsIgnoreCase(products.get(i))){
                flag=true;
            }
            else{
                flag=false;
            }
        }
        return flag;
    }

    @Override
    public void chooseProducts(String product) {
        switch (product.toLowerCase()){
            case "camsil":
                getEvBakimi().click();
                WebDriverUtils.sleep(3000);
                getProduct(product).click();
                products.add(product);
                WebDriverUtils.sleep(1000);
                break;
            case "sabun":
                getKisiselBakim().click();
                WebDriverUtils.sleep(3000);
                getProduct(product).click();
                products.add(product);
                goBack();
                break;
            default:
                System.out.println("no match");
        }
    }

    public WebElement getProduct(String productItem){
        switch (productItem.toLowerCase()) {
            case "camsil":
                return browser.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[5]"));
            case "sabun":
                return browser.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        }
        return browser.findElement(null);
    }
    @Override
    public String[] getProductsFromBasket() {
        String[] productsInBasket={products.get(0),products.get(1)};
        return productsInBasket;
    }


    @Override
    public void deleteProductsFromBasket(String[] products) {
        browser.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.ImageView")).click();
        WebDriverUtils.sleep(1000);
        browser.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.ImageView")).click();
    }



    public String[] getChosenProducts(){
        String[] productItems=new String[products.size()];
        productItems[0]=products.get(0);
        productItems[1]=products.get(1);
        return  productItems;

   }


    public WebElement getKisiselBakim() {
        return browser.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]"));
    }

    public WebElement getEvBakimi(){
        return browser.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[5]"));
    }
}
