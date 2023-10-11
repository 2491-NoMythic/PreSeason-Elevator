// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import static frc.robot.Constants.ElevatorConstants.*;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class elevator extends SubsystemBase {
  /** Creates a new elevator. */

  CANSparkMax armMotor1;
  CANSparkMax armMotor2;
  CANSparkMax armMotor3;
  double maxSpeed;
 
  public elevator(double maxSpeed) {
    armMotor1 = new CANSparkMax(ARM_MOTOR_1, MotorType.kBrushless);
    armMotor2 = new CANSparkMax(ARM_MOTOR_2, MotorType.kBrushless);
    armMotor3 = new CANSparkMax(2491, MotorType.kBrushless);
    this.maxSpeed = maxSpeed;
  }

  public void setSecondArm(double speed) {
    if(speed>maxSpeed) {speed = maxSpeed;}
    armMotor1.set(speed);
  }

  public void setThirdArm(double speed) {
    if(speed>maxSpeed) {speed = maxSpeed;}
    armMotor2.set(speed);
  }

  public void stopSecondArm() {
    armMotor1.set(0);
  }

  public void stopThirdArm() {
    armMotor2.set(0);
  }

  public void stopAll() {
    stopSecondArm();
    stopThirdArm();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
 