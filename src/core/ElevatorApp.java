package core;

import elevator.Elevator;

public class ElevatorApp {

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		elevator.openDoors();
		elevator.closeDoors();

		for (int i = 0; i < 4; i++)
			elevator.goUp();
		
		for (int i = 0; i < 4; i++)
			elevator.goDown();

		elevator.turnOff();
	}
}
