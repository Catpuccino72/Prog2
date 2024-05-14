package task1;
public class mutineers_island implements State{
    public State transition(Action action) {
        switch (action) {
            case A:
                return new smugglers_cave();
            case B:
                return new dead_mans_island();
            default:
                return new mutineers_island();
        }
    }

    public String str() {
        return "Multineers' Island";
    }

    public String info(){
        return this.str() + " | action A -> " + this.transition(Action.A).str()
        + " action B -> " + this.transition(Action.B).str();
    }
}