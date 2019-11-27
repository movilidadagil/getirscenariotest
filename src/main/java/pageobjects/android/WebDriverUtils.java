package pageobjects.android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-26  */
public class WebDriverUtils {

    public static long DEFAULT_TIMEOUT = 10000L;
    private static WebDriver browser = null;

    public static TestRunContext context = TestRunContext.getInstance();

    protected static WebDriver launchAndroidApp(DesiredCapabilities caps) throws Exception {
        WebDriver driver = null;
        String appPath = context.getAndroidAppPath();
        File app = new File(appPath);

        Environments.AndroidDevice androidDevice = TestRunContext.getInstance().getAndroidDevice();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("deviceName", androidDevice.name);
            capabilities.setCapability("platformVersion", androidDevice.platformVersion);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException var7) {
            var7.printStackTrace();
        }

            driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
            return driver;

    }




    public static void waitForPresent(WebDriver browser, PageObject pageObject) throws Exception {
        long deadline = System.currentTimeMillis() + DEFAULT_TIMEOUT;
        if (browser == null) {
            browser = getBrowser();
        }

        while(!pageObject.isPresent() && System.currentTimeMillis() < deadline) {
            sleep(500L);
        }

        if (!pageObject.isPresent()) {
            String msg = "Violated expectation: Page not present: " + pageObject.getClass().getName();
            throw new Exception(msg);
        }

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception var3) {
        }

    }

    public static WebDriver getBrowser() throws Exception {

        TestRunContext.Browser whichBrowser = context.getBrowserType();
        DesiredCapabilities caps = new DesiredCapabilities();
            if (whichBrowser != TestRunContext.Browser.androidApp) {
                throw new RuntimeException("Unkown browser: " + whichBrowser.toString());
            }
            if(browser==null)
            browser = launchAndroidApp(caps);
            return browser;
    }
    public static void goBack() {
        browser.navigate().back();
    }
    public static void goForward() {
        browser.navigate().forward();
    }

}
