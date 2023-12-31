// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class ElevatorConstants{
    public static final int ARM_MOTOR_1 = 2; 
    public static final double P_OF_CONTROLLER = 0.5; //multiplied by joystick value when using joystick to control elevator
    public static final double runningKP = 1; //multiplied by difference of (current pos) and (target pos) when using buttons to control elevator
    public static final double ENCODER_ROTS_PER_METER = 62.6593; //theres 2(pi) inches per rotation with this elevator
    public static final double kFF = 0; //this is the amount of motor power the arm needs to merely hold the load in place

  }
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
