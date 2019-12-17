package performance;

import pageobjects.android.Customer;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public abstract class AbstractCustomerTransition extends ModelTransition {

    protected AbstractCustomerModel model;
    protected Customer customer;

    public AbstractCustomerTransition(AbstractCustomerModel model, String name, ModelState fromState, ModelState toState) {
        super(model, name, fromState, toState);
        this.model = model;
        this.customer = model.getCustomer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
