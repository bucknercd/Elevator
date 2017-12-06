package doors;

import java.util.Observable;
import java.util.Observer;

public class Doors implements Observer {
	
	volatile private DoorState currentState;
	private static short counter;
	
	public Doors() {
		this.currentState = new DoorClosed(this);
		counter = 0;
	}
	
	public void openDoors() {
		this.currentState.open();
	}
	
	public void closeDoors() {
		this.currentState.close();
	}
	
	public DoorState getCurrentState() {
		return this.currentState;
	}
	
	public void setCurrentState(DoorState state) {
		this.currentState = state;
		this.currentState.printState();
	}
	
	public boolean isOpen() {
		return (this.currentState instanceof DoorOpen);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (this.isOpen()) {
			counter++;
			if (counter == 5) {
				this.closeDoors();
				counter = 0;
			}
		}
	}
}
