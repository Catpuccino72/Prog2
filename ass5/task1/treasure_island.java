package task1;
public class treasure_island implements State{
    public State transition(Action action) {
        switch (action) {
            case A:
                return new treasure_island();
            case B:
                return new treasure_island();
            default:
                return new treasure_island();
        }
    }

    public String str() {
        return "Treasure Island";
    }

    public String info(){
        return this.str() + " | action A -> " + this.transition(Action.A).str()
        + " action B -> " + this.transition(Action.B).str();
    }
}