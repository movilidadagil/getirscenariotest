package pageobjects.android;

import org.openqa.selenium.WebDriver;
import pageobjects.android.pageobjects.PageObject;

import java.lang.reflect.Constructor;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class PageObjectFactory {
    public PageObjectFactory() {
    }

    public static PageObject byName(String poName) throws Exception {
        return byName(poName, (WebDriver)null);
    }

    public static PageObject byName(String poName, WebDriver customBrowser) throws Exception {
        String className = "pageobjects";
        TestRunContext.Browser browserType = TestRunContext.getInstance().getBrowserType();
        switch(browserType) {
            case iphoneApp:
                className = className + ".ios.";
                break;
            case androidApp:
                className = className + ".android.";
                break;
            default:
        }

        className = className + poName;
        Class poClass = Class.forName(className);
        Class[] types = new Class[]{WebDriver.class};
        Constructor constructor = null;

        try {
            constructor = poClass.getConstructor(types);
        } catch (Exception var9) {
        }

        if (constructor == null) {
            constructor = poClass.getSuperclass().getConstructor(types);
        }

        Object[] parameters = new Object[]{customBrowser};
        Object poInstance = constructor.newInstance(parameters);
        return (PageObject)poInstance;
    }
}
