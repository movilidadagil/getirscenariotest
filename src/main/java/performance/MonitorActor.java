package performance;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public class MonitorActor extends AbstractLoggingActor {


    public static class LogEvent{
        MonitoringEvent event;
        public LogEvent(MonitoringEvent event){
            this.event = event;
        }

    }

    public static class ShutDown{

    }

    protected MonitoringEventLog eventLog;
    public MonitorActor(){
        eventLog = new MonitoringEventLog();
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(LogEvent.class, this::onLogEvent)
                .match(ShutDown.class,this::onShutdown)
                .build();
    }

    private void onLogEvent(LogEvent message){
        eventLog.addEvent(message.event);
    }
    private void onShutdown(ShutDown message){
        log().info("Time expired - shutting down");
        getContext().getSystem().terminate();
    }

    public static Props props(){
        return Props.create(MonitorActor.class);
    }
}
