package performance;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import pageobjects.android.Customer;
import pageobjects.android.utils.TestDataUtils;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public class CustomerActor  extends AbstractLoggingActor {

    Customer customerDetils = null;
    AbstractCustomerModel model = null;
    ActorRef supervisor = null;

    public static class Start{
        public final AbstractCustomerModel model;
        public Start(AbstractCustomerModel model){
            this.model = model;
        }

    }

    public static class DoSomething{

    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(Start.class, this::onStart)
                .match(DoSomething.class, this::onDoSomething)
                .build();
    }

    private void onStart(Start message){
        this.customerDetils = message.model.getCustomer();

    }

    private void onDoSomething(DoSomething message) {
        Model.ModelStatus stepResult = model.step();
        if (stepResult == Model.ModelStatus.OK) {
            log().info(model.getCurrentState().getName());
            sleepItOff();
        } else if (stepResult == Model.ModelStatus.TERMINAL_STATE) {
            log().info("I'm done (" + model.getCurrentState().getName() + ")");
            getContext().actorSelection("../").tell(new CustomersSupervisorActor.CustomerComplete(), getSelf());
            getContext().getSystem().stop(getSelf());
        } else {
            log().error("Fatal error... Killing actor.");
            getContext().getSystem().stop(getSelf());
        }
    }
    private void sleepItOff() {
        getContext().system().scheduler().scheduleOnce(Duration.create(TestDataUtils.randomInt(5, 10), TimeUnit.SECONDS),
                new Runnable() {
                    @Override
                    public void run() {
                        self().tell(new DoSomething(), self());
                    }
                }, getContext().system().dispatcher());
    }


    public static Props props() {
        return Props.create(CustomerActor.class);
    }
}
