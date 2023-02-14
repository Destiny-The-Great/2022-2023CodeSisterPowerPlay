package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.ColorSensor;
/**
 * Created by Destiny Hale 2022
 */

@TeleOp (name = "Gruzoom", group= "Linear Opmode")
public class TeleOpTeam extends LinearOpMode {

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

        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {

            //defines driving mapping controls
            double turn = -gamepad1.left_stick_y;
            double fwdBack = gamepad1.left_stick_x;
            double strafe = gamepad1.right_stick_x *1.1;

            //This is supposed to keep ratio for driving math consistent.
            double denominator = Math.max(Math.abs(fwdBack) + Math.abs(strafe) + Math.abs(turn), 1);

            //Lift Control

            if (gamepad1.right_bumper) {
                Gru.lift.setPower(-.7);
            } else if (gamepad1.left_bumper){
                Gru.lift.setPower(.42);
            } else {
                Gru.lift.setPower(0);
            }

            //variables for claw
            double closeS = 1;
            double openS = 0;

            // claw controls
            if (gamepad1.a) {
                Gru.claw.setPosition(openS);
            } else if (gamepad1.b) {
                Gru.claw.setPosition(closeS);
            }

            // If If X is held Slow Down
            if (gamepad1.x) {
                Gru.leftFront.setPower(.2 * (fwdBack + turn + strafe) / denominator);
                Gru.leftBack.setPower(.2 * (-fwdBack - turn + strafe) / denominator);
                Gru.rightFront.setPower(.2 * (fwdBack - turn - strafe) / denominator);
                Gru.rightBack.setPower(.2 * (-fwdBack + turn - strafe) / denominator);

                // Otherwise Drive normally
            } else {

                Gru.leftFront.setPower(.45 * (fwdBack + turn + strafe) / denominator);
                Gru.leftBack.setPower(.45 * (-fwdBack - turn + strafe) / denominator);
                Gru.rightFront.setPower(.45 * (fwdBack - turn - strafe) / denominator);
                Gru.rightBack.setPower(.45 * (-fwdBack + turn - strafe) / denominator);
            }
        }
    }
}




