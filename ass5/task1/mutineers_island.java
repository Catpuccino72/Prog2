package task1;
/**
 * This class implements the mutineers island.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 May 22
 */
public class mutineers_island implements State{
    /**
	 * This implements the transition to the connected island.
	 * It returns the corresponding state.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param action the path to take.
	 * @return the next state.
	 */
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
    /**
	 * This method returns the string representation of the island.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the string representation of the island.
	 */
    public String str() {
        return "Multineers' Island";
    }
    /**
	 * This method returns the string representation of the island and the options the from which to choose.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the string representation of the island nad the options.
	 */
    public String info(){
        return this.str() + " | action A -> " + this.transition(Action.A).str()
        + " action B -> " + this.transition(Action.B).str();
    }
}