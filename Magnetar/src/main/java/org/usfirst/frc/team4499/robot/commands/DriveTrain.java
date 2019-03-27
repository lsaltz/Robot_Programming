package org.usfirst.frc.team4499.robot.commands;

import org.usfirst.frc.team4499.robot.OI;
import org.usfirst.frc.team4499.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrain extends Command {
	
    public DriveTrain() {

    }


    protected void initialize() {

    }

    protected void execute() {
        
		if (Math.abs(OI.controllerZero.leftJoystickVal) > 0.10) {

            RobotMap.leftMasterTalon.set(ControlMode.PercentOutput,leftJoystickVal);

        }

        else {

            RobotMap.leftMasterTalon.set(ControlMode.PercentOutput,0);

        }

        if (Math.abs(OI.controllerZero.rightJoystickVal) > 0.10) {

            RobotMap.rightMasterTalon.set(ControlMode.PercentOutput, rightJoystickVal);

        }
		
		else {

            RobotMap.rightMasterTalon.set(ControlMode.PercentOutput,0);

        }
    }

    protected boolean isFinished() {

        return false;

    }

    protected void end() {

    	RobotMap.leftMasterTalon.set(ControlMode.PercentOutput, 0);
    	RobotMap.rightMasterTalon.set(ControlMode.PercentOutput, 0);
    
    }

    protected void interrupted() {
        
    }
}
