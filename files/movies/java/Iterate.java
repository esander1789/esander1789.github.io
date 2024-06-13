import java.applet.*;
import java.awt.*;
import PackerLayout;
import Slider;

public class Iterate extends Applet implements Runnable {
  Thread me;
  int rb,x1,y1;
  double a=0.0;
  boolean draw_rect = true;
  Button b;
  TextField t;
  Panel p;
  ECanvas ca;
  PCanvas cae;
  ESlider sc;

  public void init(){
    me = null;
    rb = 0;

    
    add( p=new Panel());
    p.setLayout(new PackerLayout());    
    p.add("button5;fill=x", cae=new PCanvas(a));
    p.add("button3;fill=y;side=right", sc=new ESlider(Scrollbar.VERTICAL,250,500,0,500));
    p.add("button4;fill=both;expand=true", ca=new ECanvas(a,draw_rect));
    add(p);
  }

  public void start() {
    System.out.println("start");
    showStatus("Applet Started Diagnostic");
    if (me == null) {
      me = new Thread(this);
      me.start();
    }
    p.resize(size().width, size().height);
    p.show();

  }
  
  public void stop() {
    System.out.println("stop");
    showStatus("Applet Stopped Diagnostic");
    if (me != null) {
      me.stop();
      me = null;
    }
    p.hide();

  }

  public void run() {
    System.out.println("run");
/*    try {
      while (true) {
	rb += 1;
	if (rb > 100) rb = 0;
	ca.repaint();
	Thread.sleep(100);
      }
    } catch (Exception e) {}
*/
  }

  public boolean handleEvent(Event e) {
    double tmp;

    if (e.target== b){
      a= Double.valueOf(t.getText()).doubleValue();
      ca.seta(a);
    }
    if (e.target== sc){
      a= (double)(250- sc.getValue()) /50;
      ca.seta(a);
      cae.seta(a);
    }
    
      
  
  return false;
  }

}

class ESlider extends Scrollbar{
   ESlider(int orientation, int value, int visible, int minimum, int maximum){
     
        setValues(value, visible, minimum, maximum);
  
   }
}


class PCanvas extends Canvas {
  double a,a1;
  Font font;

  PCanvas(double ea){
    resize(200,50);
    a=ea;
    repaint();
  }

  public void seta(double ea){
    a=ea;
    repaint();
  }

  public void paint(Graphics g) {
    font = new Font("TimesRoman", Font.PLAIN, 18);
    g.setFont(font);
    g.drawRect(0,0,size().width-1,size().height-1);
    if (a<0){
       a1=-a;
       g.drawString("y=x^2-"+a1,20,30);
    }
    else{
       g.drawString("y=x^2+"+a,20,30);
    }
  }

}

class ECanvas extends Canvas {
  double a, wx1=-5.0, wx2=5.0, wy1=-5.0, wy2=5.0;
  int x1=150,x2=150,y1,y2;
  boolean draw_rect;

  ECanvas(double ea,  boolean edraw_rect){
    resize(300,300);
    a=ea;
    draw_rect=edraw_rect;
  }  


  public void seta(double ea){
    a=ea;
    repaint();
  }

  public void setxy( int ex, int ey){
    x1=ex;
    y1=ey;
    draw_rect=true;
    repaint();
  }


  public boolean handleEvent(Event e){
     
     switch (e.id){
      case Event.MOUSE_DOWN:
        draw_rect=true;
        x1=e.x;
        y1=e.y;
        repaint();
        return true;
      default:
        return false;
    }

  }

  public void paint(Graphics g) {
    double delx = (wx2 - wx1)/20;
    double tmpx,tmpy, atmpx,atmpy;
    int px,py,oldx,oldy, apx, apy,aoldx,aoldy;
    resize(300,300);

    g.drawRect(0,0,298,298);
    oldx = world_to_scrx(wx1);
    oldy = world_to_scry(f2(wx1,a));
    g.drawLine(world_to_scrx(wx1),world_to_scry(wx1),world_to_scrx(wx2),world_to_scry(wx2));

    for (int i = 1; i < 20; i++){
      tmpx = wx1 + i * delx;
      px = world_to_scrx(tmpx);
      py = world_to_scry(f2(tmpx,a));
      g.drawLine(oldx, oldy, px, py);
      oldx = px;
      oldy = py;
    }

    if(draw_rect) {
      tmpx=scrx_to_world(x1);
      tmpy=f2(tmpx,a);
      atmpx=tmpx;
      atmpy=tmpy;
      g.setColor(Color.red);
      for(int i=1;i<200;i++){
         px = world_to_scrx(tmpx);
         oldx=world_to_scrx(tmpy);
         oldy=world_to_scry(tmpx);
         py = world_to_scry(tmpy);
         g.drawLine(px, oldy, px, py);
         g.drawLine(px, py, oldx, py); 		
         tmpx=tmpy;
         tmpy=f2(tmpx,a);
      }
      

    }
  }




  double f2(double x, double a){
    return x*x+a;
  }

  double scry_to_world(int y) {
    return wy2 - (((double)y / 300.0) * (wy2 - wy1));
  }

  double scrx_to_world(int x) {
    return wx1 + (((double)x / 300.0) * (wx2 - wx1));
  }

  int world_to_scrx(double x) {
    return (int)(((x - wx1) / (wx2 - wx1)) * 300);
  }

  int world_to_scry(double y) {
    return (int)(((wy2 - y) / (wy2 - wy1)) * 300);
  }
 
}












