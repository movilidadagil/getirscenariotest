package pageobjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class CategoriesPageObject extends PageObject implements CategoriesPageObjectInterface{
    public CategoriesPageObject(WebDriver browser) throws Exception {
        super(browser);
    }

    public CategoriesPageObject() throws Exception {
        super();
    }

    @Override
    public void navigateTo() throws Exception {

    }

    @Override
    public boolean isPresent() {
            return browser.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")).size() > 0;
    }
}
