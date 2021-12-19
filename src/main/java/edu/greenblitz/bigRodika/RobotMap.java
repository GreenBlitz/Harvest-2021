package edu.greenblitz.bigRodika;

public class RobotMap {

    public static class BigRodika {
        public static class Joystick {
            public static final int MAIN = 0;
            public static final int SECOND = 1;
        }

        public static class Chassis {
            public static class Motor {
                public static final int LEFT_VICTOR = 2,
                        RIGHT_VICTOR = 3,
                        LEFT_TALON = 1,
                        RIGHT_TALON = 4;
            }
        }

        public static class Arm {
            public static class Motors {
                public static final int ELBOW_PORT = 0; //TODO: not really the port
                public static final int WRIST_PORT = 0; //TODO: not really the port
                public static final boolean ELBOW_REVERSED = false;  //TODO: not really the port
                public static final boolean WRIST_REVERSED = false;  //TODO: not really the port
            }
        }

        public static class Intake {
            public static class Motors {
                public static final int MOTOR_ONE = 5; //TODO: not actual port
                public static final int MOTOR_TWO = 6; //TODO: not actual port
                public static final boolean ROLLER_REVERSED = false; //TODO: might be reversed
            }
        }
    }
}
