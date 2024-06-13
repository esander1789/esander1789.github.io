// Heart Puzzle Instructions
// Use these pieces to make piece in the shape of a heart. 

cube([10,10,10]);

translate([5,-10,0]) 
cylinder(h=10,r1=5,r2=5);

translate([-10,5,0]) 
cylinder(h=10,r1=5,r2=5);