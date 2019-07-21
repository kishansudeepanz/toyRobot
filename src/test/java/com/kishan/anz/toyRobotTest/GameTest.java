package com.kishan.anz.toyRobotTest;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.kishan.anz.toyRobot.FacingDirection;
import com.kishan.anz.toyRobot.Game;
import com.kishan.anz.toyRobot.Position;
import com.kishan.anz.toyRobot.SquareTableTop;
import com.kishan.anz.toyRobot.ToyRobot;

public class GameTest {

	private final int rows = 5;
	private final int columns = 5;

	@Rule
	public org.junit.rules.ExpectedException thrown = ExpectedException.none();

	@Test
	public void testPlacing() throws Exception {

		SquareTableTop board = new SquareTableTop(columns, rows);
		ToyRobot toyRobot = new ToyRobot();
		Game game = new Game(board, toyRobot);

		Assert.assertTrue(game.moveRobotToy(new Position(0, 1, FacingDirection.NORTH)));
		Assert.assertTrue(game.moveRobotToy(new Position(2, 2, FacingDirection.SOUTH)));
		Assert.assertFalse(game.moveRobotToy(new Position(6, 6, FacingDirection.WEST)));
		Assert.assertFalse(game.moveRobotToy(new Position(-1, 5, FacingDirection.EAST)));
	}

	@Test
	public void testPlacingExceptions() throws Exception {

		SquareTableTop board = new SquareTableTop(columns, rows);
		ToyRobot toyRobot = new ToyRobot();
		Game game = new Game(board, toyRobot);

		thrown.expect(Exception.class);
		game.moveRobotToy(null);
		thrown.expect(Exception.class);
		game.moveRobotToy(new Position(0, 1, null));
	}

	@Test
	public void testEval() throws Exception {

		SquareTableTop board = new SquareTableTop(columns, rows);
		ToyRobot toyRobot = new ToyRobot();
		Game game = new Game(board, toyRobot);

		game.eval("PLACE 0,0,NORTH");
		Assert.assertEquals("0,0,NORTH", game.eval("REPORT"));

		game.eval("MOVE");
		game.eval("RIGHT");
		game.eval("MOVE");
		Assert.assertEquals("1,1,EAST", game.eval("REPORT"));

		for (int i = 0; i < 10; i++)
			game.eval("MOVE");
		Assert.assertEquals("5,1,EAST", game.eval("REPORT"));

		for (int i = 0; i < 4; i++)
			game.eval("LEFT");
		Assert.assertEquals("5,1,EAST", game.eval("REPORT"));

		thrown.expect(Exception.class);
		Assert.assertEquals("Invalid command", game.eval("PLACE15NORTH"));
		thrown.expect(Exception.class);
		Assert.assertEquals("Invalid command", game.eval("LEFFTT"));
		thrown.expect(Exception.class);
		Assert.assertEquals("Invalid command", game.eval("RIGHTT"));
	}
}