package frc.robot;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ArmSubsystem;

import java.lang.Math;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  IntakeSubsystem intake = new IntakeSubsystem();
  ArmSubsystem arm = new ArmSubsystem();

  //private Command m_autonomousCommand;

  //private RobotContainer m_robotContainer;
  //private DriveTrainSubsystem dts = new DriveTrainSubsystem();
  public static Joystick driveJoystick = new Joystick(0); 

  CANSparkMax rightMotor1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftMotor1 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftMotor2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
  
  MotorControllerGroup leftGroup = new MotorControllerGroup(leftMotor1, leftMotor2);
  MotorControllerGroup rightGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
  
  DifferentialDrive arcadeDrive = new DifferentialDrive(leftGroup, rightGroup);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    //m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and+
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    ///m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    //if (m_autonomousCommand != null) {
     // m_autonomousCommand.schedule();
    //}
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    /*if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    } */
    leftMotor1.setInverted(false);
    leftMotor2.setInverted(false);
    rightMotor1.setInverted(false);
    rightMotor2.setInverted(false);

    rightMotor1.setIdleMode(IdleMode.kBrake);
    rightMotor2.setIdleMode(IdleMode.kBrake);
    leftMotor1.setIdleMode(IdleMode.kBrake);
    leftMotor2.setIdleMode(IdleMode.kBrake);

    rightMotor1.setSmartCurrentLimit(40);
    rightMotor2.setSmartCurrentLimit(40);
    leftMotor1.setSmartCurrentLimit(40);
    leftMotor2.setSmartCurrentLimit(40);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    
    double speed = -driveJoystick.getRawAxis(1)*0.5; // axis 1, left joystick, [-0.5, 0.5], forward, backwards
    double turn = driveJoystick.getRawAxis(4)*0.3; // axis 4, right joystick, [-0.3, 0.3], left, right

    arcadeDrive.setDeadband(0.1);
    arcadeDrive.arcadeDrive(speed, turn);

    /*double left = speed - turn;  
    double right = speed + turn;

    leftGroup.set(left);
    rightGroup.set(right);*/
    
    double roundedSpeed = Math.round(speed * 100.0) / 100.0; 
    double roundedRight = Math.round(turn * 100.0) / 100.0;
    double roundedLeft = Math.round(turn * 100.0) / 100.0;
    
    SmartDashboard.putNumber("drive forward power (%)", roundedSpeed);
    SmartDashboard.putNumber("drive right power (%)", roundedRight);
    SmartDashboard.putNumber("drive left power (%)", roundedLeft);
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
