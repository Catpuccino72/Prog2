package task1;
public class shipwreck_bay implements State{
    public State transition(Action action) {
        switch (action) {
            case A:
                return new musket_hill();
            case B:
                return new dead_mans_island();
            default:
                return new shipwreck_bay();
        }
    }

    public String str() {
        return "Shipwreck Bay";
    }

    public String info(){
        return this.str() + " | action A -> " + this.transition(Action.A).str()
        + " action B -> " + this.transition(Action.B).str();
    }
}