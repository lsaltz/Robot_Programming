/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4499.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team4499.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4499.robot.Robot;
import org.usfirst.frc.team4499.robot.tools.PID;
import edu.wpi.first.wpilibj.Timer;

/**
 * An example command. You can replace me with your own command.
 */
public class BothSides extends Command {
	PID turnController = new PID(0, 0, 0);
	private double speed = 0.30;
	private double time;
	private double desiredAngle;

	private double kp = 0.025;
	private double ki = 0.00025;
	private double kd = 0.000025;

	private PID orientation;
	private int zeroed;
	private float turnPower;
	private double forwardSpeed;
	private boolean across = false;
	private int run;
	private double startAngle;

	public BothSides() {
		RobotMap.leftMasterTalon.set(ControlMode.PercentOutput, -forwardSpeed - orientation.getResult());
		RobotMap.rightMasterTalon.set(ControlMode.PercentOutput, -forwardSpeed + orientation.getResult());
		// Use requires() here to declare subsystem dependencies
		requires(Robot.subsystem);
		desiredAngle = RobotMap.navx.getAngle();
		forwardSpeed = 0.30;
		orientation = new PID(kp, ki, kd);
		orientation.setMaxOutput(0.50);
		orientation.setMinOutput(-.50);

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		time = Timer.getFPGATimestamp();

		startAngle = RobotMap.navx.getAngle();
		orientation.setSetPoint(desiredAngle);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		orientation.getResult();

		forwardSpeed = 0.40;
		orientation.updatePID(RobotMap.navx.getAngle());
		RobotMap.leftMasterTalon.set(ControlMode.PercentOutput, -forwardSpeed - orientation.getResult());
		RobotMap.rightMasterTalon.set(ControlMode.PercentOutput, -forwardSpeed + orientation.getResult());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (Timer.getFPGATimestamp() - (time) >= (10)) {
		return true;
		} 
		else return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		orientation.setSetPoint(RobotMap.navx.getAngle());
		RobotMap.leftMasterTalon.set(ControlMode.PercentOutput, 0);
		RobotMap.rightMasterTalon.set(ControlMode.PercentOutput, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
