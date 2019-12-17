package pageobjects.android.interfaces;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-26  */
public class Environments {

  public  Environments.AndroidDevice[] androidDevices;

    public Environments() {
    }

    public class AndroidDevice {
        public String id;
        public String name;
        public String platformVersion;

        public AndroidDevice() {
        }
    }
}
