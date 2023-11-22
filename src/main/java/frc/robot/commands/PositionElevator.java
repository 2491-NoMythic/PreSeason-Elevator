// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator;
import static frc.robot.Constants.ElevatorConstants.*;

public class PositionElevator extends CommandBase {
  elevator elevator;
  
  /** Creates a new defaultElevator. */
  public PositionElevator(elevator elevator) {
    this.elevator = elevator;
    addRequirements(elevator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    elevator.resetEncoder(0);  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevator.setSecondArm((elevator.getDesiredHeight()-elevator.getPosMeters())*runningKP+kFF);
    SmartDashboard.putNumber("elevator motor ouptut", ((elevator.getDesiredHeight()-elevator.getPosMeters())*runningKP+kFF));
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
