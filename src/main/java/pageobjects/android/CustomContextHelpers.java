package pageobjects.android;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class CustomContextHelpers {
    public static void setCustomerInContext(Customer customer) {
        ((CustomContext) TestRunContext.getInstance()).setCurrentCustomer(customer);

    }

    public static Customer getCustomerFromContext() {
        return  ((CustomContext)TestRunContext.getInstance()).getCurrentCustomer();
    }
}
