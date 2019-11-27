package pageobjects.android;

import com.google.gson.GsonBuilder;
import pageobjects.FileUtils;

import java.io.File;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-26  */
public class EnvironmentFactory {
    private static EnvironmentFactory instance = null;
    public static String defaultEnvId = "TestEnvironment";
    protected Environments.AndroidDevice[] androidDevices;
    String environmentsFileLocation;

    protected EnvironmentFactory() {
        this.environmentsFileLocation = "target" + File.separator + "classes" + File.separator + File.separator + "config" + File.separator + "/environments.json";
        this.initEnvironments();
    }
    public static EnvironmentFactory getInstance() {
        if (instance == null) {
            instance = new EnvironmentFactory();
        }

        return instance;
    }
    public void initEnvironments() {
        String envsString = null;

        try {
            envsString = FileUtils.readFileContentsAsString(this.environmentsFileLocation);
        } catch (Exception var7) {
            var7.printStackTrace();
            System.exit(1);
        }

        Environments envs = (Environments)(new GsonBuilder()).create().fromJson(envsString, Environments.class);

        this.androidDevices = envs.androidDevices;

    }

    public Environments.AndroidDevice getAndroidDevice(String id) {
        Environments.AndroidDevice result = null;

        for(int i = 0; i < this.androidDevices.length; ++i) {
            if (this.androidDevices[i].id.equals(id)) {
                result = this.androidDevices[i];
                break;
            }
        }

        return result;
    }

}
