package org.usfirst.frc.team3859.robot;

//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	Autonomous auto = new Autonomous();
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
//	int init = 0;
	int initt = 0;
	@Override
	public void robotInit() {
//		chooser.addDefault("Default Auto", defaultAuto);
//		chooser.addObject("My Auto", customAuto);
//		CameraServer.getInstance().startAutomaticCapture(0);
		SmartDashboard.putNumber("Goal", 0);
		SmartDashboard.putNumber("Speed",0);
//		CameraServer.getInstance().startAutomaticCapture(1);
		SmartDashboard.putString("Direction", "");
		SmartDashboard.putString("Auto Mode", "");
//		SmartDashboard.putNumber("Radians", 0);
//		SmartDashboard.putNumber("Roll", 0);
//		SmartDashboard.putNumber("Pitch", 0);
//		SmartDashboard.putBoolean("isDown", auto.OI.geary.isDown);
//		SmartDashboard.putNumber("Auto Timer", auto.autoTimer.get());
//		SmartDashboard.putNumber("Order", auto.order_);
//		SmartDashboard.putNumber("Yaws", 0);
//		Map.newGyro.calibrate();
//		Map.newGyro.calibrate();
	}
	@Override
	public void autonomousInit() {
//			Map.navx.reset();
//		autoSelected = chooser.getSelected();
//		 autoSelected = SmartDashboard.getString("Auto Selector",
//		 defaultAuto);
////		System.out.println("Auto selected: " + autoSelected);
//		SmartDashboard.putNumber("Auto Timer", auto.autoTimer.get());
//		SmartDashboard.putNumber("Order", auto.order_);
		Map.navx.reset();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
//		SmartDashboard.putNumber("NavX Angle", Map.navx.getAngle());
//		SmartDashboard.putNumber("NavX Angle Mod", (Map.navx.getAngle()) % 360);
		SmartDashboard.putNumber("Encoder Value", Map.leftfront.getEncPosition());
		SmartDashboard.putNumber("Position", Map.leftfront.getPosition());
		SmartDashboard.putNumber("NavX Angle", Map.navx.getAngle());
		SmartDashboard.putNumber("NavX Angle Mod", (Map.navx.getAngle()) % 360);
		auto.autoSet();
//		auto.angle(100,.4);
//		switch (autoSelected) {
//		case customAuto:
//			// Put custom auto code here
//			break;
//		case defaultAuto:
//		default:
//			// Put default auto code here
//			break;
//		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
//		if(initt == 0) {
//			Map.navx.reset();
//			Map.navx.zeroYaw();
////			Map.newGyro.reset();
//			initt = 1;
//		}
		auto.OI.Enable();
//		double goal = SmartDashboard.getNumber("Goal");
//		double speed = SmartDashboard.getNumber("Speed");
//		if(Map.Xbox2.getAButton()) {
//			auto.order_ = 1;
//		}
//		if(Map.Xbox2.getYButton()) {
//			auto.angle(goal, speed, 1);
//		}
		SmartDashboard.putNumber("NavX Angle", Map.navx.getAngle());
		SmartDashboard.putNumber("NavX Angle Mod", (Map.navx.getAngle()) % 360);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

