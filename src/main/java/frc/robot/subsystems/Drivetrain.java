package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private final SpeedControllerGroup rightMotor, leftMotor;
  private final DifferentialDrive drive;

  public Drivetrain() {
    this.rightMotor = new SpeedControllerGroup(new VictorSP(0), new VictorSP(1));
    this.leftMotor = new SpeedControllerGroup(new VictorSP(2), new VictorSP(3));

    this.drive = new DifferentialDrive(this.leftMotor, this.rightMotor);
  }

  public void arcadeDrive(double forward, double rotation) {
    this.drive.arcadeDrive(forward, -(rotation));
  }
}
