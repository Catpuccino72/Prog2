package task1;
public class pirates_island implements State{
    public State transition(Action action) {
        switch (action) {
            case A:
                return new shipwreck_bay();
            case B:
                return new musket_hill();
            default:
                return new pirates_island();
        }
    }

    public String str() {
        return "Pirates' Island";
    }

    public String info(){
        return this.str() + " | action A -> " + this.transition(Action.A).str()
        + " action B -> " + this.transition(Action.B).str();
    }
}