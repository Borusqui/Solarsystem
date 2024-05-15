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
    // private float x;
    // private float y;
    // private Planet planet;


public Moon(String name, float rotationTime, float planetDist, PImage moonImage, String description, Planet planet){
    this.name = name;
    this.rotationTime = rotationTime;
    this.planetDist =planetDist;
    this.image = moonImage;
    this.description = description;

    // this.planet = planet;
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

public void update(double timeElapsed) {
    // Calculate the angle of rotation based on the time elapsed and rotation time
    // float angle = (float) (2 * Math.PI * timeElapsed / rotationTime);
    // Calculate the x and y positions of the planet in its orbit around the sun
    // x = (float) (planetDist * Math.cos(angle));
    // y = (float) (planetDist * Math.sin(angle));
}

public void draw(PApplet applet, float planetX, float planetY, double timeElapsed) {
    PVector currentPosition = getCurrentPosition(timeElapsed);
    float drawX = planetX + currentPosition.x - image.width / 2;
    float drawY = planetY + currentPosition.y - image.height / 2;

    applet.image(image, drawX, drawY);
}
}
