package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Destiny Hale 2022
 */
@Autonomous(name= "StackandPark", group= "Linear Opmode")

public class StackAndScanAutonomous extends LinearOpMode {
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

        //close claw to grab preloaded cone
        Gru.useClaw(false, true);

        //wait and then raise cone so it doesn't drag
        Gru.waitA(500);
        Gru.useLift(-.6, 750);


// Move beside junction
        Gru.autoStrafe(-.25, 4780);
        Gru.driveStraight(-.3, 2350);

//get in front of junction
        Gru.autoStrafe(.4, 950);
        Gru.waitA(2000);

// stack
        //Move a little forward
        Gru.driveStraight(-.14, 1000);

        //raise lift, open claw and wait
        Gru.useLift(-.65, 1850);
        Gru.waitA(3000);
        Gru.useClaw(true, false);
        Gru.waitA(1000);

        // Close Claw
        Gru.useClaw(false, true);
        Gru.waitA(1000);

// Go to Signal Sleeve
        Gru.autoStrafe(-.2, 1500);
        Gru.waitA(1000);
        Gru.driveStraight(.35, 3000);
        Gru.autoStrafe(.32, 1500);

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












        /* Gru.autoStrafe(-.4,6000);
Gru.driveStraight(.4,2000); */






