package task1;
public class musket_hill implements State{
    public State transition(Action action) {
        switch (action) {
            case A:
                return new pirates_island();
            case B:
                return new mutineers_island();
            default:
                return new musket_hill();
        }
    }

    public String str() {
        return "Musket Hill";
    }

    public String info(){
        return this.str() + " | action A -> " + this.transition(Action.A).str()
        + " action B -> " + this.transition(Action.B).str();
    }
}