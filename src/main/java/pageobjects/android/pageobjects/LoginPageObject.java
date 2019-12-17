package pageobjects.android.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.android.interfaces.LoginPageObjectInterface;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-26  */
public class LoginPageObject extends PageObject implements LoginPageObjectInterface {

    public LoginPageObject() throws Exception {
        super();
    }

    @Override
    public void navigateTo() throws Exception {

    }

    @Override
    public boolean isPresent() {
        return false;
    }



    public LoginPageObject(WebDriver browser) throws Exception {
        super(browser);
    }

    public void logout() throws Exception {


    }

    public boolean isLoggedOut() {


        return true;
    }

    @Override
    public void login(String email, String password, boolean valid) throws Exception {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();

    }

    private WebElement getPasswordField() {
        return browser.findElement(By.id("com.getir.getirtestingcasestudy:id/password"));
    }

    private WebElement getEmailField() {
        return browser.findElement(By.id("com.getir.getirtestingcasestudy:id/email"));
    }

    public WebElement getLoginButton() {
        return browser.findElement(By.id("com.getir.getirtestingcasestudy:id/email_sign_in_button"));
    }
}
