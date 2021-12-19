package edu.greenblitz.bigRodika.commands.roller;

import edu.greenblitz.bigRodika.subsystems.Intake;
import edu.greenblitz.gblib.command.GBCommand;
import edu.greenblitz.gblib.hid.SmartJoystick;

public class IntakeByTrigger extends GBCommand {
    SmartJoystick joystick;

    public IntakeByTrigger(SmartJoystick js) {
        require(Intake.getInstance());
        this.joystick = js;
    }

    @Override
    public void execute() {
        Intake.getInstance().moveRoller(this.joystick.getAxisValue(SmartJoystick.Axis.RIGHT_TRIGGER));
    }
}
