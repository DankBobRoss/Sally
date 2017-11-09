package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class gear {

	enum motorMode {
		SCORE, INTAKE, OFF
	}

	enum position {
		DOWN, UP
	}

	boolean isDown = false;

	public void setMotor(motorMode state) {
		switch (state) {
		case SCORE:
			Map.intake.set(-1);
			Map.position.set(DoubleSolenoid.Value.kForward);

			break;
		case INTAKE:
			Map.intake.set(1);
			Map.position.set(DoubleSolenoid.Value.kForward);

			break;

		case OFF:
			Map.intake.set(0);
			Map.position.set(DoubleSolenoid.Value.kReverse);
			break;
		}
	}

	public void setPos(position state) {
		switch (state) {
		case DOWN:
			Map.position.set(DoubleSolenoid.Value.kForward);
			isDown = true;
			break;

		case UP:
			Map.position.set(DoubleSolenoid.Value.kReverse);
			isDown = false;
			break;

		}
	}
}
