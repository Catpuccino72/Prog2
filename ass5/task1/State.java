package task1;

public interface State {
    public State transition(Action action);
    public String str();
    public String info();
}
