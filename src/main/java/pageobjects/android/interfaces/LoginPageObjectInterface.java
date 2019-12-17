package pageobjects.android.interfaces;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-26  */
public interface LoginPageObjectInterface extends PageObjectInterface {
    void login(String email, String password, boolean valid) throws Exception;

}
