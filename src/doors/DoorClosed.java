package doors;

public class DoorClosed implements DoorState {
	
	private Doors doors;
	
	public DoorClosed(Doors doors) {
		this.doors = doors;
	}
	
	@Override
	public void open() {
		this.doors.setCurrentState(new DoorOpen(this.doors));
	}

	@Override
	public void close() {
	}

	@Override
	public void printState() {
		System.out.println("Elevator doors are closed");
	}

}
