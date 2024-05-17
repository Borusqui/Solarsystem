package processingframework.programs;

import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Planet {
    private String name;
    float x;
    private float y;
    private float radius;
    private float sunDist; // In million years / 10
    private float rotationTime; // In Earth days / 10
    private PImage image;
	private String description;
	private boolean isHovered = false;
    private boolean isClicked = false;
	private int numMoons;
	private float planetTemperature;
    private float minTemp;
    private float maxTemp;
    private float gravity;
    private List<Moon> moons;
    private String description1;

    public Planet(String name, float radius, float sunDist, float rotationTime, int numMoons, float minTemp, float maxTemp, float gravity, String description, String description1, PImage image) {
        this.name = name;
        this.radius = radius;
        this.sunDist = sunDist;
        this.rotationTime = rotationTime;
        this.image = image;
		this.description = description;
        this.numMoons = numMoons;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.gravity = gravity;	
        this.moons = new ArrayList<>();
        this.description1 = description1;
    }

    public PVector getCurrentPosition(double timeElapsed) {
        float angle = (float) (2 * Math.PI * timeElapsed / rotationTime);
        float currentX = (float) (sunDist * Math.cos(angle));
        float currentY = (float) (sunDist * Math.sin(angle));
        return new PVector(currentX, currentY);
    }

    public void addMoon(String moonName, float moonRotationTime, float moonPlanetDist, PImage moonImage, String moonDescription) {
        Moon moon = new Moon(moonName, moonRotationTime, moonPlanetDist, moonImage, moonDescription, this);
        moons.add(moon);
    }

    public List<Moon> getMoons() {
        return moons;
    }

    public float getGravity(){
        return gravity;
    }

    public float getMinTemperature(){
        return minTemp;
    }

    public float getMaxTemperature(){
        return maxTemp;
    }

    public float getRadius() {
        return radius;
    }

    public String getName() {
        return name;
    }

    public float getSunDist() {
        return sunDist;
    }

	public String getDescription(){
		return description;
	}
    
    public String getDescription1(){
		return description1;
	}

	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x; 
	}
	
	public float getY() {
		return y; 
	}
	
	public PImage getImage() {
        return image;
    }

	public boolean isHovered() {
        return isHovered;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setHovered(boolean hovered) {
        isHovered = hovered;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

	public float getRotationTime(){
		return rotationTime;
	}

	public int getNumMoons(){
		return numMoons;
	}

	public float getTemperature(){
		return planetTemperature;
	}
	
    public void update(double timeElapsed) {
        // Calculate the angle of rotation based on the time elapsed and rotation time
        float angle = (float) (2 * Math.PI * timeElapsed / rotationTime);
        // Calculate the x and y positions of the planet in its orbit around the sun
        x = (float) (sunDist * Math.cos(angle));
        y = (float) (sunDist * Math.sin(angle));
    }
    

    public void draw(PApplet applet, float sunX, float sunY, double timeElapsed) {
        PVector currentPosition = getCurrentPosition(timeElapsed);
		float drawX = sunX + currentPosition.x - image.width / 2;
        float drawY = sunY + currentPosition.y - image.height / 2;

        // Hover
		if (applet.mouseX >= drawX && applet.mouseX <= drawX + image.width &&
		applet.mouseY >= drawY && applet.mouseY <= drawY + image.height) {

         	// Perform hover action
            applet.tint(255, 100); 
            applet.fill(255);
            applet.textAlign(PApplet.RIGHT, PApplet.TOP);
            applet.text(name, drawX + image.width + 25, drawY);
			setHovered(true); 
        	} 
		
			else {
            applet.noTint();
        	}

        applet.image(image, drawX, drawY);

		// DEBUGGING
	// System.out.println("Planet: " + name);
    // System.out.println("drawX: " + drawX + ", drawY: " + drawY);
    // System.out.println("MouseX: " + applet.mouseX + ", MouseY: " + applet.mouseY);
    }
}
