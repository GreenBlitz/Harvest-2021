package edu.greenblitz.bigRodika.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.greenblitz.bigRodika.RobotMap;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Intake extends GBSubsystem {
    //TODO: check if needs extender or something else
    private static Intake instance;
    private CANSparkMax rollerLeader;
    private CANSparkMax rollerFollower;

    private Intake() {
        rollerLeader = new CANSparkMax(RobotMap.BigRodika.Intake.Motors.MOTOR_ONE, CANSparkMaxLowLevel.MotorType.kBrushless);
        rollerLeader.setInverted(RobotMap.BigRodika.Intake.Motors.ROLLER_REVERSED);
        rollerFollower = new CANSparkMax(RobotMap.BigRodika.Intake.Motors.MOTOR_TWO, CANSparkMaxLowLevel.MotorType.kBrushless);
        rollerFollower.follow(rollerLeader);
        rollerFollower.setInverted(!RobotMap.BigRodika.Intake.Motors.ROLLER_REVERSED);
    }

    public static void init() {
        if (instance == null) {
            instance = new Intake();
            CommandScheduler.getInstance().registerSubsystem(instance);
        }
    }

    public static Intake getInstance() {
        return instance;
    }

    public void moveRoller(double power) {
        rollerLeader.set(power);
    }
}
