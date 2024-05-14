package task1;
/**
 * This enum provides the options for the user to choose a path.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 May 22
 */
public enum Action {
    /** path A */
    A,
    /** path B */
    B;

    /**
	 * This method returns the representation of a path.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     * @return the char representation
	 */
    public char str() {
        switch(this) {
            case A:
                return 'A';
            case B:
                return 'B';
            default:
                return 'X';
        }
    }
}