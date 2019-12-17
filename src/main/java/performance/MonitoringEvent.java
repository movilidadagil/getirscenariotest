package performance;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public class MonitoringEvent {
    public enum EventType{Operation, Error}
    ;
    public long timestamp;
    public EventType eventType;
    public String customerId;
    public String description;
    public long duration;

    protected long startTimestamp;
    public MonitoringEvent(MonitoringEvent.EventType eventType,
                           String customerId,
                           String description,
                           long duration){
        this.eventType= eventType;
        this.customerId=customerId;
        this.description=description;
        this.duration = duration;
    }

    public MonitoringEvent(MonitoringEvent.EventType eventType,
                           String customerId,
                           String description){
        this(eventType,customerId,description,0);
    }

    public static String getCsvHeaderRow( ){
        return "timestamp,event,type,customer,id,description,duration";
    }
    public String toCsv(){
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp);
        sb.append(',');
        sb.append(eventType);
        sb.append(',');
        sb.append(customerId);
        sb.append(',');
        sb.append(description);
        sb.append(',');
        sb.append(duration);

        return sb.toString();
    }
    public void startTimer(){
        startTimestamp = System.currentTimeMillis();
    }

    public MonitoringEvent stopTimer(){
        duration = duration + System.currentTimeMillis()- startTimestamp;
        return this;
    }

}
