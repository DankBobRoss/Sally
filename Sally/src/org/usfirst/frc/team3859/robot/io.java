package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class io {
	gear geary = new gear();
	Drive driver = new Drive();
	climb Climb = new climb();
	PrevButton prev = PrevButton.NONE;
	enum PrevButton {
		R_BUMPER, L_BUMPER, NONE
	}

	public void Enable() {

		// DRIVEEEEEEEEEE 
		driver.Set(Drive.driveMode.DRIVE);
		if(Map.Xbox1.getAButton()) {
			Map.navx.reset();
//			Map.newGyro.reset();
		}

		// GEAR STUFF
			
		if (Map.Xbox2.getTriggerAxis(Hand.kRight) > .4) {
			geary.setMotor(gear.motorMode.INTAKE);  
		} else if (Map.Xbox2.getTriggerAxis(Hand.kLeft) > .4) {
			geary.setMotor(gear.motorMode.SCORE);
		} else {
			geary.setMotor(gear.motorMode.OFF);
			
		}
		
		// Each bumper pressed, sets the state 
		if(Map.Xbox2.getBumper(Hand.kRight)) {
			prev = PrevButton.R_BUMPER;
		}else if(Map.Xbox2.getBumper(Hand.kLeft)){
			prev = PrevButton.L_BUMPER;
		}
		
		// Checks the state, and move intake accordingly
		if(prev == PrevButton.R_BUMPER) {
			geary.setPos(gear.position.DOWN);
		}else if(prev == PrevButton.L_BUMPER) {
			geary.setPos(gear.position.UP);
		}
		
		// CLIMB
		Climb.Set(climb.climbMode.UP, Map.Xbox1.getTriggerAxis(Hand.kLeft));

	}
}
