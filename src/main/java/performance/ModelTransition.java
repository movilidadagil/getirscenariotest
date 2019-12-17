package performance;

import java.util.ArrayList;
import java.util.List;

/* Created by JavaUnifiedTester   hasanaligul  2019-12-17  */
public abstract class ModelTransition {

    protected String name;
    protected Model model;
    protected ModelState fromState;
    protected ModelState toState;

    public ModelTransition(Model model, String name, ModelState fromState, ModelState toState) {
        this.name = name;
        this.fromState = fromState;
        this.toState = toState;

        //Update the state of in and out states
        fromState.addOutboundTransition(this);
        toState.addInboundTransition(this);
    }

    public String getName() {
        return name;
    }

    public ModelState getFromState() {
        return fromState;
    }

    public ModelState getToState() {
        return toState;
    }

    public String toString() {
        return name;
    }

    public void setup() throws Exception {
    }

    public abstract void execute();

    public abstract void verifyState() throws Exception;

}
