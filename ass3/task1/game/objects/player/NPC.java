package game.objects.player;
public class NPC {
	private boolean isCrouching = false;
	private int xCoordinate;
	
	public NPC() {
		this.isCrouching = false;
		this.xCoordinate = 0;
	}
	
	public void standUp() {
		this.isCrouching = false;
	}
	
	public void crouch() {
		this.isCrouching = true;
	}
	
	public void walkRight() {
		this.xCoordinate += 1;
	}
	
	public void dashRight() {
		if (!this.isCrouching) this.xCoordinate += 2;
	}
	
	public void setXCoordinate(int Coordinate) {
		this.xCoordinate = Coordinate;
	}
	
	public int getXCoordinate() {
		return this.xCoordinate;
	}
	
	public boolean isCrouching() {
		return this.isCrouching;
	}
}