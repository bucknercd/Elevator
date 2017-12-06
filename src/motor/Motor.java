package motor;

import java.util.Observable;
import java.util.Observer;


public class Motor implements Observer {
	
	volatile private MotorState currentState;
	private static int counter;
	
	public Motor() {
		this.currentState = new MotorOff(this);
		counter = 0;
	}
	
	public void turnOn() {
		this.currentState.turnOn();
	}
	
	public void turnOff() {
		this.currentState.turnOff();
	}

	public boolean isOn() {
		return (this.currentState instanceof MotorOn);
	}
	
	public void setCurrentState(MotorState state) {
		this.currentState = state;
		this.currentState.printState();
	}
	
	public MotorState getCurrentState() {
		return this.currentState;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (this.isOn()) {
			counter++;
			if (counter == 10) {
				this.turnOff();
				counter = 0;
			}
		}
	}

}
