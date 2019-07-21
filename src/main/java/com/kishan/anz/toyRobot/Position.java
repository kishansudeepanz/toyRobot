package com.kishan.anz.toyRobot;

public class Position {
	private int x;
	private int y;
	FacingDirection direction;

	public Position(Position position) {
		this.x = position.getX();
		this.y = position.getY();
		this.direction = position.getDirection();
	}

	public Position(int x, int y, FacingDirection direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public FacingDirection getDirection() {
		return this.direction;
	}

	public void setDirection(FacingDirection direction) {
		this.direction = direction;
	}

	public void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}

	public Position getNextPosition() throws Exception {
		if (this.direction == null)
			throw new Exception("Invalid robot direction");

		Position movePosition = new Position(this);
		switch (this.direction) {
		case NORTH:
			movePosition.move(0, 1);
			break;
		case EAST:
			movePosition.move(1, 0);
			break;
		case SOUTH:
			movePosition.move(0, -1);
			break;
		case WEST:
			movePosition.move(-1, 0);
			break;
		}
		return movePosition;
	}
}
