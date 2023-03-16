package frc.robot.commands.GoingToSetpoints;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wrist;

import static frc.robot.RobotContainer.*;

public class WristSetpoint extends CommandBase {
    double setPoint=0; 
    public WristSetpoint(double m_setPoint) {
        setPoint = m_setPoint;
        addRequirements(wrist);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    wrist.setPosition(setPoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    wrist.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}