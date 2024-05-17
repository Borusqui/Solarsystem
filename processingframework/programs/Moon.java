package processingframework.programs;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Moon{
    private String name;
    private float rotationTime;
    private float planetDist;
    private PImage image;
    private String description;


public Moon(String name, float rotationTime, float planetDist, PImage moonImage, String description, Planet planet){
    this.name = name;
    this.rotationTime = rotationTime;
    this.planetDist =planetDist;
    this.image = moonImage;
    this.description = description;
}

	public String getDescription(){
		return description;
	}

public PVector getCurrentPosition(double timeElapsed) {
    float angle = (float) (2 * Math.PI * timeElapsed / rotationTime);
    float currentX = (float) (planetDist * Math.cos(angle));
    float currentY = (float) (planetDist * Math.sin(angle));
    return new PVector(currentX, currentY);
}

public String getName(){
    return name;
}

public float getPlanetDist() {
    return planetDist;
}

public void draw(PApplet applet, float planetX, float planetY, double timeElapsed) {
    PVector currentPosition = getCurrentPosition(timeElapsed);
    float drawX = planetX + currentPosition.x - image.width / 2;
    float drawY = planetY + currentPosition.y - image.height / 2;
    applet.image(image, drawX, drawY);
}
}
