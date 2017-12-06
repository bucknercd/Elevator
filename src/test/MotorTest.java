package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import motor.Motor;
import time.MyTimer;

public class MotorTest {
	private static MyTimer timer;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		timer = new MyTimer();
		new Thread(timer).start();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		timer.cancelTimer();
	}

	//test fails if motor does not stop within 10.1 seconds
	@Test(timeout=10100)
	public void testMotor() {
		//create a motor and add to the timer as an observer
		
		Motor motor = new Motor();
		timer.addObserver(motor);
		
		motor.turnOn();
		while(motor.isOn()) {
		}
		
		//if test makes it here before 10.1 seconds then test passes
		assertTrue(true);
	}

}
