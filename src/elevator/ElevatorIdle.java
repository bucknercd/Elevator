package elevator;


public class ElevatorIdle implements ElevatorState {
	
	private Elevator elevator;
	
	public ElevatorIdle(Elevator elevator) {
		this.elevator = elevator;
	}
	
	@Override
	public void goUp() {
		short floorNum = this.elevator.getFloorNum();
		if (!this.elevator.getDoors().isOpen() && floorNum < 5) {
			this.elevator.getMotor().turnOn();
			this.elevator.setCurrentState(new ElevatorUp(this.elevator));
			
			while (this.elevator.getMotor().isOn()) 
				System.out.print("");
				
			this.elevator.setCurrentState(new ElevatorIdle(this.elevator));
			floorNum++;
			this.elevator.setFloorNum(floorNum);
			System.out.println("The elevator arrives at floor " + this.elevator.getFloorNum());
			this.elevator.getDoors().openDoors();
			
			while (this.elevator.getDoors().isOpen())
				System.out.print("");
		}
	}

	@Override
	public void goDown() {
		short floorNum = this.elevator.getFloorNum();
		if (!this.elevator.getDoors().isOpen() && floorNum > 1) {
			this.elevator.getMotor().turnOn();
			this.elevator.setCurrentState(new ElevatorDown(this.elevator));
			
			while (this.elevator.getMotor().isOn()) 
				System.out.print("");
				
			this.elevator.setCurrentState(new ElevatorIdle(this.elevator));
			floorNum--;
			this.elevator.setFloorNum(floorNum);
			System.out.println("The elevator arrives at floor " + this.elevator.getFloorNum());
			this.elevator.getDoors().openDoors();

			while (this.elevator.getDoors().isOpen())
				System.out.print("");
		}
	}


	@Override
	public void printState() {
		System.out.println("Elevator is idle");
	}
}
