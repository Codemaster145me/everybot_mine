// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.lang.Math;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //private Command m_autonomousCommand;

  //private RobotContainer m_robotContainer;
  //private DriveTrainSubsystem dts = new DriveTrainSubsystem();
  public static Joystick driveJoystick = new Joystick(0);

  private Spark leftMotor1 = new Spark(1);
  private Spark leftMotor2 = new Spark(2);
  
  MotorControllerGroup leftGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

  private Spark rightMotor1 = new Spark(3);
  private Spark rightMotor2 = new Spark(4);
  
  MotorControllerGroup rightGroup = new MotorControllerGroup(rightMotor1, rightMotor2);

  MotorControllerGroup allmotors = new MotorControllerGroup(rightGroup, leftGroup);

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
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    double speed = driveJoystick.getRawAxis(1) * 0.5;
    double turn = driveJoystick.getRawAxis(4) * 0.3;

    double left = speed + turn;
    double right = speed - turn;

    double roundedSpeed = Math.round(speed * 100.0) / 100.0; 
    double roundedRight = Math.round(right * 100.0) / 100.0;
    double roundedLeft = Math.round(left * 100.0) / 100.0;
    
    if(right > 0.5){
      rightMotor1.set(right);
      rightMotor2.set(right);
    }

    if (roundedRight > -0.3){
      rightMotor1.set(0);
      rightMotor2.set(0);
    }

    if(left > 0.5){
      leftMotor1.set(left);
      leftMotor2.set(left);
    }

    if (roundedLeft > -0.3){
      leftMotor1.set(0);
      leftMotor2.set(0);
    }

    if(speed > 0.5 || speed < 0.5){
      rightMotor1.set(speed);
      rightMotor2.set(speed);
      leftMotor1.set(speed);
      leftMotor2.set(speed);
    }

    if(speed > -0.5 || speed < -0.5){
      rightMotor1.set(-speed);
      rightMotor2.set(-speed);
      leftMotor1.set(-speed);
      leftMotor2.set(-speed);
    }

    SmartDashboard.putNumber("drive forward power (%)", roundedSpeed);
    SmartDashboard.putNumber("drive right power (%)", roundedRight);
    SmartDashboard.putNumber("drive left power (%)", roundedLeft);

    leftMotor1.setInverted(true);
    leftMotor2.setInverted(true);
    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
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
