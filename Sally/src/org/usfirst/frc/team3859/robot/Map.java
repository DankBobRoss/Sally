 package org.usfirst.frc.team3859.robot;
 import com.kauailabs.navx.frc.AHRS;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;

public class Map {

	//right drive
	static CANTalon rightfront = new CANTalon(5);
	static CANTalon rightmiddle = new CANTalon(6);
	static CANTalon rightback = new CANTalon(7);
	
	//left drive
	static CANTalon leftfront = new CANTalon(1);
	static CANTalon leftmiddle = new CANTalon(2);
	static CANTalon leftback = new CANTalon(3);
	
	
	//climb motor
	static CANTalon climb = new CANTalon(4);
	
	//gear motor and solenoid
	static DoubleSolenoid position = new DoubleSolenoid(2,0,1);
	static CANTalon intake = new CANTalon(8);
	
	//Xbox Controllers
	static XboxController Xbox1 = new XboxController(0);
	static XboxController Xbox2 = new XboxController(1);
	
	static AHRS navx = new AHRS(SPI.Port.kMXP);
//	static Gyro newGyro = new Gyro(1);
//	static AnalogGyro newGyro = new AnalogGyro(1);
}