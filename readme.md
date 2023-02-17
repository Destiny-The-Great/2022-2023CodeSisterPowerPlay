## TeamCode Module
Howdy & Welcome to to the Code Sisters 2022 - 2023 Read MD for the season. Below is an explanation of the
challenge of this year and some explanations for highlights in our code. This is mostly meant to
document it for future members that are looking at past code for guidance. I hope its useful.
~ Destiny Hale (Class 0f 2023)



## Intro to Challenge
In the year of 2021-2022 the challenge was called Power Play. Robots needed to be able to pick up
and stack cones on junctions. 

The most complex task in autonomous was that robot could gain 20 points for being able to read a 
signal sleeve (a cone with images on it) to determine where to park.

Something to note about this year, is that the crunch time was very crazy. Builders were still 
fixing major apparatuses the night before competition, and the code reflects that. You will see 
multiple examples of various complex autonomouses that were made but never fully tested and perfected.
Just something note as you read through.

## Major Tele-op changes
The most major addition was implementation of focus mode. The robot moves extra slow when the driver
adds holds the X button. This is to make it easier to for the driver to make finer movements without
sacrificing speed for the entire match. When X is released the robot returns to normal speed.

Our drive code also received minor edits again this year. The name's for variables were swapped to make the code's
math more intuitive this year. We also added a suggestion from game 0 manual. You'll notice in the
drive code math it's divided by a denominator. This is supposed to keep the code in a certain range
that prevents the ratios of wheel speeds from getting messed up.

## Autonomous
Note there were many iterations of many programs made in a short period of time. This year I also
went through the effort to have 4 programs per autonomous, so that the robot could start at any side.
For simplicity, I have retained only 3 programs to show the main idea of each program.

Simple Autonomous
This is tried and trued. Simply allowed the robot to either park in the alliance station or 
substation. A cone was 'preloaded' to the robot's side so it could push it and score it.\

Scan & Park Autonomous
This was never heavily tested. Robot was to drive forward to read the signal sleeve with a color sensor
and then park in the correct zone.

Stack & Scan Autonomous
The first half of this program (stacking a cone) was tested, but the 2nd half was not. The robot
lifts a preloaded cone up and drive in front of medium junction and stacks. (Next is untested stuff).
Then the robot was to scan the signal sleeve and park.


## Notable elements for the autonomous
For the Autonomous a few simple methods handled all of Gru's movements; most of them are fairly
self explanatory. 

There are methods for use of a motor powered linear slide and servo powered claw. If you're coding
anything like that you may want to look at it.

## Experimental code
The most interesting and complex code is easily the autonomous code focused on color sensor. The 
robot turns on LED light and reads an image. It tries to determine if there is more green, blue, or
red in the image. Then depending on what one it sees it sets a boolean variable for path 1, 2, or 3
true. Then it will go park on a set path based on the variable that was set to true.


I usually put methods in the hardware map, but I couldn't do this for the CS due to scope issues.
Basically, for the robot to acknowledge the path variables it needs to be in the same class. So if 
you want to use a method that returns a variable for the robot to interact with you may run into a 
similar issue.