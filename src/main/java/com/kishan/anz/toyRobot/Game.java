package com.kishan.anz.toyRobot;

public class Game {

	private static final String SPACE = " ";
	private static final String COMMA = ",";

	private ITableTop squareTableTop;
	private ToyRobot robot;

	public Game(ITableTop squareBoard, ToyRobot robot) {
		this.squareTableTop = squareBoard;
		this.robot = robot;
	}

	public boolean moveRobotToy(Position position) throws Exception {

		if (squareTableTop == null)
			throw new Exception("Invalid table top");

		if (position == null)
			throw new Exception("Invalid position");

		if (position.getDirection() == null)
			throw new Exception("Invalid direction");

		if (!squareTableTop.isValidPosition(position))
			return false;

		robot.setPosition(position);

		return true;
	}

	public String eval(String inputString) throws Exception {
		String[] args = inputString.split(SPACE);

		RobotCommands command;
		try {
			command = RobotCommands.valueOf(args[0]);
		} catch (IllegalArgumentException e) {
			throw new Exception("Invalid command");
		}
		if (command == RobotCommands.PLACE && args.length < 2) {
			throw new Exception("Invalid command");
		}

		String[] params;
		int x = 0;
		int y = 0;
		FacingDirection direction = null;
		if (command == RobotCommands.PLACE) {
			params = args[1].split(COMMA);
			try {
				x = Integer.parseInt(params[0]);
				y = Integer.parseInt(params[1]);
				direction = FacingDirection.valueOf(params[2]);
			} catch (Exception e) {
				throw new Exception("Invalid command");
			}
		}

		String output;

		switch (command) {
		case PLACE:
			output = String.valueOf(moveRobotToy(new Position(x, y, direction)));
			break;
		case MOVE:
			Position movePosition = robot.getPosition().getNextPosition();
			if (!squareTableTop.isValidPosition(movePosition))
				output = String.valueOf(false);
			else
				output = String.valueOf(robot.move(movePosition));
			break;
		case LEFT:
			output = String.valueOf(robot.rotateLeft());
			break;
		case RIGHT:
			output = String.valueOf(robot.rotateRight());
			break;
		case REPORT:
			output = report();
			break;
		default:
			throw new Exception("Invalid command");
		}

		return output;
	}

	public String report() {
		if (robot.getPosition() == null)
			return null;

		return robot.getPosition().getX() + "," + robot.getPosition().getY() + ","
				+ robot.getPosition().getDirection().toString();
	}
}
