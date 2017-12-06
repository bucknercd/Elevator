package motor;

public class MotorOff implements MotorState {
	
	private Motor motor;
	
	public MotorOff(Motor motor) {
		this.motor = motor;
		
	}
	
	@Override
	public void turnOn() {
		this.motor.setCurrentState(new MotorOn(this.motor));
	}

	@Override
	public void turnOff() {
	}

	@Override
	public void printState() {
		System.out.println("Motor is off");
	}

}
