package pageobjects.android;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class CustomContext extends TestRunContext {
    private Customer currentCustomer = null;

    public void setCurrentCustomer(Customer customer) {
        currentCustomer = customer;
    }
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }
}
