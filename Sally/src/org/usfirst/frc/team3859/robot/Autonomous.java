package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {
	Timer autoTimer = new Timer();
	io OI = new io();
	boolean init = false;
	double order_ = 1;
	public String autoMode;
	double currangle = 50;
	double goal, speed;

	public enum autoMoode {
		REDSHOOTCROSS, BLUESHOOTCROSS, SHOOT, CROSS, NOTHING

	}

	/**
	 * 
	 * 
	 * 
	 * @param encDistance
	 * @param speed
	 * @param order
	 */
	public void drive(double encDistance, double speed, double order) {
		// oi.driver.SetUp();
		if (init == false) {
			Map.leftfront.reset();
			OI.driver.encSetUp();
			OI.driver.SetUp(true);
			init = true;
		}

		// SmartDashboard.putNumber("Auto Time", autoTimer.get());
		if (order == order_) {
			if (Map.leftfront.getPosition() <= encDistance) {
				// Map.leftfront.set(-speed);
				OI.geary.setPos(gear.position.UP);
				// to change the voltage for right. change the value below(the one after "-speed
				// -"
				Map.rightfront.set(-speed - 0);
				Map.leftfront.set(-speed - .05);
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
	 * @param time
	 * @param speed
	 * @param order
	 */
	public void timedrive(double time, double speed, double order) {
		// oi.driver.SetUp();
		if (init == false) {
			if (order == 1) {
				autoTimer.start();
			}
			autoTimer.reset();
			init = true;
		}

		// SmartDashboard.putNumber("Auto Time", autoTimer.get());
		if (order == order_) {
			if (autoTimer.get() <= time) {
				// Map.leftfront.set(-speed);
				OI.geary.setPos(gear.position.UP);
				// to change the voltage for right. change the value below(the one after "-speed
				// -"
				Map.rightfront.set(-speed);
				Map.leftfront.set(speed);
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
	 * @param goal
	 * @param speed
	 * @param order
	 * 
	 */

	/*
	 * void turnToAngle(double goal, double speed, double order,boolean direction) {
	 * double angle = 0; if (init == false) { Map.navx.reset(); Map.navx.zeroYaw();
	 * angle = Map.navx.getYaw(); init = true; } // Map.navx.reset(); // double
	 * differencee = Currangle - goal; // if(goal >180) { // double remainder = goal
	 * - 180; // goal = Math.abs(remainder) + // }\ double Currangle = 0; if (angle
	 * < 0) { Currangle = (Map.navx.getYaw()) + angle;
	 * 
	 * } else if (angle > 0) { Currangle = (Map.navx.getYaw()) - angle;
	 * 
	 * } else { Currangle = 0; } double RDistance; double NegGoal = goal - 360;
	 * double LeftDistance = NegGoal - Currangle; double difference = Currangle /
	 * goal; LeftDistance = LeftDistance * -1; LeftDistance = LeftDistance % 360;
	 * LeftDistance = LeftDistance * -1; if ((goal - Currangle) < 0) { RDistance =
	 * goal - Currangle; RDistance = RDistance * -1; RDistance = RDistance % 360;
	 * RDistance = RDistance * -1; RDistance = RDistance + 360; } else { RDistance =
	 * goal - Currangle; } if (Math.abs(LeftDistance) < Math.abs(RDistance)) { if
	 * (Currangle > goal) { // if (difference == .5) { // Map.rightfront.set(speed);
	 * // } else if (difference == .6) { // Map.rightfront.set(speed - 3); // } else
	 * if (difference == .7) { // Map.rightfront.set(speed - 6); // } else if
	 * (difference == .8) { // Map.rightfront.set(speed - 8); // } else if
	 * (difference == .9) { // Map.rightfront.set(speed - 10); // }else {
	 * Map.leftfront.set(-speed); Map.rightfront.set(speed); // } } else if
	 * (Currangle <= goal) { Map.leftfront.set(0); Map.rightfront.set(0); init =
	 * false; } } else { if (Currangle < goal) { // if (difference == .5) { //
	 * Map.leftfront.set(speed); // } else if (difference == .6) { //
	 * Map.leftfront.set(speed - 3); // } else if (difference == .7) { //
	 * Map.leftfront.set(speed - 6); // } else if (difference == .8) { //
	 * Map.leftfront.set(speed - 9); // } else if (difference == .9) { //
	 * Map.leftfront.set(speed - 10); // }else { Map.leftfront.set(speed);
	 * Map.rightfront.set(-speed); // } } else if (Currangle >= goal) {
	 * Map.leftfront.set(0); Map.rightfront.set(0); init = false; } }
	 * 
	 * }
	 */

	void angle(double goal, double speed, double order, String direction) {
		if (init == false) {
			if (order == 1) {
				autoTimer.start();
				// order_ = 1;
			}
			Map.navx.reset();
			// Map.climb.set(.5);
			// Map.navx.zeroYaw();
			init = true;
			// goal = goal - 5;
			// goal = goal + 20;
		}
		double negative = speed * -1;
		// currangle = Map.navx.getAngle();
		currangle = Map.navx.getAngle();
		double RDistance;
		double NegGoal = goal - 360;
		double LeftDistance = NegGoal - currangle;
		double product = currangle / goal;
		double difference = goal - currangle;
		LeftDistance = LeftDistance * -1;
		LeftDistance = LeftDistance % 360;
		LeftDistance = LeftDistance * -1;
		if (difference < 0) {
			RDistance = goal - currangle;
			RDistance = RDistance * -1;
			RDistance = RDistance % 360;
			RDistance = RDistance * -1;
			RDistance = RDistance + 360;
			SmartDashboard.putNumber("RightDistance", RDistance);
		} else {
			RDistance = goal - currangle;
			SmartDashboard.putNumber("RightDistance", RDistance);
		}
		SmartDashboard.putNumber("Left Distance", LeftDistance);
		SmartDashboard.putNumber("Current Angle", currangle);
		if (order == order_) {
			// OI.geary.setPos(gear.position.UP);
			// if (Math.abs(LeftDistance) < Math.abs(RDistance)) {
			switch (direction) {
			case "left":
				SmartDashboard.putString("Direction", "Left");
				if (LeftDistance < -10) {
					// if (difference == .5) {
					// Map.rightfront.set(speed);
					// } else if (difference == .6) {
					// Map.rightfront.set(speed - 3);
					// } else if (difference == .7) {
					// Map.rightfront.set(speed - 6);
					// } else if (difference == .8) {
					// Map.rightfront.set(speed - 8);
					// } else if (difference == .9) {
					// Map.rightfront.set(speed - 10);
					// } else {
//					if (difference < .9) {
						// Map.leftfront.set(speed);
						Map.rightfront.set(-speed);
//					} else if (difference >= .9) {
//						Map.rightfront.set(-speed  + .05);
//					}
					// Map.leftfront.set(negative);
					// speed = speed - .05;
					// }
				} else if (LeftDistance > -10 && LeftDistance < 10) {
					Map.leftfront.set(0);
					Map.rightfront.set(0);
					Map.navx.reset();
					order_++;
					init = false;
				}
				break;
			case "right":
				// } else if (Math.abs(RDistance) < Math.abs(LeftDistance)) {
				SmartDashboard.putString("Direction", "Right");
				if (RDistance > 10) {
					// if (difference <= .5) {
//					if (difference < .9) {
						// Map.leftfront.set(speed);
						Map.leftfront.set(-speed);
//					} else if (difference >= .9) {
//						Map.leftfront.set(-speed + .05);
//					}
					// Map.rightfront.set(speed);
					// Map.rightfront.set(negative);
					// } else if (difference <= .6) {
					// Map.leftfront.set(speed - .2);
					// } else if (difference <= .7) {
					// Map.leftfront.set(speed - .4);
					// } else if (difference <= .8) {
					// Map.leftfront.set(speed - .6);
					// } else if (difference <= .9) {
					// Map.leftfront.set(speed - .8);
					// }
					// } else if (RDistance <= 0 && RDistance >= 360) {
				} else if (RDistance < 10 && RDistance > -10) {
					Map.leftfront.set(0);
					Map.rightfront.set(0);
					Map.navx.reset();
					order_++;
					init = false;
				}
				break;
			}

		}
	}

	// }

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
				// order_ = 1;
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
	public void leftTurn(double time, double speed, double order) {
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
				// order_ = 1;
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
			OI.driver.SetUp(false);
			autoMode = SmartDashboard.getString("Auto Mode", "test");
			goal = SmartDashboard.getNumber("Goal");
			// speed = SmartDashboard.getNumber("Speed");
			initiate = true;
		} else if (initiate == true) {
			switch (autoMode) {
			case "center":
				// centerpeg
				SmartDashboard.putNumber("Order", order_);
				drive(2, .25, 1);
				nothing(.5, 2);
				gearScore(3, 3);
				break;
			case "cross":
				SmartDashboard.putNumber("Order", order_);
				// cross
				// drive(10, .4, 1);
				// turnToAngle(25, .6, 2);
				// OI.driver.SetUp(false);
				// Map.leftfront.set(.4);
				Map.leftfront.set(.4);
				break;
			case "turn":
				SmartDashboard.putNumber("Order", order_);
				angle(90, .25, 1, "right");
				// nothing(.5, 2);
				angle(-90, .25, 2, "left");
				// nothing(.6, 2);
				// timedrive(2, .5, 3);
				// nothing(.6, 4);
				// gearScore(2, 5);

				break;
			}
			if (order_ > 7) {
				autoMode = "test";
			}
		}
	}
}
