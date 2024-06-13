//Intersection is a useful way to combine two shapes. 
//Scale makes and object bigger or smaller.
// 1. Change the scale amount to be larger or smaller. Which number corresponds to the original size? 
// 2. Combine translations with different scale amounts to put a second dome on top of this (like on the U.S. Capitol Building). 



scale(1.5)
intersection(){
    sphere(r=10);
    cylinder(r=9,h=10);
}

