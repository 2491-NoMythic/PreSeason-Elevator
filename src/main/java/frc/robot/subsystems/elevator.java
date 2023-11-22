// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static frc.robot.Constants.ElevatorConstants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class elevator extends SubsystemBase {
  /** Creates a new elevator. */

  // CANSparkMax armMotor1;
  // CANSparkMax armMotor2; 
  // CANSparkMax armMotor3;
  CANSparkMax armMotor1;
  
  double maxSpeed;
  public double h;
  double rotationsPerMeter = ENCODER_ROTS_PER_METER;
 
  public elevator(double maxSpeed) {
    armMotor1 = new CANSparkMax(ARM_MOTOR_1, MotorType.kBrushless);
    armMotor1.setIdleMode(IdleMode.kBrake);
  
    this.maxSpeed = maxSpeed;
  }

  public void setSecondArm(double speed) {
    if(speed>maxSpeed) {speed = maxSpeed;}
    armMotor1.set(speed);
  }

  public void stopSecondArm() {
    armMotor1.set(0);
  }

  public void resetEncoder(double value) {
    armMotor1.getEncoder().setPosition(value);
  }


  public void stopAll() {
    stopSecondArm();
  }

  public void setDesiredHeight(double height) {
    h = height;
  }

  public double getDesiredHeight() {
    return h;
  }

  public double getPos() {
    return armMotor1.getEncoder().getPosition();
  }

  public double getPosMeters() {
    return armMotor1.getEncoder().getPosition()/ENCODER_ROTS_PER_METER;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
 