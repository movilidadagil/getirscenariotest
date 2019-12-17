package performance;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitoringEventLog {
    public List<MonitoringEvent> events;
    FileWriter fileWriter;

    public MonitoringEventLog(){
        events = new ArrayList<MonitoringEvent>();
        try{
            //yyyy-MM-ddhh:mm:ss.SSS-Z"
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS-Z");
            String filename = "target/"+simpleDateFormat.format(new Date()+ " -performance.csv");
            fileWriter = new FileWriter(filename,true);
            fileWriter.write(MonitoringEvent.getCsvHeaderRow()+"\n");
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addEvent(MonitoringEvent event){
        event.timestamp = System.currentTimeMillis();
        persist(event);
    }

    public void addEvent(MonitoringEvent.EventType eventType,
                         String customerId,
                         String description,
                         long duration){
        addEvent(new MonitoringEvent(eventType,customerId,description,duration));
    }

    public void persist(MonitoringEvent event){
        try{

            fileWriter.write(event.toCsv()+"\n");
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
