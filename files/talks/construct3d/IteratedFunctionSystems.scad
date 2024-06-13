// We create fractals! Modify the numbers below to change the final look. 

// Here we make the size and shape
levels = 4; // number of levels for the recursion. Keep this number at 5 or below or you will WAIT!
height  = 1.0; // height of the first layer
len = 50; // length of the first segment
si = 3; // number of sides to the polygon of the starting shape

module shape(length,height,sides){
    linear_extrude(height=height) circle(r=len,$fn=sides);
}

//shape(len,height,si); //Run this to see the starting shape
ifuns(len, si, levels); //This makes the whole fractal


// Modify these numbers to change the fractal

//-------------------------------------------------------------
// The first transformation
scale1x = 0.5;  // Scaling in direction x
scale1y = 0.5;  // Scaling in direction y
theta1  = 11;   // Angle of rotation in degrees
tran1x = -0.25; // Translation in direction x
tran1y = -0.4;  // Translation in direction y
//-------------------------------------------------------------
// The second transformation
scale2x = 0.5;  // Scaling in direction x
scale2y = 0.45; // Scaling in direction y
theta2 =  3;    // Angle of rotation in degrees
tran2x = 0.5;   // Translation in direction x
tran2y = 0;     // Translation in direction y
//-------------------------------------------------------------
// The third transformation
scale3x = 0.5;  // Scaling in direction x
scale3y = 0.53; // Scaling in direction y
theta3 =  -14;  // Angle of rotation in degrees
tran3x = -0.25; // Translation in direction x
tran3y = 0.43;  // Translation in direction y
//-------------------------------------------------------------
//-------------------------------------------------------------
//-------------------------------------------------------------
// Usually you don't have to read any further
//-------------------------------------------------------------
//-------------------------------------------------------------
//-------------------------------------------------------------


// the identity matrix
identity = [ [ 1, 0, 0, 0 ], [ 0, 1, 0, 0 ], [ 0, 0, 1, 0 ], [ 0, 0, 0, 1 ] ];

// generate 4x4 scaling matrix
function ms(x, y) = [ [ x, 0, 0, 0 ], [ 0, y, 0, 0 ], [ 0, 0, 1, 0 ], [ 0, 0, 0, 1 ] ];

// generate 4x4 translation matrix
function mt(x, y) = [ [ 1, 0, 0, x ], [ 0, 1, 0, y ], [ 0, 0, 1, height ], [ 0, 0, 0, 1 ] ];

// generate 4x4 rotation matrix around Z axis
function mr(a) = [ [ cos(a), -sin(a), 0, 0 ], [ sin(a), cos(a), 0, 0 ], [ 0, 0, 1, 0 ], [ 0, 0, 0, 1 ] ];

// Put all translations in terms of absolute rather than relative units
trans1x = tran1x*len; 
trans1y = tran1y*len; 
trans2x = tran2x*len; 
trans2y = tran2y*len; 
trans3x = tran3x*len; 
trans3y = tran3y*len; 


module ifuns(length,sides, count, m = identity) {
        color([0, 1 - (0.7 / levels * count), 0])
            multmatrix(m)
                shape(length,height=height,sides=sides);
    if (count > 0) {
        ifuns( length, sides, count - 1, m * mt(trans1x, trans1y) * mr(theta1)*ms(scale1x,scale1y));
        ifuns( length, sides, count - 1, m * mt(trans2x, trans2y) * mr(theta2)*ms(scale2x,scale2y));
        ifuns( length, sides, count - 1, m * mt(trans3x, trans3y) * mr(theta3)*ms(scale3x,scale3y));
    }
}

echo(version=version());
// You are welcome to use this code for non-commercial purposes. If you do so, 
// please send me an email and let me know how it goes!
// Evelyn Sander, esander@gmu.edu, GMU, 2016-17
// Based on the ideas of Jim Kelly, Centre College
// Based on code written in 2015 by Torsten Paul <Torsten.Paul@gmx.de>

