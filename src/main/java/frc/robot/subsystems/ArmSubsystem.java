package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Robot;
import com.revrobotics.CANSparkMaxLowLevel;

public class ArmSubsystem extends SubsystemBase{

    /** Creates a new ExampleSubsystem. */
    public ArmSubsystem() {
    }

    CANSparkMax Arm = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);

	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;

    static public JoystickButton ArmInButton = new JoystickButton(Robot.driveJoystick, Y);
    static public JoystickButton ArmOutButton = new JoystickButton(Robot.driveJoystick, B);

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
        boolean A_out = ArmOutButton.getAsBoolean();
        boolean A_in = ArmInButton.getAsBoolean();
        SmartDashboard.putBoolean("Arm  Out", A_out);
        SmartDashboard.putBoolean("Arm  In ", A_in);

        if(A_out == true){
            Arm.set(-1);
        }

        if(A_in == true){
            Arm.set(1);
        }
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
