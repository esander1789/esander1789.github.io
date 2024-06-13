include <mykey2.scad>;

mykey();
translate([-30,0,0]) rotate([180,0,180]) mykey();

translate([-35,0,0]) rotate([90,0,90]) cylinder(r=5, h = 50, $fn = 80);