package processingframework.programs;

import processing.core.PApplet;
import processing.core.PImage;

public class AsteroidBelt {
    private PImage image;
    private float rotationAngle;
    private float rotationSpeed; // Adjust the speed of rotation as needed


    public AsteroidBelt(PImage image, float rotationAngle, float rotationSpeed) {
        this.image = image;
        this.rotationAngle = rotationAngle;
        this.rotationSpeed = rotationSpeed;
    }

    public void draw(PApplet applet) 
    {
        applet.pushMatrix(); 
        applet.translate(applet.width / 2, applet.height / 2); 
        applet.rotate(rotationAngle); 
        applet.image(image, -image.width / 2, -image.height / 2); 
        applet.popMatrix(); 

        rotationAngle += rotationSpeed;

        
        if (rotationAngle > PApplet.TWO_PI) 
        {
            rotationAngle -= PApplet.TWO_PI;
        }
    }
}