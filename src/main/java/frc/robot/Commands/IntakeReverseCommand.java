package frc.robot.Commands;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Intake;

public class IntakeReverseCommand extends Command {
    private Arm arm;
    private Intake intake;
    private boolean isFinished = false;
    
    public IntakeReverseCommand(){
        addRequirements(Constants.intake);

    }

    @Override
    public void initialize(){
        intake = Constants.intake;   
    }

    @Override
    public void execute(){
        intake.reverse();
    }
    @Override
    public boolean isFinished(){
        return isFinished;

    }

    @Override
    public void end(boolean interrupted) {
    // Constants.intakeStatus = false;
        intake.stop();

    }
    
}
