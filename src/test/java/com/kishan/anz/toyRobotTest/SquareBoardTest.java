package com.kishan.anz.toyRobotTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import com.kishan.anz.toyRobot.Position;
import com.kishan.anz.toyRobot.SquareTableTop;

public class SquareBoardTest {

	@Test
	public void testIsValidPosition() throws Exception {
		Position mockPosition = mock(Position.class);
		when(mockPosition.getX()).thenReturn(6);
		when(mockPosition.getY()).thenReturn(7);

		SquareTableTop board = new SquareTableTop(4, 5);
		Assert.assertFalse(board.isValidPosition(mockPosition));

		when(mockPosition.getX()).thenReturn(1);
		when(mockPosition.getY()).thenReturn(1);
		Assert.assertTrue(board.isValidPosition(mockPosition));

		when(mockPosition.getX()).thenReturn(-1);
		when(mockPosition.getY()).thenReturn(-1);
		Assert.assertFalse(board.isValidPosition(mockPosition));
	}

}