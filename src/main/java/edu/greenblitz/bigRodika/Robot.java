package edu.greenblitz.bigRodika;

import edu.greenblitz.bigRodika.commands.ArcadeDrive;
import edu.greenblitz.bigRodika.subsystems.Chassis;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

    //todo: make sure the all is good
    private <T, K> void serializeHashMap(HashMap<T, K> myMap) {
        try {
            //when u run this code make sure to know the dest for the file.
            FileOutputStream myFileOutStream = new FileOutputStream("/src/main/resources/saveHashmap.txt");
            ObjectOutputStream myObjectOutStream = new ObjectOutputStream(myFileOutStream);
            myObjectOutStream.writeObject(myMap);//should check that writeObject will work recursively (we deal with HashMap in HashMap)
            //asaf said it will be find and it will work recursively
            myObjectOutStream.close();
            myFileOutStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //we copied those functions from gf"g, link:
    //https://www.geeksforgeeks.org/how-to-serialize-hashmap-in-java/
    private HashMap deserializeHashMap(String fileName) {
        try {
            FileInputStream fileInput = new FileInputStream("/src/main/resources/".concat(fileName).concat("txt"));
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            HashMap myMap = (HashMap) objectInput.readObject();
            objectInput.close();
            fileInput.close();
            return myMap;
        } catch (IOException obj1) {
            obj1.printStackTrace();
            return null;
        } catch (ClassNotFoundException obj2) {
            System.out.println("Class not found");
            obj2.printStackTrace();
            return null;
        }
    }


}
