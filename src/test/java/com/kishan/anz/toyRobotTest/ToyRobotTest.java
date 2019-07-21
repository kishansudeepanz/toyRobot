package com.kishan.anz.toyRobotTest;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.kishan.anz.toyRobot.FacingDirection;
import com.kishan.anz.toyRobot.Position;
import com.kishan.anz.toyRobot.ToyRobot;

public class ToyRobotTest {

	@Rule
	public org.junit.rules.ExpectedException thrown = ExpectedException.none();

	@Test
	public void testMovement() throws Exception {

		ToyRobot robot = new ToyRobot(new Position(0, 0, FacingDirection.NORTH));

		Assert.assertTrue(robot.move());
		Assert.assertEquals(0, robot.getPosition().getX());
		Assert.assertEquals(1, robot.getPosition().getY());
		Assert.assertEquals(FacingDirection.NORTH, robot.getPosition().getDirection());

		robot.setPosition(new Position(1, 2, FacingDirection.EAST));
		robot.move();
		robot.move();
		robot.rotateLeft();
		robot.move();

		Assert.assertEquals(3, robot.getPosition().getX());
		Assert.assertEquals(3, robot.getPosition().getY());
		Assert.assertEquals(FacingDirection.NORTH, robot.getPosition().getDirection());

		robot.setPosition(new Position(0, 0, FacingDirection.NORTH));
		robot.rotateRight();
		Assert.assertEquals(FacingDirection.EAST, robot.getPosition().getDirection());
		robot.rotateRight();
		Assert.assertEquals(FacingDirection.SOUTH, robot.getPosition().getDirection());
		robot.rotateRight();
		Assert.assertEquals(FacingDirection.WEST, robot.getPosition().getDirection());
		robot.rotateRight();
		Assert.assertEquals(FacingDirection.NORTH, robot.getPosition().getDirection());
		robot.rotateRight();
		Assert.assertEquals(FacingDirection.EAST, robot.getPosition().getDirection());
	}

}