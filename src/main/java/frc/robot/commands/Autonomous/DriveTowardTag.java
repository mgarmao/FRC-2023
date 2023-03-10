package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.commands.Drivetrain.*;


public class DriveTowardTag extends SequentialCommandGroup {
    public DriveTowardTag() {
        addCommands(
            new MoveDistance(24).withTimeout(0),
            new Rotate(90).withTimeout(0),
            new MoveDistance(24).withTimeout(0),
            new Rotate(90).withTimeout(0),new MoveDistance(24).withTimeout(0),
            new Rotate(90).withTimeout(0),new MoveDistance(24).withTimeout(0),
            new Rotate(90).withTimeout(0)
        );  
    }

}