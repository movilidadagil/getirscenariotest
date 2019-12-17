package pageobjects.android.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageobjects.android.*;
import pageobjects.android.interfaces.ShoppingCartPageObjectInterface;
import pageobjects.android.pageobjects.BasketPageObjectInterface;

import static org.junit.Assert.assertTrue;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class BasketSteps {
    BasketPageObjectInterface basketPage;
    ShoppingCartPageObjectInterface shoppingPage;
    public BasketSteps() throws Exception {
        basketPage = (BasketPageObjectInterface) PageObjectFactory.byName("BasketPageObject");
        shoppingPage=(ShoppingCartPageObjectInterface) PageObjectFactory.byName("ShoppingCartPageObject");
    }





    @And("^I add a product related with KisiselBakim$")
    public void I_add_a_product_related_with_KisiselBakim() throws Throwable {
        basketPage.chooseProducts("Sabun");
    }

    @And("^I add a product related with EvBakim$")
    public void I_add_a_product_related_with_EvBakim() throws Throwable {
            basketPage.chooseProducts("Camsil");
            String[] products={"Sabun","Camsil"};
            basketPage.getProductsFromBasket();

    }
    @Then("^Those products should be seen in basket$")
    public void Those_products_should_be_seen_in_basket() throws Throwable {
        shoppingPage.navigateTo();
        assertTrue(shoppingPage.isPresent());
        assertTrue(basketPage.isListed(basketPage.getChosenProducts()));

    }
    @And("^I delete the products in basket$")
    public void I_delete_the_products_in_basket() throws Throwable {
        String[] prodcucts={"Sabun","Camsil"};
        basketPage.deleteProductsFromBasket(prodcucts);

    }
    @Then("^Those products should not be seen in basket$")
    public void Those_products_should_not_be_seen_in_basket() throws Throwable {
        assertTrue(basketPage.isEmpty());

    }

}
