package edu.greenblitz.bigRodika;

import edu.wpi.first.wpilibj.RobotBase;

import java.util.function.Supplier;

public class main {
    private static class RobotSupplier implements Supplier<Robot> {
        private Robot currentRobot;

        @Override
        public Robot get() {
            currentRobot = new Robot();
            return currentRobot;
        }
    }

    private static RobotSupplier robotFactory = new RobotSupplier();

    public static void main(String... args) {
        RobotBase.startRobot(robotFactory);
    }

    public static Robot getInstance() {
        return robotFactory.currentRobot;
    }
}
