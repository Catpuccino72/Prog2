package task1;
public class dead_mans_island implements State{
    public State transition(Action action) {
        switch (action) {
            case A:
                return new musket_hill();
            case B:
                return new shipwreck_bay();
        }
    }

    public String str() {
        return this.getName();
    }
}