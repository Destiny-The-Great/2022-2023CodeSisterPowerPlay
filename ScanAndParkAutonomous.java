
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Destiny Hale 2022
 */
@Autonomous(name= "ComplexPark", group= "Linear Opmode")

public class ScanAndParkAutonomous extends LinearOpMode {

    // Establish Universal Variables
    Hardware Gru = new Hardware();
    ElapsedTime runtime = new ElapsedTime();

    //variables for color sensor method
    boolean pathOne = false;
    boolean pathTwo = false;
    boolean pathThree = false;

    //Color Sensor Method
    public void getColour() {

       // Turn the LED light on
        Gru.cs.enableLed(true);

        // If the sensor seems more blue than red and green
        if (Gru.cs.blue() > Gru.cs.red() && Gru.cs.blue() > Gru.cs.green()) {
               //We need to use route 1
                pathOne = true;

            // Or if more green
        } else if (Gru.cs.green() > Gru.cs.red() && Gru.cs.green() > Gru.cs.blue()) {

            //We need to use route 2
            pathTwo = true;

            //otherwise we need to use route 3
        } else {
            pathThree = true;
        }
    }


    @Override
    public void runOpMode() throws InterruptedException {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        System.out.println("Initialize Robot");
        Gru.initializeRobot(hardwareMap);
        System.out.println("Robot Initialized");

        telemetry.addData("Status", "Ready!");
        System.out.println("Howdy!");

        telemetry.update();
        waitForStart();

        //Drive to Signal Sleeve and stop

        Gru.driveStraight(-.2,1050);
        Gru.waitA(3000);

//pause and read
        getColour();
        Gru.waitA(3000);

        // if its path one then go here (etc)
        if (pathOne) {
            Gru.autoStrafe(-.3,3000);

        } else if (pathTwo) {
            Gru.autoStrafe(-.3,1500);

        } else {
            Gru.autoStrafe(.3, 500);
        }

    }
}

