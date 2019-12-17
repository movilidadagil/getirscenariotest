package pageobjects.android.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.android.interfaces.ShoppingCartPageObjectInterface;
import pageobjects.android.utils.WebDriverUtils;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class ShoppingCartPageObject extends PageObject implements ShoppingCartPageObjectInterface {

    public ShoppingCartPageObject(WebDriver browser) throws Exception {
        super(browser);
    }

    public ShoppingCartPageObject() throws Exception {
        super();
    }

    @Override
    public void navigateTo() throws Exception {
        browser.findElement(By.id("com.getir.getirtestingcasestudy:id/basket")).click();
        WebDriverUtils.sleep(2000);
    }


    @Override
    public boolean isPresent() {
        return browser.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")).size()>0;
    }
}
