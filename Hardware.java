package org.firstinspires.ftc.teamcode;

import android.hardware.Sensor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;
/**
 * Created by Destiny Hale 2022
 */

//Define elements of robot

public class Hardware {

    //Wheels
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    // Other Motors
    public DcMotor lift;
    // Servos
    public Servo claw;
    // Sensors
    public ColorSensor cs;


    //---------------------------------INIT--ROBOT---------------------------------------------------
   /*  This method allows us to initialize the motors and sensors only once.
       It is used in every other program after "Init" is pressed.
    */

    public void initializeRobot(HardwareMap hwMap) {
        HardwareMap HWMap = hwMap;

        //initialize Wheel motors

        leftFront = HWMap.dcMotor.get("leftFront");
        leftBack = HWMap.dcMotor.get("leftBack");
        rightFront = HWMap.dcMotor.get("rightFront");
        rightBack = HWMap.dcMotor.get("rightBack");

        //initialize other
        claw = HWMap.servo.get("claw");
        lift = HWMap.dcMotor.get("lift");

        //initialize Sensors
        cs = HWMap.colorSensor.get("Azzy");


    }

//--------------------------Autonomous Driving Methods-------------------------------------------------------

    /*  Below are methods used to move Gru's wheels during autonomous
     */
//Drives Forwards and Backwards
    public void driveStraight(double power, int time) throws InterruptedException {
        //set wheels to a power for a set amount of seconds
        leftFront.setPower(-power);
        leftBack.setPower(power);
        rightFront.setPower(power);
        rightBack.setPower(-power);
        ;
        Thread.sleep(time);

        //then Stop
        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);

        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void turnLeftA(double power, int time) throws InterruptedException {
        //set all wheels to given power for a given amount of seconds
        rightFront.setPower(power);
        leftFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);
        Thread.sleep(time);
    }

    public void autoStrafe(double power, int time) throws InterruptedException {
        //set front wheels to a power and back to opposite of power for some time
        leftFront.setPower(power);
        leftBack.setPower(power);
        rightFront.setPower(-power);
        rightBack.setPower(-power);
        Thread.sleep(time);
    }

    //Used to completely stop wheels
    public void waitA(int time) throws InterruptedException {
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
        Thread.sleep(time);
    }
    //--------------------------Autonomous Apparatus Methods-------------------------------------------------------

    /*  Below are all of methods used to move non-wheel parts of Vector.
     */
    public void useLift(double power, int time) throws InterruptedException {
        lift.setPower(power);
        Thread.sleep(time);
        lift.setPower(0);
    }

    public void useClaw(boolean open, boolean closed) throws InterruptedException {
        double closeS = 1;
        double openS = 0;
        if (open) {
            claw.setPosition(openS);
        } else if (closed) {
            claw.setPosition(closeS);
        } else {

        }
            }
                }