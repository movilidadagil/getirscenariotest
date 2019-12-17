package performance;

import akka.actor.ActorRef;
import pageobjects.android.Customer;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public abstract class AbstractCustomerModel extends Model{
    protected Customer customer;

    public AbstractCustomerModel(String name,
                                 Customer customer,
                                 ActorRef parentActor,
                                 ActorRef monitoringActor){
        super(name,parentActor,monitoringActor);
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }


}
