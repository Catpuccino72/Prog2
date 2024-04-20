package game.objects;
public enum GameObject {
		GROUND,
		LAVA,
		AIROBSTACLE,
		EMPTY,
		GOAL,
		NPC;
		
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
	
	