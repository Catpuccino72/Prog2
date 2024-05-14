package task1;
/**
 * This interface is the basis for all of the island classes.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 May 22
 */
public interface State {
    public State transition(Action action);
    public String str();
    public String info();
}
