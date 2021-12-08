package edu.greenblitz.bigRodika.commands.lifter.wrist;

import edu.greenblitz.bigRodika.commands.lifter.ArmCommand;

public class StopWrist extends ArmCommand {

    @Override
    public void initialize() {
        arm.moveElbow(0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
