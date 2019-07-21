package com.kishan.anz.toyRobot;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {

		System.out.println("Valid commands : ");
		System.out.println("PLACE X,Y,NORTH|SOUTH|EAST|WEST, MOVE, LEFT, RIGHT, REPORT, EXIT");
		System.out.println("Enter a command :");

		SquareTableTop squareTableTop = new SquareTableTop(5, 5);
		ToyRobot robot = new ToyRobot();
		Game game = new Game(squareTableTop, robot);

		boolean keepRunning = true;
		while (keepRunning) {
			String inputString = new Scanner(System.in).nextLine();
			if ("EXIT".equals(inputString)) {
				keepRunning = false;
			} else {
				try {
					String outputVal = game.eval(inputString);
					System.out.println(outputVal);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
