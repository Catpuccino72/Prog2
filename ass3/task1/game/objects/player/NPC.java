package game.objects.player;

/**
 * This class provides the methods to control the NPC.
 * It also saves the current x-coordinate of it.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
public class NPC {
	/** saves whether the NPC is crouching */
	private boolean isCrouching = false;
	/** saves the current x-coordinate of the NPC*/
	private int xCoordinate;
	
	/**
	 * This method constructs a new NPC.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public NPC() {
		this.isCrouching = false;
		this.xCoordinate = 0;
	}
	
	/**
	 * This method makes the NPC stand up.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public void standUp() {
		this.isCrouching = false;
	}
	
	/**
	 * This method makes the NPC crouch.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public void crouch() {
		this.isCrouching = true;
	}
	
	/**
	 * This method makes the NPC move one unit to the right.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public void walkRight() {
		this.xCoordinate += 1;
	}
	
	/**
	 * This method makes the NPC move two units to the right.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public void dashRight() {
		if (!this.isCrouching) this.xCoordinate += 2;
	}
	
	/**
	 * This method sets the x-coordiante of the NPC.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 	 * @param Coordinate the new x-coordiante
	 */
	public void setXCoordinate(int Coordinate) {
		this.xCoordinate = Coordinate;
	}
	
	/**
	 * This method returns the x-coordiante of the NPC.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the current x-coordiante of the NPC.
	 */
	public int getXCoordinate() {
		return this.xCoordinate;
	}
	
	/**
	 * This method returns whether the NPC crouches.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return true if the NPC crouches, otherwise false.
	 */
	public boolean isCrouching() {
		return this.isCrouching;
	}
}