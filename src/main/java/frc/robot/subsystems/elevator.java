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

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class elevator extends SubsystemBase {
  /** Creates a new elevator. */

  // CANSparkMax armMotor1;
  // CANSparkMax armMotor2; 
  // CANSparkMax armMotor3;
  CANSparkMax armMotor1;
  RelativeEncoder armEncoder;
  
  double maxSpeed;
 
  public elevator(double maxSpeed) {
    armMotor1 = new CANSparkMax(ARM_MOTOR_1, MotorType.kBrushless);
 
    armEncoder = armMotor1.getEncoder();
    this.maxSpeed = maxSpeed;
  }

  public void setSecondArm(double speed) {
    if(speed>maxSpeed) {speed = maxSpeed;}
    armMotor1.set(speed);
  }

  public void stopSecondArm() {
    armMotor1.set(0);
  }


  public void stopAll() {
    stopSecondArm();
  }
  public double getCurrentPositon(){
    return armEncoder.getPosition();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
 