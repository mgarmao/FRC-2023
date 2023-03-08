// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 *  This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *s
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /** Operator and Driver Controllers */
    public static final int CONTROLLER_OPERATOR = 0;
    public static final int JOYSTICK_LEFT = 1;
    public static final int JOYSTICK_RIGHT = 2;
    public static final double JOYSTICK_CURVE   = 5/3;
    //public static final double DRIVER_INPUT_CURVE = 3;
    public static final int DRIVETRAIN_GEAR_RATIO = 9;
    public static final double WHEEL_CIRCUMFRANCE = 5.75;

    /** Drive Train */
    public static final int DRIVE_FRONT_LEFT = 1;
    public static final int DRIVE_REAR_LEFT = 5;
    public static final int DRIVE_FRONT_RIGHT = 4;
    public static final int DRIVE_REAR_RIGHT = 2; 

    //** Intake Motor */
    public static final int INTAKE_WHEELS = 3; 
    public static final double INTAKE_SPEED = 1; //Subject to Josh

    /** Elevator */
    public static final int ELEVATOR_LEFT = 6;
    public static final int ELEVATOR_RIGHT = 7;
    public static final double ELEVATOR_POWER = 0.3;//xxxxx
    public static final float ELEVATOR_LOWER_LIMIT = -125;
    public static final float ELEVATOR_UPPER_LIMIT = 0;

    //arm
    public static int ARM = 8;
    public static double ARM_POWER = 0.8;
    // public static final float ARM_LOWER_LIMIT = -125;
    // public static final float ARM_UPPER_LIMIT = 0;

    //wrist
    public static int WRIST = 9;

    public static final int [] INTAKE_SOLENOID = new int[] {2, 1};
}
