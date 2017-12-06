package elevator;

import doors.Doors;
import motor.Motor;
import time.MyTimer;

public class Elevator {
	private ElevatorState currentState;
	private MyTimer timer;
	private Motor motor;
	private Doors doors;
	private static short floorNum;
	
	public Elevator() {
		this.timer = new MyTimer();
		new Thread(timer).start();
		this.motor = new Motor();
		this.doors = new Doors();
		timer.addObserver(motor);
		timer.addObserver(doors);

		floorNum = 1;
		this.currentState = new ElevatorIdle(this);
		this.printInitialStates();
	}
	
	public void goUp() {
		this.currentState.goUp();
	}
	
	public void goDown() {
		this.currentState.goDown();
	}
	
	public void openDoors() {
			this.doors.openDoors();
	}
	
	public void closeDoors() {
		this.doors.closeDoors();
	}
	
	public void turnOff() {
		this.timer.cancelTimer();
	}
	
	public Motor getMotor() {
		return this.motor;
	}
	
	public Doors getDoors() {
		return this.doors;
	}
	
	public short getFloorNum() {
		return floorNum;
	}
	
	public void setFloorNum(short num) {
		floorNum = num;
	}
	
	public void setCurrentState(ElevatorState state) {
		this.currentState = state;
		this.currentState.printState();
	}

	private void printInitialStates() {
		this.motor.getCurrentState().printState();
		this.doors.getCurrentState().printState();
		this.currentState.printState();
	}
}
