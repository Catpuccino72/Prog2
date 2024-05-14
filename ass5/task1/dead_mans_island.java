package task1;
public class dead_mans_island implements State{
    public State transition(Action action) {
        switch (action) {
            case A:
                return new musket_hill();
            case B:
                return new shipwreck_bay();
            default:
                return new dead_mans_island();
        }
    }

    public String str() {
        return "Dead Man's Island";
    }

    public String info(){
        return this.str() + " | action A -> " + this.transition(Action.A).str()
        + " action B -> " + this.transition(Action.B).str();
    }
}