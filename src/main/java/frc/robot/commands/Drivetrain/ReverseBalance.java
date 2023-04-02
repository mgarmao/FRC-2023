// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

import static frc.robot.RobotContainer.*;

public class ReverseBalance extends CommandBase {
/////
  double kP = 0.01;
  double kI = 0.0;
  double kD = 0.01;

  double addedSpeed = 0.2;
  double detectAngle = 12;
  double anglePIDLimit = 0.2;
/////


  boolean aparentLevel = false;
  double balancePID = 1; 
  double initAngle = 0;
  double m_setpoint = 0;
  PIDController pid = new PIDController(kP, kI, kD);

  boolean keepStartingYaw;

  public ReverseBalance(boolean m_keepStartingYaw) {
    keepStartingYaw = m_keepStartingYaw;
    addRequirements(gyro);
    addRequirements(m_drivetrain);
  }

  @Override
  public void initialize() {
    initAngle = gyro.getYaw();
  }

  @Override
  public void execute() {
    double anglePID;
    if(keepStartingYaw){
      anglePID = pid.calculate(Constants.startYaw,gyro.getYaw());
    }
    else{
      anglePID = pid.calculate(initAngle,gyro.getYaw());
    }

    if(anglePID>=anglePIDLimit){
      anglePID=anglePIDLimit;
    }

    if(anglePID<=-anglePIDLimit){
      anglePID=-anglePIDLimit;
    }

    if((gyro.getPitch()<-detectAngle)){
      double driveLeft = addedSpeed-anglePID;
      double driveRight = addedSpeed+anglePID;
      m_drivetrain.tankDrive(-driveLeft, -driveRight); 
      SmartDashboard.putNumber("Motor",driveLeft);   

    }
    else if((gyro.getPitch()>detectAngle)){
      double driveLeft = addedSpeed+anglePID;
      double driveRight = addedSpeed-anglePID;
      m_drivetrain.tankDrive(driveLeft, driveRight);
      SmartDashboard.putNumber("Motor",driveLeft);  
    }
    else{
      m_drivetrain.tankDrive(0, 0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setBrakeMode();
    m_drivetrain.stop();
    m_drivetrain.setCoast();
    
  }

  @Override
  public boolean isFinished() {
    if((gyro.getPitch()>-detectAngle)&&(gyro.getPitch()<detectAngle)){
      SmartDashboard.putBoolean("balancing", true);
      m_drivetrain.setBrakeMode();
      m_drivetrain.stop();
    }
    else{
      SmartDashboard.putBoolean("balancing", false);
    }
    return false;
  }
}