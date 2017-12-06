package motor;

public class MotorOn implements MotorState {
	
	private Motor motor;
	
	public MotorOn(Motor motor) {
		this.motor = motor;
	}
	
	@Override
	public void turnOn() {
	}
	
	@Override
	public void turnOff() {
		this.motor.setCurrentState(new MotorOff(this.motor));
		
	}

	@Override
	public void printState() {
		System.out.println("Motor is on");
	}
	
}
