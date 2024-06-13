// This code creates iterated function systems by 
// using a CAD approach to transformations.
// Evelyn Sander, George Mason University, 2019. 

len = 50; 
hei = 1; 

module shape(){
linear_extrude(height=hei) circle(r=len, $fn = 3);
}



module rec(n) { 
    if (n>0){
        // Function 1 
        color([(n+1)/7,0.1,0.1,0.9])
        translate([.5*len,0*len,hei]) 
        rotate([0,0,12]) 
        scale([1/2,1/2,1])  
        rec(n-1);
        // Function 2
        color([0.1,(n+1)/7,0.1,.9])
        translate([-1/4*len,-.43*len,hei]) 
        rotate([0,0,-19]) 
        scale([1/2,1/2,1]) 
        rec(n-1);
        // Function 3
        color([0.1,0.1,(n+1)/7,.9])
        translate([-1/4*len,.43*len,hei]) 
        rotate([0,0,6]) 
        scale([1/2,1/2,1]) 
        rec(n-1);
    }
   
    else shape();
    };


rec(0);
rec(1);
rec(2);
rec(3);
rec(4);
rec(5);
