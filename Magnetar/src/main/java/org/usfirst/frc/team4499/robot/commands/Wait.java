package org.usfirst.frc.team4499.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {

    private double waitTime = 0;
	private double startTime = 0;

    public Wait(double time) {

        waitTime = time;

    }

    protected void initialize() {

        startTime= Timer.getFPGATimestamp();

    }

    protected void execute() {

    	System.out.println((Timer.getFPGATimestamp()- startTime) > waitTime);
    
    }

    protected boolean isFinished() {

        return Timer.getFPGATimestamp()- startTime > waitTime;
    
    }

    protected void end() {

    }

    protected void interrupted() {
  
    }
}
