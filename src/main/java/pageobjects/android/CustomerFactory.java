package pageobjects.android;

import org.openqa.selenium.WebDriver;

import java.io.File;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class CustomerFactory {

    WebDriver browser = null;

    String customerDataLocation = "target" + File.separator + "test-classes"
            + File.separator + File.separator + "testdata"
            + File.separator + "/customers.json";

    public CustomerFactory() {
    }

    protected void quitBrowser() {
        browser.quit();
        browser = null;
    }


    public Customer consumeNewTestCustomer() throws Exception {
        return generateCustomerData();
    }
    public Customer generateCustomerData() throws Exception {
        Customer customer = new Customer();
        customer.email ="hello@getir.com" ;
        customer.password = "hello";


        return customer;
    }


}
