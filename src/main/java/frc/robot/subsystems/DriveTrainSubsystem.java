/*
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
    CANSparkMax motorsRight1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax motorsRight2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax motorsLeft1 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax motorsLeft2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

    MotorControllerGroup leftGroup = new MotorControllerGroup(motorsLeft1, motorsLeft2);
    MotorControllerGroup rightGroup = new MotorControllerGroup(motorsRight1, motorsRight2);

    DifferentialDrive s_drive = new DifferentialDrive(leftGroup,rightGroup);
     

    public DriveTrainSubsystem() {
        // motorsRight.setIdleMode(CANSparkMax.IdleMode.kBrake);
        motorsLeft1.setIdleMode(CANSparkMax.IdleMode.kBrake);
        motorsLeft2.setIdleMode(CANSparkMax.IdleMode.kBrake);
        motorsRight1.setIdleMode(CANSparkMax.IdleMode.kBrake);
        motorsRight2.setIdleMode(CANSparkMax.IdleMode.kBrake);

        motorsLeft1.setInverted(false);
        motorsLeft2.setInverted(false);
        motorsRight1.setInverted(true);
        motorsRight2.setInverted(true);
    }


    public void setMotorsLeft(double speed){
        motorsLeft1.set(speed);
    }

    public void setMotorsRight(double speed){
        motorsRight1.set(speed);
    }

    public void setdrive(Joystick controller){
        s_drive.setDeadband(0.0008);
        s_drive.tankDrive(-controller.getRawAxis(1), -controller.getRawAxis(5)); // if the robot is going right then change controller.getrawaxis to controller,getrawaxis   
    }
}
*/