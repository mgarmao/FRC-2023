// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TeleopIndicator extends SubsystemBase {
    
    public static boolean teleopEnabledBool = false;

    public TeleopIndicator() {
    }

    public static void teleopEnabled() {
        teleopEnabledBool = true;
    }

    public static void teleopDisabled(){
        teleopEnabledBool = false;
    }

    public boolean getTeleopMode(){
        return teleopEnabledBool;
    }

    public void stop() {
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Teleop Status", teleopEnabledBool);
    }

}