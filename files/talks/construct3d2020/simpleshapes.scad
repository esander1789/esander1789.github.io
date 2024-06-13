//Instructions: 
//1. a. Rotate (one finger) 
//   b. Zoom (two fingers) 
//   c. Preview (>>) 
//   d. Render (cube button) 
//   e. Save (File menu)
//   f. Export as STL (File menu)
//2. Change $fn to different numbers and preview. This controls the resolution of your shapes - very important for a high quality print. 
//3. Modify this code to make a sphere of radius 5.
//4. Move the cube close to the sphere so that they overlap.
//5. Make the cube have a height of 2.
//6. Change one radius of the cylinder to be 0. 
//7. Move the cylinder to the middle of the sphere.

$fn = 20;


sphere(r=10);

translate([15.5,0,-5]) 
cube([10,10,10]);

translate([0,16,-5]) 
cylinder(h=30,r1=4,r2=4);


