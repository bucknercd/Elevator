package elevator;


public class ElevatorUp implements ElevatorState {
	
	private Elevator elevator;
	
	public ElevatorUp(Elevator elevator) {
		this.elevator = elevator;
	}
	
	@Override
	public void goUp() {
	}

	@Override
	public void goDown() {
	}

	@Override
	public void printState() {
		System.out.println("Elevator is going up");
	}

}
