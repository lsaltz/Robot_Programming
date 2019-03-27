package org.usfirst.frc.team4499.robot.commands;

import org.usfirst.frc.team4499.robot.OI;
import org.usfirst.frc.team4499.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class Shifters extends Command {

    public Shifters() {

    }

    protected void initialize() {
    
    }

    protected void execute() {

    	if (OI.rightshiftButton.get()) {
        
            RobotMap.shifters.set(DoubleSolenoid.Value.kForward);
        
        } 
        
        else if (OI.leftshiftButton.get()) {
        
            RobotMap.shifters.set(DoubleSolenoid.Value.kReverse);
        
        }
    }

    protected boolean isFinished() {

        return false;

    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
