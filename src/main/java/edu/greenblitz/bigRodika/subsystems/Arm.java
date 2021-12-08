package edu.greenblitz.bigRodika.subsystems;

import edu.greenblitz.bigRodika.RobotMap;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Arm extends GBSubsystem {
    private static Arm instance;
    private Elbow elbow;
    private Wrist wrist;

    public Arm() {
        elbow = new Elbow(this);
        wrist = new Wrist(this);
    }

    public static void init() {
        if (instance == null) {
            instance = new Arm();
            CommandScheduler.getInstance().registerSubsystem(instance.elbow);
            CommandScheduler.getInstance().registerSubsystem(instance.wrist);
        }
    }

    public static Arm getInstance() {

        return instance;
    }

    public void moveElbow(double power) {
        elbow.elbowMotorController.set(power);
    }

    public void moveWrist(double power) {
        wrist.wristMotorController.set(power);
    }

    public Elbow getElbow() {
        return elbow;
    }

    public Wrist getWrist() {
        return wrist;
    }

    public class Elbow extends GBSubsystem {
        private Arm parent;
        private PWMSparkMax elbowMotorController;

        public Elbow(Arm parent) {
            this.parent = parent;
            elbowMotorController = new PWMSparkMax(RobotMap.BigRodika.Arm.Motors.ELBOW_PORT);
            elbowMotorController.setInverted(RobotMap.BigRodika.Arm.Motors.ELBOW_REVERSED);
        }

        public Arm getArm() {
            return parent;
        }

        @Override
        public void periodic() {
            super.periodic();
        }

    }

    public class Wrist extends GBSubsystem {
        private Arm parent;
        private PWMSparkMax wristMotorController;

        public Wrist(Arm parent) {
            this.parent = parent;
            wristMotorController = new PWMSparkMax(RobotMap.BigRodika.Arm.Motors.WRIST_PORT);
            wristMotorController.setInverted(RobotMap.BigRodika.Arm.Motors.WRIST_REVERSED);
        }

        public Arm getArm() {
            return parent;
        }

        @Override
        public void periodic() {
            super.periodic();
        }
    }

}
