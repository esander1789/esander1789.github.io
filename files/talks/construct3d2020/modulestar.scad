// Module Star Instructions 
// A module helps you to make copies. 
// After looking at this code:  
// 1 Uncomment the second copy of myshape to make a star. Now comment it again. 
// 2. Change the value of $fn in the module to make a square shape  
// 3. Use your square shape plus two rotated copies (the first rotated by 60 degrees and the second rotated by  120 degrees) to make a 12 sided star 

module myshape()
{
cylinder(r = 20, h = 10, $fn = 3);
}


myshape();

// This is a second copy of myshape, but this one is rotated
// rotate(60) myshape();


