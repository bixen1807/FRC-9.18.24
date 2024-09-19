package frc.robot.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Lights;

public class IntakeCommand extends Command {
    private Arm arm;
    private Intake intake;
    private boolean isFinished = false;
    public int elapsed = 0;
    public boolean triggered = false;
    public Timer tim = new Timer();
    public Lights lights;
    public IntakeCommand(){
        addRequirements(Constants.intake);

    }
    @Override
    public void initialize(){
        intake = Constants.intake;
        triggered = false;
        elapsed = 0;
        arm = Constants.arm;
        arm.setDesired(5.5);
        addRequirements(Constants.arm);
        lights = Constants.lights;
    }   

    @Override
    public void execute(){

        intake.run();
        lights.setColorRed(30, 150, 50);
        
        if(Constants.intake.intakeSensor.getVoltage()<.5) {
            triggered = true;
        }

        tim.start();
        
        while (true)
        {
            if (tim.hasElapsed(5.0))
            {
                intake.stop();
                break;
            }
        }
        /*

        CREATE THE INTAKE INSTRUCTIONS CODE HERE

        Try to understand what the "triggered", "elapsed", "intakeSensor" and of course "intake" variables do. 
        Check the constants class for other objects and variables used.
        As a bonus activity if you finish, try to use the "lights" object in order to make the intake react to having a note inside.
        
        */
        
        
    }
    @Override
    public boolean isFinished(){
         
        return isFinished;

    }

    @Override
    public void end(boolean interrupted) {
        if(interrupted) {
            lights.off();
        }
        Constants.intake.stop();
        isFinished = false;
    }
}

