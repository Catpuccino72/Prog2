package game.objects;

/**
 * This enum provides the representaion of GameObjects.
 * 
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
public enum GameObject {
		/**the representation of the ground */
		GROUND,
		/**the representation of lava */
		LAVA,
		/**the representation of an airobstacle */
		AIROBSTACLE,
		/**the representation of an empty space */
		EMPTY,
		/**the representation of the goal */
		GOAL,
		/**the representation of the NPC */
		NPC;
		
		/**
		 * This method provides a function to return the corresponding symbol of an object.
		 * 
		 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
		 * @return the corresponding symbol of the object.
		 */
		public char getSymbol() {
		switch(this) {
			case GROUND:
				return 'G';
			case LAVA:
				return 'L';
			case AIROBSTACLE:
				return 'O';
			case EMPTY:
				return ' ';
			case GOAL:
				return 'Z';
		}
		return '#';
	}	
}
	
	