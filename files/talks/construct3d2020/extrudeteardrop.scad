
// Extrude Teardrop Instructions 
//You can make 3D objects from 2D ones, sort of like with a Playdoe extruder.
// 1. Replace the circle command with the square command.
// 2. Show both the circle and the square at the same time. What shape is being extruded? 
// 3. Change the twist from 360 to 180. Now figure out how to make it twist twice around. 



$fn = 100;

linear_extrude(height = 120, twist=360) translate([0,20,0]) circle(15);

