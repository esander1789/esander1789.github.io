/*
 * @(#)Slider.java    0.90 11/15/95 Adam Doppelt
 */


import java.awt.*;

/**
 * A Slider is a widget that varies between a minimum and a maximum
 * value. The user can drag a "thumb" to change the current value. As
 * the slider is dragged, Motion() is called. When the slider is
 * released, Release() is called. Override these two methods to give
 * the slider behavior.
 *
 * @version 0.90 15 Nov 1995
 * @author <A HREF="http://www.cs.brown.edu/people/amd/">Adam Doppelt</A> */
public class Slider extends Canvas {
    private final static int THUMB_SIZE = 14;
    private final static int BUFFER = 2;

    private final static int TEXT_HEIGHT = 18;
    private final static int TEXT_BUFFER = 3;
    
    private final static int DEFAULT_WIDTH = 100;
    private final static int DEFAULT_HEIGHT = 15;

    private final static int MIN_WIDTH = 2 * (THUMB_SIZE + BUFFER + 1);
    private final static int MIN_HEIGHT = 2 * (BUFFER + 1);

    private final static int DEFAULT_MIN = 1;
    private final static int DEFAULT_MAX = 100;    
    
    int min_, max_, value_, pixel_;
    int pixelMin_, pixelMax_;
    Color backgroundColor_, thumbColor_, barColor_, slashColor_, textColor_;
    Font font_;
    
/**
 * Constructs a slider.
 * @param container The container for this slider.
 */
    public Slider () {
	min_ = DEFAULT_MIN;
	max_ = DEFAULT_MAX;
	resize(DEFAULT_WIDTH, DEFAULT_HEIGHT + TEXT_HEIGHT);
	font_ = new Font("TimesRoman", Font.PLAIN, 12);
	backgroundColor_ = Color.lightGray;
	thumbColor_ = Color.lightGray;
	barColor_ = Color.lightGray.darker();
	slashColor_ = Color.black;
	textColor_ = Color.black;
	SetValue(1);
    }

/**
 * This method is called when the "thumb" of the slider is dragged by
 * the user. Must be overridden to give the slider some behavior.
 *   */
    public void Motion () { ; }

/**
 * This method is called when the "thumb" of the slider is released
 * after being dragged. Must be overridden to give the slider some
 * behavior.
 *   */
    public void Release () { ; }
    
/**
 * Sets the maximum value for the slider.
 * @param num The new maximum.
 */
    public void SetMaximum (int num) {
	max_ = num;
	if (max_ < min_) {
	    int t = min_;
	    min_ = max_;
	    max_ = t;
	}
	SetValue(value_);
    }
    
/**
 * Sets the minimum value for the slider.
 * @param num The new minimum.
 */
    public void SetMinimum (int num) {
	min_ = num;
	if (max_ < min_) {
	    int t = min_;
	    min_ = max_;
	    max_ = t;
	}
	SetValue(value_);
    }
    
/**
 * Sets the current value for the slider. The thumb will move to
 * reflect the new setting.
 * @param num The new setting for the slider.
 *   */
    public void SetValue (int num) {
	value_ = num;
	
	if (value_ < min_)
	    value_ = min_;
	else if (value_ > max_)
	    value_ = max_;
	
	if (value_ != min_)
	    pixel_ = (int)(Math.round(Math.abs((double)(value_ - min_) /
					       (double)(max_ - min_)) *
				      (double)(pixelMax_ - pixelMin_)) +
			   pixelMin_);
	else
	    pixel_ = pixelMin_;

	repaint();
    }
    
/**
 * Sets the height of the slider. This is the height of the entire
 * slider canvas, including space reserved for displaying the
 * current value.
 * @param num The new height.
 *   */
    public void SetHeight (int num) {
	if (num < MIN_HEIGHT + TEXT_HEIGHT)
	    num = MIN_HEIGHT + TEXT_HEIGHT;
	resize(size().width, num);
	repaint();
    }
    
/**
 * Sets the width of the slider. This is the width of the actual
 * slider box.
 * @param num The new width.
 *   */
    public void SetWidth (int num) {
	if (num < MIN_WIDTH)
	    num = MIN_WIDTH;
	resize(num, size().height);
	repaint();	
    }
    
/**
 * Returns the current value for the slider.
 * @return The current value for the slider.
 */
    public int GetValue () {
	return value_;
    }

/**
 * Sets the background color for the slider. The "background" is the
 * area outside of the bar.
 * @param color The new background color.
 */
    public void SetBackgroundColor(Color color) {
	backgroundColor_ = color;
	repaint();
    }

/**
 * Sets the color for the slider's thumb. The "thumb" is the box that
 * the user can slide back and forth.
 * @param color The new thumb color.
 */
    public void SetThumbColor(Color color) {
	thumbColor_ = color;
	repaint();
    }

/**
 * Sets the color for the slider's bar. The "bar" is the rectangle
 * that the thumb slides around in.
 * @param color The new bar color.
 */
    public void SetBarColor (Color color) {
	barColor_ = color;
	repaint();
    }

/**
 * Sets the slash color for the slider. The "slash" is the little
 * vertical line on the thumb.
 * @param color The new slash color.
 */
    public void SetSlashColor(Color color) {
	slashColor_ = color;
	repaint();
    }

/**
 * Sets the color for the slider`s text.
 * @param color The new text color.
 */
    public void SetTextColor(Color color) {
	textColor_ = color;
	repaint();
    }

/**
 * Sets the font for the slider`s text.
 * @param font The new font.
 */
    public void SetFont(Font font) {
	font_ = font;
	repaint();
    }
    
/**
 * An internal method used to handle repaint events.
 */
    public void paint(Graphics g) {
	int width = size().width;	
	int height = size().height;

	g.setColor(backgroundColor_);
	g.fillRect(0, 0, width, TEXT_HEIGHT);

	g.setColor(barColor_);
	g.fill3DRect(0, TEXT_HEIGHT,
		     width, height - TEXT_HEIGHT, false);

	g.setColor(thumbColor_);	
	g.fill3DRect(pixel_ - THUMB_SIZE, TEXT_HEIGHT + BUFFER,
		     THUMB_SIZE * 2 + 1, height - 2 * BUFFER - TEXT_HEIGHT,
		     true);
	
	g.setColor(slashColor_);
	g.drawLine(pixel_, TEXT_HEIGHT + BUFFER + 1,
		   pixel_, height - 2 * BUFFER);

	g.setColor(textColor_);
	g.setFont(font_);		
	String str = String.valueOf(value_);
	g.drawString(str, pixel_ -
		     (int)(getFontMetrics(font_).stringWidth(str) / 2),
		     TEXT_HEIGHT - TEXT_BUFFER);
    }

    void HandleMouse(int x) {
	double percent;
	int width = size().width;
	pixel_ = Math.max(x, pixelMin_);
	pixel_ = Math.min(pixel_, pixelMax_);

	if (pixel_ != pixelMin_)
	    percent = (((double)pixel_ - pixelMin_) /
		       (pixelMax_ - pixelMin_));
	else
	    percent = 0;
	
	value_ = (int)(Math.round(percent * (double)(max_ - min_))) + min_;
	
	paint(getGraphics());
    }
    
/**
 * An internal method used to handle mouse down events.
 */
    public boolean mouseDown (Event e, int x, int y) {
	HandleMouse(x);
	Motion();
	return true;
    }

/**
 * An internal method used to handle mouse drag events.
 */
    public boolean mouseDrag (Event e, int x, int y) {
	HandleMouse(x);
	Motion();	
	return true;
    }

/**
 * An internal method used to handle mouse up events.
 */
    public boolean mouseUp (Event e, int x, int y) {
	HandleMouse(x);
	Release();
	return true;
    }

/**
 * An internal method used to handle resizing.
 */
    public void reshape(int x, int y, int width, int height) {
	super.reshape(x, y, width, height);
	pixelMin_ = THUMB_SIZE + BUFFER;
	pixelMax_ = width - THUMB_SIZE - BUFFER - 1;
	if (value_ != min_)
	    pixel_ = (int)(Math.round(Math.abs((double)(value_ - min_) /
					       (double)(max_ - min_)) *
				      (double)(pixelMax_ - pixelMin_)) +
			   pixelMin_);
	else
	    pixel_ = pixelMin_;
    }
    
}

