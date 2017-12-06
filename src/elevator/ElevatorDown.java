package elevator;

public class ElevatorDown implements ElevatorState {
	
	private Elevator elevator;
	
	public ElevatorDown(Elevator elevator) {
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
		System.out.println("Elevator is going down");
	}

}
