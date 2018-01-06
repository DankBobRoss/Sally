package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Drive {

	public enum driveMode {
		TEST, DRIVE
	}

	public void encSetUp() {
		Map.leftfront.changeControlMode(CANTalon.TalonControlMode.Position);
		Map.leftfront.setControlMode(CANTalon.TalonControlMode.Position.value);
		Map.leftfront.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		Map.leftfront.configEncoderCodesPerRev(512);
	}

	public void SetUp(boolean enc) {
		if (enc == true) {
			Map.leftfront.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		}
		Map.rightfront.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		Map.leftmiddle.changeControlMode(CANTalon.TalonControlMode.Follower);
		Map.rightmiddle.changeControlMode(CANTalon.TalonControlMode.Follower);

		Map.leftback.changeControlMode(CANTalon.TalonControlMode.Follower);
		Map.rightback.changeControlMode(CANTalon.TalonControlMode.Follower);

		Map.leftmiddle.set(Map.leftfront.getDeviceID());
		Map.rightmiddle.set(Map.rightfront.getDeviceID());

		Map.leftback.set(Map.leftfront.getDeviceID());
		Map.rightback.set(Map.rightfront.getDeviceID());

		Map.leftfront.setInverted(true);

	}

	public void Set(driveMode state) {
		SetUp(false);
		switch (state) {
		case TEST:
			Map.leftfront.set(.4);
			Map.rightfront.set(.4);
			break;
		case DRIVE:
			Map.leftfront.set(Map.Xbox1.getY(Hand.kLeft));
			Map.rightfront.set(Map.Xbox1.getY(Hand.kRight));
			break;
		}
	}

	public void Move(double leftSpeed, double rightSpeed) {
		SetUp(false);
		Map.leftfront.set(leftSpeed);
		Map.rightfront.set(rightSpeed);
	}
}
