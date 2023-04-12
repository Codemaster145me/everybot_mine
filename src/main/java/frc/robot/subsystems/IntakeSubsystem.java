package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Robot;

public class IntakeSubsystem extends SubsystemBase{

    /** Creates a new ExampleSubsystem. */
    public IntakeSubsystem() {
    }

    CANSparkMax intake = new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushless);

	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;

    static public JoystickButton IntakeInButton = new JoystickButton(Robot.driveJoystick, A);
    static public JoystickButton IntakeOutButton = new JoystickButton(Robot.driveJoystick, X);

    /**
     * Example command factory method.
     *
     * @return a command
     */
    public CommandBase exampleMethodCommand() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
                () -> {
                    /* one-time action goes here */
                });
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a
     * digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */

    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        boolean t_out = IntakeOutButton.getAsBoolean();
        boolean t_in = IntakeInButton.getAsBoolean();
        SmartDashboard.putBoolean("Intake Out", t_out);
        SmartDashboard.putBoolean("Intake In ", t_in);

        if(t_out == true){
            intake.set(-1);
        }

        if(t_in == true){
            intake.set(1);
        }
        intake.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
