package edu.greenblitz.bigRodika.commands.lifter.elbow;

import edu.greenblitz.bigRodika.commands.lifter.ArmCommand;

public class StopElbow  extends ArmCommand {

    @Override
    public void initialize() {
        arm.moveWrist(0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
