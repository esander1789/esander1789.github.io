translate([0, 0,-2]) cube([21,10,3]);
translate([0,10,-2]) cube([5,5,3]);
translate([8,10,-2]) cube([5,5,3]);
translate([16,10,-2]) cube([5,5,3]);
rotate([0,90,0]) cylinder(r=5,h=104,$fn=80);
rotate([0,90,0]) translate([0,0,80]) cylinder(r=7,h=2,$fn=80);
rotate([0,90,0]) translate([0,0,90]) cylinder(r=7,h=2,$fn=80);

difference(){
translate([122.5,0,-5]) scale([.75,1,1]) cylinder(r=30,h=10,$fn=80);
translate([122.5,0,-5]) scale([.75,1,1]) cylinder(r=20,h=10,$fn=80);
}