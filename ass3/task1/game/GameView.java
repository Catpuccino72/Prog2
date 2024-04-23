package game;
import game.objects.*;
import game.objects.player.*;

/**
 * This class provides the methods to output the current state of the game
 * This class also implements the rules of the game
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
public class GameView {
	/** saves the gamefield */
	private GameObject gamefield[][];
	/** represents the NPC playing the game */
	private NPC npc;
	
	/**
	 * This method creates an initial game state.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public GameView() {
		this.gamefield = new GameObject [20][3];
		this.gamefield[0][0] = GameObject.NPC;
		this.gamefield[0][1] = GameObject.NPC;
		this.gamefield[0][2] = GameObject.GROUND;
		this.gamefield[1][0] = GameObject.EMPTY;
		this.gamefield[1][1] = GameObject.EMPTY;
		this.gamefield[1][2] = GameObject.GROUND;
		this.npc = new NPC();
		
		for (int x_coord = 0; x_coord < 20; x_coord++){
			this.gamefield[x_coord][0] = GameObject.EMPTY;
			this.gamefield[x_coord][1] = GameObject.EMPTY;
			this.gamefield[x_coord][2] = GameObject.GROUND;
			if (x_coord == 19) this.gamefield[x_coord][2] = GameObject.GOAL;
			if ((x_coord != 0) && (x_coord % 4 == 0)) this.gamefield[x_coord][2] = GameObject.LAVA;
		}
		for (int x_coord = 2; x_coord < 20; x_coord+=4){
			this.gamefield[x_coord][0] = GameObject.AIROBSTACLE;
		}
	}
	
	/**
	 * This method returns a String representation of the current game state.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the game state as a String
	 */
	public String str() {
		String str = "";
		for (int y_coord = 0; y_coord < 3; y_coord++) {
			for (int x_coord = 0; x_coord < 20; x_coord++) {
				if (y_coord < 2 && this.npc.getXCoordinate() == x_coord) {
					if (y_coord == 0) {
						if (!this.npc.isCrouching()) str += 'P';
						else str += this.gamefield[x_coord][y_coord].getSymbol();
					}
					if (y_coord == 1) str += 'P';
				} else {
					str += this.gamefield[x_coord][y_coord].getSymbol();
				}
				
			}
			str += '\n';
		}
		return str;
	}
	
	/**
	 * By calling this method a game is played from the beginning following the defined rules until the game ends.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public void play() {
		while(true) {
			System.out.println(this.str());
			if ((this.gamefield[this.npc.getXCoordinate()][2] == GameObject.LAVA) || (this.gamefield[this.npc.getXCoordinate()][2] == GameObject.GOAL)) break;
			
			else if ((this.gamefield[this.npc.getXCoordinate() + 1][0] == GameObject.AIROBSTACLE) && !this.npc.isCrouching()) this.npc.crouch();
			else if (this.gamefield[this.npc.getXCoordinate() + 1][2] == GameObject.LAVA && !this.npc.isCrouching()) this.npc.dashRight();
			else if (this.gamefield[this.npc.getXCoordinate() + 1][2] == GameObject.LAVA && this.npc.isCrouching()) this.npc.standUp();
			else this.npc.walkRight();
		}
	}

	/**
	 * This method plays 1 game until the end if called.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public static void main (String[] args) {
		GameView gv = new GameView();
		gv.play();
	}
}

/*
Die GameView.java liegt in dem übergeordneten package "game", da es die zentrale Datei ist, die die anderen Packages importiert.
Da der NPC in etwa das selbe Thema eines Objekts behandelt, befindet sich dieser im subpackage von "objects" 
und das package "objects" ist wiederum ein subpackage von "game"
*/