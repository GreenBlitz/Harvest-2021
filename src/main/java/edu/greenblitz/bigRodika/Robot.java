package edu.greenblitz.bigRodika;

import edu.greenblitz.bigRodika.commands.ArcadeDrive;
import edu.greenblitz.bigRodika.subsystems.Chassis;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import java.util.HashMap;

public class Robot extends TimedRobot {

    private double startTime;
    private boolean recordDriver = true;//will be false when we need to stop the recording.
    private HashMap<Double, HashMap<String, Double>> followDriverData;

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

    @Override
    public void testInit() {
        startTime = System.currentTimeMillis() / 1000.0;

    }

    @Override
    public void testPeriodic() {
        if (OI.getInstance().getMainJoystick().START.get() && recordDriver) {
            recordDriver = false;

        }
        if (recordDriver) {
            followDriverData.put((System.currentTimeMillis() / 1000.0) - startTime, OI.getInstance().getMainJoystick().getButtonsOn());
        }
    }
    /* todo: finish function - make a csv string that represent the hashmap;
    private <T, K> String HashMapToCsv(HashMap<T, K> myMap) {
        String eol = System.getProperty("line.separator");

        try (Writer writer = new FileWriter("somefile.csv")) {
            for (Map.Entry<String, String> entry : myHashMap.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue())
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }*/


}
