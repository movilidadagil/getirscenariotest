package performance;

import akka.actor.ActorRef;
import pageobjects.android.Customer;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public class SimpleCustomerModel extends AbstractCustomerModel {

    protected int maximumTransitionsToFollow = 1000;

    public SimpleCustomerModel(Customer customer, ActorRef parentActor, ActorRef monitoringActor) {
        super("Simple Customer Model", customer, parentActor, monitoringActor);
    }

    public void init() {

        //Create states
        ModelState initialState = new ModelState(this, "Initial state", false);
        ModelState loginState = new ModelState(this, "logged in", false);

        //Create transitions
        new LoginTransition(this, initialState, loginState);

//        new WithdrawTransition(this, activeState, activeState);

        //Set initial state
        this.initialState = initialState;
    }

    @Override
    public ModelStatus step() {
        ModelStatus status = super.step();

        if (status == ModelStatus.OK && numTransitionsFollowed >= maximumTransitionsToFollow) {
            currentState = new ModelState(this, "Terminal State", true);
        }

        return status;
    }
}
