// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//test
// Autonomous program created with help from Team 303

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import static frc.robot.RobotContainer.*;

import frc.robot.commands.Drivetrain.*;
import frc.robot.commands.Intake.*;
import frc.robot.subsystems.Intake;

public class Taxi extends SequentialCommandGroup {
    public Taxi() {
      addCommands(
        new Eject(0.4).withTimeout(4),
        new IntakeStop().withTimeout(1),
        new ReverseMoveDistance(78,0.45).withTimeout(4)
      );
  }
}
