/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4499.robot;

import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import edu.wpi.first.wpilibj.I2C.Port;

public class RobotMap {

	public static DoubleSolenoid shifters = new DoubleSolenoid(0, 7);
	public static DoubleSolenoid intake = new DoubleSolenoid(2, 5);
	public static DoubleSolenoid catapult = new DoubleSolenoid(1, 6);
	public static DoubleSolenoid catapultRelease = new DoubleSolenoid(3, 4);
	public static AHRS navx = new AHRS(Port.kMXP);

	public static Value intakeIn = DoubleSolenoid.Value.kReverse;
	public static Value intakeOut = DoubleSolenoid.Value.kForward;

	public static Value releaseClosed = DoubleSolenoid.Value.kForward;
	public static Value releaseOpen = DoubleSolenoid.Value.kReverse;

	public static Value catapultResting = DoubleSolenoid.Value.kForward;
	public static Value catapultSet = DoubleSolenoid.Value.kReverse;

	public static AnalogInput pressureSensor = new AnalogInput(0);

	public static int leftMasterTalonID = 1;
	public static int leftFollowerTalonID = 2;
	public static int rightMasterTalonID = 3;
	public static int rightFollowerTalonID = 4;
	public static int intakeMotorID = 5;
	public static int pincherTalonID = 6;
	public static TalonSRX leftMasterTalon = new TalonSRX(leftMasterTalonID); // blue encoder
	public static TalonSRX leftFollowerTalon = new TalonSRX(leftFollowerTalonID); // yellow
	public static TalonSRX rightMasterTalon = new TalonSRX(rightMasterTalonID); // red
	public static TalonSRX rightFollowerTalon = new TalonSRX(rightFollowerTalonID);// green encoder
	public static TalonSRX intakeMotor = new TalonSRX(intakeMotorID);
	public static TalonSRX pincher = new TalonSRX(pincherTalonID);
}
