package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class io {
	gear geary = new gear();
	Drive driver = new Drive();
	climb Climb = new climb();

	public void Enable() {

		// DRIVEEEEEEEEE
		driver.Set(Drive.driveMode.DRIVE);

		// GEAR STUFF
			
		if (Map.Xbox2.getTriggerAxis(Hand.kRight) > .4) {
			geary.setMotor(gear.motorMode.INTAKE);
		} else if (Map.Xbox2.getTriggerAxis(Hand.kLeft) > .4) {
			geary.setMotor(gear.motorMode.SCORE);
		} else {
			geary.setMotor(gear.motorMode.OFF);
		}
		
		if(Map.Xbox2.getBumper(Hand.kRight)) {
			geary.setPos(gear.position.DOWN);
		}else if(Map.Xbox2.getBumper(Hand.kLeft)){
			geary.setPos(gear.position.UP);
		}

		// CLIMB
		Climb.Set(climb.climbMode.UP, Map.Xbox1.getTriggerAxis(Hand.kLeft));

	}
}
