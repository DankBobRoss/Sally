package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;

public class climb {

	
	
	private void setUp() {
	Map.climb.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	public enum climbMode {
		UP, DISABLE
	}
	
	public void Set(climbMode state, double speed) {
		
		switch (state) {
		case UP:
			setUp();
			Map.climb.set(speed);
			
			break;
		case DISABLE:
			setUp();
			Map.climb.set(0);


			break;
		
		
		
	}


	
	
	
	
	
	
	
	
	
	}
	
	
}
