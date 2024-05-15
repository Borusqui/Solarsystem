package processingframework.programs;

import processing.core.PApplet;
import processing.core.PImage;

public class Sun {
    private String name;
    private float radius;
    private float temperature;
    private int yearsExist;
    private int yearsLeft;
    private PImage image;
    private String description;
    private float x;
    private float y;

    // Constructor
    public Sun(PApplet applet, String name, float radius, float temperature, double d, int yearsLeft, PImage image, String description) {
        this.name = name;
        this.radius = radius;
        this.temperature = temperature;
        this.yearsExist = (int) yearsExist;
        this.yearsLeft = yearsLeft;
        this.image = image;
        this.description = description;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public float getRadius() {
        return radius;
    }

    public float getTemperature() {
        return temperature;
    }

    public int getYearsExist() {
        return yearsExist;
    }

    public int getYearsLeft() {
        return yearsLeft;
    }
    public String getDescription() {
        return description;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void draw(PApplet applet, float x, float y) {
        image = applet.loadImage("Sun.png");
        image.resize(100, 100); // Optionally resize the image
        float drawX = x - image.width / 2;
        float drawY = y - image.height / 2;

        applet.image(image, drawX, drawY);
        // Hover check
        if (applet.mouseX >= x - image.width / 2 && applet.mouseX <= x + image.width / 2 &&
                applet.mouseY >= y - image.height / 2 && applet.mouseY <= y + image.height / 2) {
            applet.tint(255, 100); // Apply a semi-transparent tint to the image
    
            // Display the planet's name at the top right corner of the image
            applet.fill(255); // Set text color to white
            applet.textAlign(PApplet.RIGHT, PApplet.TOP); // Align text to top right corner
            applet.text(name, x + image.width, y); // Display the planet's name
        
        } else {
            // Reset image tint
            applet.noTint();
        }
    }
}
