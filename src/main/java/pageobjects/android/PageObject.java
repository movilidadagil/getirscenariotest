package pageobjects.android;

import org.openqa.selenium.WebDriver;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-26  */
public abstract  class PageObject implements PageObjectInterface {

    protected WebDriver browser;
    protected TestRunContext context;

    public PageObject(WebDriver browser) throws Exception {
        this.context = TestRunContext.getInstance();
        if (browser == null) {
            this.browser = WebDriverUtils.getBrowser();
        } else {
            this.browser = browser;
        }
    }

    public void waitForPresent(WebDriver browser) {
        try {
            WebDriverUtils.waitForPresent(browser, this);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void waitForPresent() {
        this.waitForPresent(this.browser);
    }

    public PageObject() throws Exception {
        this((WebDriver)null);
    }

    public abstract void navigateTo() throws Exception;

    public abstract boolean isPresent();
}
