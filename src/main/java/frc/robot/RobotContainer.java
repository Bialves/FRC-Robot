package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  private final Drivetrain drivetrain;

  private final XboxController controller;

  public RobotContainer() {
    this.drivetrain = new Drivetrain();
    this.controller = new XboxController(1);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    this.configureButtonBindingsDrivetrain();
  }

  public void configureButtonBindingsDrivetrain(){
    this.drivetrain.setDefaultCommand(
      new ArcadeDrive(
        drivetrain, 
        () -> this.controller.getY(Hand.kLeft), 
        () -> this.controller.getX(Hand.kRight)
      )
    );
  }

  public Command getAutonomousCommand() {
    return autoCommand; //autonomous under construction
  }
}