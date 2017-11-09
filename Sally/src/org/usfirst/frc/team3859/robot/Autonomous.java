package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {
	Timer autoTimer = new Timer();
	io OI = new io();
	boolean init = false;
	double order_ = 1;
	public String autoMode;

	public enum autoMoode {
		REDSHOOTCROSS, BLUESHOOTCROSS, SHOOT, CROSS, NOTHING

	}
	/**
	 * 
	 * 
	 * 
	 * @param time
	 * @param speed
	 * @param order
	 */
	public void drive(double time, double speed, double order) {
		// oi.driver.SetUp();
		if (init == false) {
			if (order == 1.0) {
				autoTimer.start();
				order_ = 1;
			}
			autoTimer.reset();
			init = true;
		}

		// SmartDashboard.putNumber("Auto Time", autoTimer.get());
		if (order == order_) {
			if (autoTimer.get() <= time) {
				Map.leftfront.set(-speed);
				//to change the voltage for right. change the value below(the one after "-speed -"
				Map.rightfront.set(-speed - .05);
			} else {
				Map.leftfront.set(0);
				Map.rightfront.set(0);
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}
	/**
	 * 
	 * 
	 * 
	 * @param time
	 * @param order
	 */
	public void gearScore(double time, double order) {
		if (init == false) {
			if (order == 1) {
				autoTimer.start();
				order_ = 1;
			}
			autoTimer.reset();
			init = true;
		}
		if (order == order_) {
			if (autoTimer.get() < time) {
				OI.geary.setPos(gear.position.DOWN);
				OI.geary.setMotor(gear.motorMode.SCORE);
			} else if (autoTimer.get() >= time) {
				OI.geary.setPos(gear.position.UP);
				OI.geary.setMotor(gear.motorMode.OFF);
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}

	}
	/**
	 * 
	 * 
	 * @param time
	 * @param speed
	 * @param order
	 */
	public void leftTurn(double time, double speed, int order) {
		if (init == false) {
			if (order == 1) {
				autoTimer.start();
				order_ = 1;
			}
			autoTimer.reset();
			init = true;
		}
		if (order == order_) {
			if (autoTimer.get() < time) {
				Map.leftfront.set(speed);
				Map.rightfront.set(-speed);

			} else if (autoTimer.get() >= time) {
				Map.leftfront.set(0);
				Map.rightfront.set(0);
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}
	/**
	 * 
	 * 
	 * @param time
	 * @param speed
	 * @param order
	 */
	public void rightTurn(double time, double speed, double order) {
		if (init == false) {
			if (order == 1) {
				autoTimer.start();
				order_ = 1;
			}
			autoTimer.reset();
			init = true;
		}
		if (order == order_) {
			if (autoTimer.get() < time) {
				// Map.lefttfront.set(-speed);
				Map.rightfront.set(speed);
			} else if (autoTimer.get() >= time) {
				Map.leftfront.set(0);
				Map.rightfront.set(0);
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}
	/**
	 * 
	 * 
	 * @param time
	 * @param order
	 */
	public void nothing(double time, double order) {
		if (init == false) {
			if (order == 1) {
				autoTimer.start();
				order_ = 1;
			}
			autoTimer.reset();
			init = true;
		}
		if (order == order_) {
			if (autoTimer.get() < time) {

			} else if (autoTimer.get() >= time) {
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}

	// public String autoMode = "Test";
	// CANTalon geary = new CANTalon(9);

	boolean init1 = false;
	boolean initiate = false;

/**
 * Input mode first and the value after, for turn it is how long to turn then 0.
 * For Forward it is how long to go forward and how fast. And For shoot it is
 * how long to shoot and how fast.
 * 
 * @param autoMode
 */
public void autoSet() {
	if (initiate == false) {
		autoMode = SmartDashboard.getString("automode", "test");
		initiate = true;
	} else if (initiate == true) {
		switch (autoMode) {
		case "center":
			//centerpeg
		drive(1.6,.6,1);
		nothing(.5,2);
		gearScore(2,3);
			break;
		case "cross":
			//cross
			drive(3,.5,1);
			break;
		}
	}
}}
