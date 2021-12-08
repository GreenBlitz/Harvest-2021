package edu.greenblitz.bigRodika.commands.lifter;

import edu.greenblitz.bigRodika.subsystems.Arm;
import edu.greenblitz.gblib.command.GBCommand;

public class ArmCommand extends GBCommand {
    protected Arm arm;

    public ArmCommand() {
        arm = Arm.getInstance();
    }
}
