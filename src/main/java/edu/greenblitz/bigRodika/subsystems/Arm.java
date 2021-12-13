package edu.greenblitz.bigRodika.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.greenblitz.bigRodika.RobotMap;
import edu.greenblitz.gblib.subsystems.GBSubsystem;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import org.greenblitz.motion.base.Position;

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

	public double getElbowPosition() {
		//returns the number of rotations the sparkMAX is currently set to
		return getElbow().getElbowMotorController().getEncoder().getPosition();
	}

	public void moveElbowByPower(double power) {
		elbow.elbowMotorController.set(power);
	}

	public void moveWristByPower(double power) {
		wrist.wristMotorController.set(power);
	}

	public void stopElbow() {
		moveElbowByPower(0.0);
	}

	public void stopWrist() {
		moveWristByPower(0.0);
	}

	public Elbow getElbow() {
		return elbow;
	}

	public Wrist getWrist() {
		return wrist;
	}

	public class Elbow extends GBSubsystem {
		private Arm parent;
		private CANSparkMax elbowMotorController;

		public Elbow(Arm parent) {
			this.parent = parent;
			elbowMotorController = new CANSparkMax(RobotMap.BigRodika.Arm.Motors.ELBOW_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
			elbowMotorController.setInverted(RobotMap.BigRodika.Arm.Motors.ELBOW_REVERSED);
		}

		public Arm getArm() {
			return parent;
		}

		public CANSparkMax getElbowMotorController() {
			return elbowMotorController;
		}

		@Override
		public void periodic() {
			super.periodic();
		}

	}

	public class Wrist extends GBSubsystem {
		private Arm parent;
		private CANSparkMax wristMotorController;

		public Wrist(Arm parent) {
			this.parent = parent;
			wristMotorController = new CANSparkMax(RobotMap.BigRodika.Arm.Motors.WRIST_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
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
