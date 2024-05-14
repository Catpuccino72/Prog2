package task1;
/**
 * This class implements the musket hill.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 May 22
 */
public class musket_hill implements State{
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
                return new pirates_island();
            case B:
                return new mutineers_island();
            default:
                return new musket_hill();
        }
    }
    /**
	 * This method returns the string representation of the island.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the string representation of the island.
	 */
    public String str() {
        return "Musket Hill";
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