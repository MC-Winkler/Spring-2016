package recursiveart;

import java.awt.*;

import processing.core.PApplet;
/*
 * Recursive Art
 * 
 * This program draws some pretty pictures
 * using recursion
 */

public class RecursiveArt extends PApplet {

	/*
	 * The setup sets the initial size, 
	 * adds smoothing (for pixelated lines)
	 * and noStroke, which takes out outlines of shapes.
	 * This method is called once - when the program starts.
	 */
	public void setup() {
		size(800,800);
		smooth();
		noStroke();
	}

	/*
	 * The draw program is called many times a second.
	 * It draws shapes to the screen.
	 * 
	 * The art should still be correct when the window is resized.
	 */
	public void draw() {
		// Draw background first.
		background(255,255,255);
		// Draw the target
		drawTarget(width, height);
		// Draw the "dream catcher"
		drawDiamonds(width/2, 0, width/2, height/2);
		// Draw the triangles
		
		// Draw whatever you want as long as its recursive.
	}
	
	public void drawTarget(float w, float h){
		fill(255,0,0);
		ellipse(width/4, height/4, w/2, h/2);
		fill(0,0,255);
		ellipse(width/4, height/4, (w/2)-30, (h/2)-30);
		if (w > 120){
			drawTarget(w-120, h-120);
		}
	}
	
	public void drawDiamonds (float upperLeftX, float upperLeftY, float width, float height){
		fill(0,0,200, 100);
		rect(upperLeftX, upperLeftY, width, height);
		fill(255,255,255);
		quad(upperLeftX+width/2, upperLeftY, upperLeftX + width, upperLeftY+height/2, 
				upperLeftX+width/2, upperLeftY+height, upperLeftX, upperLeftY+height/2);
		if (width > 10){
			drawDiamonds(upperLeftX+width/4, upperLeftY+height/4, width/2, height/2);
		}
	}
}


