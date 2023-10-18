// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.PS4Controller;
import static  frc.robot.Constants.ElevatorConstants.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.function.DoubleSupplier;

public class ControlElevator extends CommandBase {

  elevator elevator;
  DoubleSupplier leftAxisSupplier;
  DoubleSupplier rightAxisSupplier;
  /** Creates a new ControlElevator. */
  public ControlElevator(elevator Elevator, DoubleSupplier rightaxSupplier) {
    addRequirements(Elevator);
    this.elevator = Elevator;
    this.rightAxisSupplier = rightaxSupplier;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevator.setSecondArm(rightAxisSupplier.getAsDouble()*P_OF_CONTROLLER);
    SmartDashboard.putNumber("joystick rightY", rightAxisSupplier.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.stopAll();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
