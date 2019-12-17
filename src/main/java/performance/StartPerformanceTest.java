package performance;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import scala.concurrent.duration.FiniteDuration;

import java.util.concurrent.TimeUnit;

public class StartPerformanceTest {

    public static void main(String[] args){
        int numCustomers = Integer.parseInt(args[0]);
        int rampupTime = Integer.parseInt(args[1]);
        int duration = Integer.parseInt(args[2]);

        System.out.println("Test Parameters");
        System.out.println("Max Customers: " + numCustomers);
        System.out.println("Rampup Time: " + rampupTime + " minutes");
        System.out.println("Duration: " + duration + " minutes");
        ActorSystem system = ActorSystem.create("getir-scenario-performance-test");
        final ActorRef monitoringActor = system.actorOf(MonitorActor.props(), "monitor");
        final ActorRef customerSupervisor = system.actorOf(CustomersSupervisorActor.props(),"customers");
        system.scheduler().scheduleOnce(FiniteDuration.create(duration, TimeUnit.MINUTES),
                monitoringActor, new MonitorActor.ShutDown(), system.dispatcher(), null);
    }
}
