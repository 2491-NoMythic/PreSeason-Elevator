package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.PS4Controller;
import static  frc.robot.Constants.ElevatorConstants.*;



import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class PositionElevator extends CommandBase{
    elevator elevator;
    double target;
    int Direction;
    public PositionElevator(elevator Elevator, double Target){
        addRequirements(Elevator);
        this.elevator = Elevator;
    }
    @Override
    public void initialize(){
        if (elevator.getCurrentPositon() < target){
            elevator.setSecondArm(1);
            Direction = 1;
        } else if (elevator.getCurrentPositon() > target){
            elevator.setSecondArm(-1);
            Direction = -1;
        } else {
            elevator.stopSecondArm();
            Direction = 0;
        }
        
    }
    @Override
    public void execute(){

    }
    @Override
    public boolean isFinished(){
        if (Direction > 0 && elevator.getCurrentPositon() >= target){
            return true;
        } else if (Direction < 0 && elevator.getCurrentPositon() <= target){
            return true;
        } else if (Direction == 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void end(boolean interrupted) {
        elevator.setSecondArm(0);
    }
}

