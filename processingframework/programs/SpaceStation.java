package processingframework.programs;

import processing.core.PApplet;
import processing.core.PImage;

public class SpaceStation {
    private PImage image;
    private PImage earthImage;
    private float rotationAngle;
    private float rotationSpeed; // Adjust the speed of rotation as needed
    private InfoBox infoBox;
    private InfoBox topLeftInfoBox;


    public SpaceStation(PImage image, float rotationAngle, float rotationSpeed) {
        this.image = image;
        this.earthImage = image;
        this.rotationAngle = rotationAngle;
        this.rotationSpeed = rotationSpeed;
        infoBox = new InfoBox(420, 130, 20);
        topLeftInfoBox = new InfoBox(400,500,40);
    }

    public void draw(PApplet applet) 
    {
        earthImage = applet.loadImage("Earth.png");
        float earthSize = 1000; 
        float earthCenterX = applet.width - earthSize / 2; 
        float earthCenterY = applet.height - earthSize / 2; 
        applet.image(earthImage, earthCenterX, earthCenterY, earthSize, earthSize);
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

        infoBox.drawLeftInfoBox(applet);
        String newInfoText = "Den Internationale Rumstation (ISS) er et samarbejde mellem flere rumagenturer, herunder NASA, Roscosmos, ESA, JAXA og CSA.\nDen har været kontinuerligt beboet siden november 2000, hvilket gør den over to årtier gammel.\nISS fungerer som platform for videnskabelig forskning i vægtløshed, hvilket muliggør undersøgelser inden for biologi, fysik, astronomi og materialevidenskab.\nMed sit internationale besætningshold og forskelligartede forskningsprogrammer symboliserer ISS menneskelig opfindsomhed, udforskning og samarbejde i rummet.\nDen kredser om Jorden i en gennemsnitlig højde på cirka 420 kilometer og rejser med en hastighed på cirka 28.000 kilometer i timen.\nISS repræsenterer en af de mest betydningsfulde bedrifter inden for rumforskning og fortsætter med at inspirere mennesker over hele verden.";        topLeftInfoBox.drawInfoBox(applet, newInfoText);
        topLeftInfoBox.drawInfoBox(applet, newInfoText);
    }
}