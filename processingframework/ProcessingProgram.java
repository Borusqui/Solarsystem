package processingframework;

import processing.core.PApplet;

public interface ProcessingProgram
{
	void setup(PApplet applet);
	void update(PApplet applet, double seconds, float scaledMouseX, float scaledMouseY);
	void draw(PApplet applet, float zoomFactor, float panX, float panY);
	void returnToMenu(PApplet applet);
}
