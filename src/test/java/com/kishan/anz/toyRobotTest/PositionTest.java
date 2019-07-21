package com.kishan.anz.toyRobotTest;

import org.junit.Assert;
import org.junit.Test;

import com.kishan.anz.toyRobot.FacingDirection;
import com.kishan.anz.toyRobot.Position;

public class PositionTest {

	@Test
	public void testGetNextPosition() throws Exception {
		Position position = new Position(0, 0, FacingDirection.EAST);

		Position newPosition = position.getNextPosition();
		Assert.assertEquals(newPosition.getX(), 1);
		Assert.assertEquals(newPosition.getY(), 0);
		Assert.assertEquals(newPosition.getDirection(), FacingDirection.EAST);

		newPosition = newPosition.getNextPosition();
		Assert.assertNotEquals(newPosition.getX(), 1);
		Assert.assertEquals(newPosition.getY(), 0);
		Assert.assertEquals(newPosition.getDirection(), FacingDirection.EAST);

		newPosition.setDirection(FacingDirection.NORTH);
		newPosition = newPosition.getNextPosition();
		Assert.assertNotEquals(newPosition.getX(), 1);
		Assert.assertEquals(newPosition.getY(), 1);
		Assert.assertNotEquals(newPosition.getDirection(), FacingDirection.EAST);

	}
}