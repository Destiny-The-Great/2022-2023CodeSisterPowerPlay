package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Destiny Hale 2022
 */
@Autonomous(name= "Test", group= "Linear Opmode")

public class AutonomousTest extends LinearOpMode {
    // Establish Universal Variables
    Hardware Gru = new Hardware();
    boolean pathOne = false;
    boolean pathTwo = false;
    boolean pathThree = false;
    // ElapsedTime runtime = new ElapsedTime();

    public void getColour() {

        //more blue than green
        Gru.cs.enableLed(true);
        if (Gru.cs.blue() > Gru.cs.red() && Gru.cs.blue() > Gru.cs.green()) {
            pathOne = true;
            // more green than blue
        } else if (Gru.cs.green() > Gru.cs.red() && Gru.cs.green() > Gru.cs.blue()) {
            pathTwo = true;
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
    }
}