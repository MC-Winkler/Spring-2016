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
	 * The setup sets the initial size, adds smoothing (for pixelated lines) and
	 * noStroke, which takes out outlines of shapes. This method is called once
	 * - when the program starts.
	 */
	public void setup() {
		size(800, 800);
		smooth();
		noStroke();
	}

	/*
	 * The draw program is called many times a second. It draws shapes to the
	 * screen.
	 * 
	 * The art should still be correct when the window is resized.
	 */
	public void draw() {
		// Draw background first.
		background(255, 255, 255);
		// Draw the target
		drawTarget(width, height);
		// Draw the "dream catcher"
		drawDiamonds(width / 2, 0, width / 2, height / 2);
		// Draw the triangles
		drawTriangles(0, height / 2, width / 2, height / 2);
		// Draw whatever you want as long as its recursive.
		drawCustom(width/2, height/2, width/2, height/2);
	}

	public void drawTarget(float w, float h) {
		fill(255, 0, 0);
		ellipse(width / 4, height / 4, w / 2, h / 2);
		fill(0, 0, 255);
		ellipse(width / 4, height / 4, (w / 2) - 30, (h / 2) - 30);
		if (w > 120) {
			drawTarget(w - 120, h - 120);
		}
	}

	public void drawDiamonds(float upperLeftX, float upperLeftY, float width, float height) {
		fill(0, 0, 200, 100);
		rect(upperLeftX, upperLeftY, width, height);
		fill(255, 255, 255);
		quad(upperLeftX + width / 2, upperLeftY, upperLeftX + width, upperLeftY + height / 2, upperLeftX + width / 2,
				upperLeftY + height, upperLeftX, upperLeftY + height / 2);
		if (width > 10) {
			drawDiamonds(upperLeftX + width / 4, upperLeftY + height / 4, width / 2, height / 2);
		}
	}

	public void drawTriangles(float upperLeftX, float upperLeftY, float width, float height) {
		if (width > 5) {
			fill(255, 255, 0);
			triangle(upperLeftX, upperLeftY, upperLeftX, upperLeftY + height, upperLeftX + width, upperLeftY + height);
			fill(0, 0, 255);
			triangle(upperLeftX, upperLeftY, upperLeftX + width, upperLeftY, upperLeftX + width, upperLeftY + height);
			drawTriangles(upperLeftX, upperLeftY, width / 2, height / 2);
			drawTriangles(upperLeftX + width / 2, upperLeftY, width / 2, height / 2);
			drawTriangles(upperLeftX + width / 2, upperLeftY + height / 2, width / 2, height / 2);
		}
	}
	
	public void drawCustom(float upperLeftX, float upperLeftY, float width, float height) {
		if (width > 1){
			fill(255, 255, 255);
			rect(upperLeftX, upperLeftY, width, height);
			fill(255, 0, 0);
			rect(upperLeftX + (3*width)/4, upperLeftY, width/4, height/4);
			rect(upperLeftX, upperLeftY+(3*height/4), width/4, height/4);
			rect(upperLeftX + width/4, upperLeftY+width/4, width/4, height/4);
			rect(upperLeftX + width/2, upperLeftY + width/2, width/4, height/4);
			drawCustom(upperLeftX+(3*width)/4, upperLeftY, width/4, height/4);
			drawCustom(upperLeftX, upperLeftY +(3*height)/4, width/4, height/4);
		}
	}
}
