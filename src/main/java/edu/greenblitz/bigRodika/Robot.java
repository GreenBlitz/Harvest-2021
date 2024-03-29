package edu.greenblitz.bigRodika;

import edu.greenblitz.bigRodika.commands.ArcadeDrive;
import edu.greenblitz.bigRodika.subsystems.Chassis;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

    @Override
    public void robotInit() {
        OI.getInstance();
        Chassis.getInstance();
        CommandScheduler.getInstance().enable();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        new ArcadeDrive(OI.getInstance().getMainJoystick()).schedule();
    }
}
