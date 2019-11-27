package pageobjects.android;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-26  */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestRunContext extends HashMap {
        protected Properties defaults;
        private Properties props = null;
    private static TestRunContext instance = null;
    public Map<String, Object> map = new HashMap();
    private final String propsFile = "testframework.properties";
    public final String pAppPathAndroid = "appPathAndroid";
    public List<String> testLog = new ArrayList();

    protected TestRunContext() {
        this.init();
    }

    public String getAndroidAppPath() {
        String result = System.getProperty("appPathAndroid");
        if (result == null || result.length() == 0) {
            result = this.props.getProperty("appPathAndroid", this.defaults.getProperty("appPathAndroid"));
        }

        this.props.put("appPathAndroid", result);
        return result;
    }

    public static TestRunContext getInstance() {
        if (instance == null) {
            instance = new TestRunContext();

            try {
                instance = (TestRunContext) Class.forName("pageobjects.android.CustomContext").newInstance();
            } catch (Exception var1) {
            }
        }
        return instance;
    }
    public void log(String text) {
        this.testLog.add(text);
    }

    public boolean init() {
        boolean result = true;
        this.props = new Properties();
        this.initDefaults();

        try {
            this.props.load(new FileReader("testframework.properties"));
        } catch (FileNotFoundException var3) {
        } catch (IOException var4) {
            var4.printStackTrace();
            result = false;
        }

        return result;
    }

    protected void initDefaults() {
        this.defaults = new Properties();
        this.defaults.setProperty("appPathAndroid", "/Applications/getir-testing-case-study.apk");
        this.defaults.setProperty("androidDevice", "Nexus_S_API_26");
        this.defaults.setProperty("appActivity","com.getir.getirtestingcasestudy.ui.login.LoginActivity");
    }

    public Environments.AndroidDevice getAndroidDevice() throws Exception {
        Environments.AndroidDevice device = EnvironmentFactory.getInstance().getAndroidDevice(this.props.getProperty("androidDevice"));
        if (device == null) {
            throw new Exception("Could not find an android device with corresponding id: " + this.props.getProperty("androidDevice"));
        } else {
            return device;
        }
    }

    public TestRunContext.Browser getBrowserType() {
        TestRunContext.Browser result = Browser.androidApp;
        String sBrowser = System.getProperty("browser");
        if (sBrowser == null || sBrowser.length() == 0) {
            sBrowser = this.props.getProperty("browser", this.defaults.getProperty("env"));
        }

        TestRunContext.Browser[] var3 = TestRunContext.Browser.values();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            TestRunContext.Browser browser = var3[var5];
            if (browser.toString().equalsIgnoreCase(sBrowser)) {
                result = browser;
                break;
            }
        }

        this.setBrowser(result);
        return result;
    }
    public void setBrowser(TestRunContext.Browser newBrowser) {
        this.props.setProperty("browser", newBrowser.toString());
    }

    public static enum Browser {
        chrome,
        chromeHeadless,
        firefox,
        iphoneBrowser,
        iphoneApp,
        ipadBrowser,
        androidApp,
        unknown;

        private Browser() {
        }
    }

}
