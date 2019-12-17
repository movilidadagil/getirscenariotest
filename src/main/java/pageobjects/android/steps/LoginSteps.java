package pageobjects.android.steps;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.android.*;
import pageobjects.android.context.CustomContextHelpers;
import pageobjects.android.interfaces.LoginPageObjectInterface;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    LoginPageObjectInterface loginPage;
    public LoginSteps() throws Exception {
        loginPage = (LoginPageObjectInterface) PageObjectFactory.byName("LoginPageObject");
    }

    @Given("^I am a user of Getir$")
    public void I_am_a_user_of_Getir() throws Throwable {
        CustomerFactory customerFactory = new CustomerFactory();
        Customer customer= customerFactory.consumeNewTestCustomer();
        CustomContextHelpers.setCustomerInContext(customerFactory.consumeNewTestCustomer());
        TestRunContext.getInstance().log("Customer being used: " + CustomContextHelpers.getCustomerFromContext().email);
    }
    @When("^I log in using valid credentials$")
    public void I_log_in_using_valid_credentials() throws Throwable {
        Customer customer = CustomContextHelpers.getCustomerFromContext();
        String email = customer.email;
        String password = customer.password;
        loginPage.login(email, password, true);
    }


    @Then("^I should be logged in$")
    public void I_should_be_logged_in() throws Throwable {
        assertTrue(PageObjectFactory.byName("CategoriesPageObject").isPresent());

    }


    @Given("^I am a logged in user of Getir$")
    public void iAmALoggedInUserOfGetir() throws Throwable {
      I_am_a_user_of_Getir();
      I_log_in_using_valid_credentials();

    }
}
