package com.kishan.anz.toyRobot;

public class SquareTableTop implements ITableTop {

	private int rows;
	private int columns;

	public SquareTableTop(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public boolean isValidPosition(Position position) {
		return !(position.getX() > this.columns || position.getX() < 0 || position.getY() > this.rows
				|| position.getY() < 0);
	}
}
