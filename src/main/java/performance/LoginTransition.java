package performance;

import pageobjects.android.CustomerFactory;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public class LoginTransition extends AbstractCustomerTransition{

    public LoginTransition(AbstractCustomerModel model, ModelState fromState, ModelState toState){
        super(model,"Log in", fromState,toState);
    }
    @Override
    public void execute(){
        CustomerFactory customerFactory = new CustomerFactory();
        try{
            MonitoringEvent event = new MonitoringEvent(MonitoringEvent.EventType.Operation,
                    customer.getEmail(),"Customer Login");
            event.startTimer();
            customerFactory.loginCustomer(customer);
            model.addMonitoringEvent(event.stopTimer());

        }catch (Throwable t){
            t.printStackTrace();
        }
    }
    @Override
    public void verifyState() throws Exception {

    }
}
