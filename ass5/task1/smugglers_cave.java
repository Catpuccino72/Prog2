package task1;
public class smugglers_cave implements State{
    public State transition(Action action) {
        switch (action) {
            case A:
                return new pirates_island();
            case B:
                return new treasure_island();
            default:
                return new smugglers_cave();
        }
    }

    public String str() {
        return "Smugglers' Cave";
    }

    public String info(){
        return this.str() + " | action A -> " + this.transition(Action.A).str()
        + " action B -> " + this.transition(Action.B).str();
    }
}