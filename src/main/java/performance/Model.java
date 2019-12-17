package performance;

import akka.actor.Actor;
import akka.actor.ActorRef;
import pageobjects.android.utils.TestDataUtils;

import java.util.List;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public abstract  class Model {

    public enum ModelStatus{OK, ERROR, TERMINAL_STATE}
    ;
    protected int numTransitionsFollowed  = 0;
    protected String name;
    protected ModelState initialState = null;
    protected ModelState currentState = null;
    protected ActorRef parentActor;
    protected ActorRef monitoringActor;

    public Model(String name,
                 ActorRef parentActor,
                 ActorRef monitoringActor){
        this.name = name;
        this.parentActor = parentActor;
        this.monitoringActor = monitoringActor;
    }

    public String getName(){
        return name;
    }
    public ModelState getInitialState(){
        return initialState;
    }
    public ModelState getCurrentState(){
        return currentState;
    }
    public void addMonitoringEvent(MonitoringEvent event){
        monitoringActor.tell(new MonitorActor.LogEvent(event),parentActor);
    }

    public ModelStatus step(){
        ModelStatus result = ModelStatus.OK;
        numTransitionsFollowed++;

        if (currentState == null) {
            currentState = initialState;
        }

        if (currentState.isTerminal()) {
            return ModelStatus.TERMINAL_STATE;
        }
        List<ModelTransition> possibleTransitions = currentState.getOutboundTransitions();
        ModelTransition selectedTransition = possibleTransitions.get(TestDataUtils.randomInt(0, possibleTransitions.size() - 1));
        try {
            selectedTransition.setup();
        } catch (Exception e) {
            e.printStackTrace();
            return ModelStatus.ERROR;
        }
        selectedTransition.execute();
        try {
            selectedTransition.verifyState();
            currentState = selectedTransition.getToState();
            if (currentState.isTerminal()) {
                result = ModelStatus.TERMINAL_STATE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = ModelStatus.ERROR;
        } finally {
            return result;
        }
    }

    public abstract void init();

}
