package pageobjects.android.context;

import pageobjects.android.Customer;
import pageobjects.android.TestRunContext;
import pageobjects.android.context.CustomContext;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class CustomContextHelpers {
    public static void setCustomerInContext(Customer customer) {
        ((CustomContext) TestRunContext.getInstance()).setCurrentCustomer(customer);

    }

    public static Customer getCustomerFromContext() {
        return  ((CustomContext)TestRunContext.getInstance()).getCurrentCustomer();
    }
}
