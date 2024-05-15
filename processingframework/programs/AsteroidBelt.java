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

    public void draw(PApplet applet) {
        applet.pushMatrix(); // Save the current transformation matrix
        applet.translate(applet.width / 2, applet.height / 2); // Translate to the center of the screen
        applet.rotate(rotationAngle); // Rotate by the current rotation angle
        applet.image(image, -image.width / 2, -image.height / 2); // Draw the image centered
        applet.popMatrix(); // Restore the original transformation matrix

        // Increase the rotation angle
        rotationAngle += rotationSpeed;

        // Ensure the rotation angle stays within 0 to 2*PI
        if (rotationAngle > PApplet.TWO_PI) {
            rotationAngle -= PApplet.TWO_PI;
        }
    }
}