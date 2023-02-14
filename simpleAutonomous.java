package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Destiny Hale 2022
 */

@Autonomous(name= "Park", group= "Linear Opmode")

public class simpleAutonomous extends LinearOpMode {
    // Establish Universal Variables

    Hardware Gru = new Hardware();
    // ElapsedTime runtime = new ElapsedTime();

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

        // Autonomous Strafe to alliance station
        Gru.autoStrafe(-.3,3000);

       // Drive backwards to straighten up
        Gru.driveStraight(.4,2000);
    }
}