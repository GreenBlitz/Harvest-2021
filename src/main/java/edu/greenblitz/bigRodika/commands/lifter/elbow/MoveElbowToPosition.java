package edu.greenblitz.bigRodika.commands.lifter.elbow;

public class MoveElbowToPosition extends ElbowCommand {
	private double wantedPosition;
	private int reversed; //TODO: turn this bitch to enum
	private static final double POWER = 0.1; //TODO: Test and change accordingly
	private static final double EPSILON = 0.1 * (Math.PI / 180); //converted 0.1 degrees to radians

	public MoveElbowToPosition(double wantedPosition, int reversed) {
		this.wantedPosition = wantedPosition;
		this.reversed = reversed;
	}

	public MoveElbowToPosition(double wantedPosition) {
		this(wantedPosition, 1);
	}

	public MoveElbowToPosition() {
		this(0);
	}

	@Override
	public void execute() {
		if (wantedPosition > arm.getElbowPosition())
			reversed *= -1; //TODO: check if this is wrong (robot is dumb and so is Raz)
		arm.moveElbowByPower(POWER * reversed);
	}

	@Override
	public void end(boolean interrupted) {
		arm.stopElbow();
	}

	@Override
	public boolean isFinished() {
		return Math.abs(wantedPosition - arm.getElbowPosition()) < EPSILON;
	}
}
