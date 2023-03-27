package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.*;
/*
import Command.ArmUpCommand;
import frc.robot.subsystems.Arm;
import Command.ArmDownCommand;
*/
import java.util.function.BooleanSupplier;
//import Command.intake;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    //private final Arm arm = new Arm();
    //private final ArmUpCommand AC = new ArmUpCommand(arm);
    //private final ArmDownCommand AD = new ArmDownCommand(arm);
    //private final intake itc = new intake(intake);


    // Replace with CommandPS4Controller or CommandJoystick if needed
   // private final CommandXboxController driverController = new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);
    
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {
        // Configure the trigger bindings
        configureBindings();
    }
    
    
    /**
     * Use this method to define your trigger->command mappings. Triggers can be created via the
     * {@link Trigger#Trigger(BooleanSupplier)} constructor with an arbitrary
     * predicate, or via the named factories in {@link
     * CommandGenericHID}'s subclasses for {@link
     * CommandXboxController Xbox}/{@link CommandPS4Controller
     * PS4} controllers or {@link CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings()
    {
        //JoystickButton armButton = new JoystickButton(driverController, 1);// tells what button on the controller   it's A on the controller
        //armButton.onTrue(AC);//run the arm command
    }
    
    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An example command will be run in autonomous
        return null;
    }

}