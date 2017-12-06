package doors;

public class DoorOpen implements DoorState {
	
	private Doors doors;
	
	public DoorOpen(Doors doors) {
		this.doors = doors;
	}
	
	@Override
	public void open() {
	}

	@Override
	public void close() {
		this.doors.setCurrentState(new DoorClosed(this.doors));
	}

	@Override
	public void printState() {
		System.out.println("Elevator doors are open");
	}

}
