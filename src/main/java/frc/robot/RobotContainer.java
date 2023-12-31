// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.elevator;
import frc.robot.commands.ControlElevator;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.PositionElevator;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private ExampleSubsystem m_ExampleSubsystem;

  private PS4Controller CoDriveController;
  private elevator elevator;
  private PS4Controller Drivecontoller;


    
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_ExampleSubsystem = new ExampleSubsystem();
    Drivecontoller = new PS4Controller(0);
    CoDriveController = new PS4Controller(1);
    

    exampleInst();
    if(true) {
      elevatorInst();
    } 
    // Configure the trigger bindings
    configureBindings();
  }
  
  private void elevatorInst() {
    elevator = new elevator(0.5);
    PositionElevator posElevator = new PositionElevator(elevator);
    elevator.setDefaultCommand(posElevator);
  }
  void exampleInst() {
    m_ExampleSubsystem = new ExampleSubsystem();
    ExampleCommand m_ExampleCommand = new ExampleCommand(m_ExampleSubsystem);
    m_ExampleSubsystem.setDefaultCommand(m_ExampleCommand);
  }
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_ExampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_ExampleSubsystem));
    new Trigger(CoDriveController::getCrossButton)
      .onTrue(new InstantCommand(() -> elevator.setDesiredHeight(0)));    
      new Trigger(CoDriveController::getCircleButton)
      .onTrue(new InstantCommand(() -> elevator.setDesiredHeight(0.5)));    
      new Trigger(CoDriveController::getTriangleButton)
      .onTrue(new InstantCommand(() -> elevator.setDesiredHeight(1)));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  //   Drivecontoller.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  // }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //  public void getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
  // }
}
}
