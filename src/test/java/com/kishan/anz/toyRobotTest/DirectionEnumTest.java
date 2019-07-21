package com.kishan.anz.toyRobotTest;

import org.junit.Assert;
import org.junit.Test;

import com.kishan.anz.toyRobot.FacingDirection;

public class DirectionEnumTest {

	@Test
	public void testRotate() throws Exception {
		FacingDirection direction = FacingDirection.EAST;

		direction = direction.leftDirection();
		Assert.assertEquals(direction, FacingDirection.NORTH);

		direction = direction.leftDirection();
		Assert.assertEquals(direction, FacingDirection.WEST);

		direction = direction.leftDirection();
		Assert.assertEquals(direction, FacingDirection.SOUTH);

		direction = direction.leftDirection();
		Assert.assertEquals(direction, FacingDirection.EAST);

		direction = direction.leftDirection();
		Assert.assertEquals(direction, FacingDirection.NORTH);

		direction = direction.rightDirection();
		Assert.assertEquals(direction, FacingDirection.EAST);

		direction = direction.rightDirection();
		Assert.assertEquals(direction, FacingDirection.SOUTH);

		direction = direction.rightDirection();
		Assert.assertEquals(direction, FacingDirection.WEST);

		direction = direction.rightDirection();
		Assert.assertEquals(direction, FacingDirection.NORTH);

		direction = direction.rightDirection();
		Assert.assertEquals(direction, FacingDirection.EAST);
	}
}