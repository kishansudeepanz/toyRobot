package com.kishan.anz.toyRobot;

import java.util.HashMap;
import java.util.Map;

public enum FacingDirection {

	NORTH(0), EAST(1), SOUTH(2), WEST(3);
	private static Map<Integer, FacingDirection> map = new HashMap<Integer, FacingDirection>();

	static {
		for (FacingDirection facingDirection : FacingDirection.values()) {
			map.put(facingDirection.directionIndex, facingDirection);
		}
	}

	private int directionIndex;

	private FacingDirection(int Directions) {
		this.directionIndex = Directions;
	}

	public static FacingDirection valueOf(int directionIndex) {
		return map.get(directionIndex);
	}

	public FacingDirection leftDirection() {
		return moveInDirection(-1);
	}

	public FacingDirection rightDirection() {
		return moveInDirection(1);
	}

	private FacingDirection moveInDirection(int step) {
		int movedIndex = (this.directionIndex + step) < 0 ? map.size() - 1 : (this.directionIndex + step) % map.size();
		return FacingDirection.valueOf(movedIndex);
	}

}
