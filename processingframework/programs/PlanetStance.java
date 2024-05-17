package processingframework.programs;

import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;

public class PlanetStance {
    private Program2 program;
    protected PApplet applet;
    protected PImage planetImage;
    private PImage moonImage;
    // private boolean animationPaused;
    private boolean planetActive = false;
    protected Planet planet;
    private boolean isSetupDone = false;
    private Moon moon;
    private MoonStance moonStance;

    public PlanetStance(PApplet applet, PImage planetImage, Planet planet, boolean animationPaused, Program2 program) {
        this.applet = applet;
        this.planetImage = planetImage;
        this.planet = planet;
        // this.animationPaused = animationPaused;
        this.program = program;
        
    }

    public boolean planetActive(){
        return planetActive;
    }

    public Planet getPlanet() {
        return planet;
    }

    // Method to retrieve the name of the associated planet
    public String getPlanetName() {
        return planet.getName();
    }

    private void drawBackButton(PApplet applet, List<PlanetStance> planetStances) {
        int buttonWidth = 200; // Increase button width for longer text
        int buttonHeight = 50;
        int margin = 50; // Margin from the right and bottom edges
    
        // Calculate button position
        int buttonX = applet.width - buttonWidth - margin;
        int buttonY = applet.height - buttonHeight - margin;
    
        // Draw the button rectangle
        applet.fill(255); // White color
        applet.rect(buttonX, buttonY, buttonWidth, buttonHeight);
    
        // Draw the button label
        applet.fill(0); // Black color
        applet.textAlign(PApplet.CENTER, PApplet.CENTER);
        applet.text("Tilbage til solsystemet", buttonX, buttonY, buttonWidth, buttonHeight);
    
        // Check if the button is clicked
        if (applet.mouseX >= buttonX && applet.mouseX <= buttonX + buttonWidth &&
            applet.mouseY >= buttonY && applet.mouseY <= buttonY + buttonHeight &&
            applet.mousePressed) {
            // Reset the planetActive flag and return to the solar system
            for (PlanetStance planetStance : planetStances) {
                // animationPaused = false;
                planetStance.deactivate();
            }
            program.deactivateAnimation();
        }
    }


    public void draw(List<PlanetStance> planetStances) {
        if (planetActive) {
            if (!isSetupDone) {
                setup();
                isSetupDone = true;
            }

            float imageX = applet.width / 2 - planetImage.width / 2;
            float imageY = applet.height / 2 - planetImage.height / 2;
            // Draw the planet image
            applet.image(planetImage, imageX, imageY);

            List<Moon> moons = planet.getMoons();
        if (moons != null && !moons.isEmpty()){
            float moonX = applet.width - moonImage.width - 100;
            float moonY = 0 + 100;
                applet.image(moonImage, moonX, moonY);

                if (applet.mouseX >= moonX && applet.mouseX <= moonX + moonImage.width &&
                applet.mouseY >= moonY && applet.mouseY <= moonY + moonImage.height &&
                applet.mousePressed) {
                    System.out.println("Moon clicked!");
                    moonStance.activateMoonStance();
                }
            
            drawMoonInfoBox();
        }
            
        
            
            
            drawLeftInfoBox();
            drawLineInfoBox();
            drawInfoBox(applet, planet.getName(), planet.getNumMoons(), planet.getMinTemperature(), planet.getMaxTemperature(), planet.getSunDist(), planet.getRotationTime()*10, planet.getGravity());
            drawBackButton(applet, planetStances);
        }
        moonStance.draw(applet);
    }
        




    private void setup(){
        moonStance = new MoonStance(applet);
        planetImage = applet.loadImage(planet.getName() + ".png");
        planetImage.resize(750,750);

        if (planet.getNumMoons() > 0) {
        moonImage = applet.loadImage(planet.getName()+"Moon.png");
        if (moonImage != null) {
        moonImage.resize(400,400);
        } else {
            moonImage = null;
        }
    }
    }
    public void drawMoonInfoBox() {
        applet.fill(255);
        applet.textSize(14);

        // Calculate the coordinates of the line's start and end points
        float startX = applet.width / 2 + 400; // 400 pixels to the right of the center
        float endX = applet.width / 2 + 850; // 850 pixels to the right of the center
        float y = applet.height / 2; // Same y-coordinate as the center

        // Calculate the coordinates of the tip
        float tipX = startX - 22; // Adjust the x-coordinate for the position of the tip
        float tipY1 = y - 50; // Adjust the y-coordinate for the position of the tip

        // Draw the main line
        applet.stroke(255); // Set line color to white
        applet.strokeWeight(2); // Set line thickness
        applet.line(startX, y, endX, y);

        // Draw the tip
        applet.line(startX, y, tipX, tipY1); // Line from the start point to the tip

        // Draw the info box
        float boxWidth = 400;
        float boxHeight = 185;
        float boxX = (startX + endX) / 2 - boxWidth / 2; // Center the box horizontally
        float boxY = y + 10; // Position the box below the line with some margin
        applet.fill(0); // Set fill color to black
        applet.rect(boxX, boxY, boxWidth, boxHeight); // Draw the rectangle

        // Add text inside the box
        moon = planet.getMoons().get(0);
        String infoText = moon.getDescription(); // Replace with your actual info text
        applet.fill(255); // Set fill color to white
        applet.textAlign(PApplet.CENTER, PApplet.CENTER); // Align text to center
        applet.text(infoText, boxX, boxY, boxWidth, boxHeight); // Draw the text inside the box
    }

    public void drawLineInfoBox() {
        // Set text properties
        applet.fill(255);
        applet.textSize(14);

        // Calculate the coordinates of the line's start and end points
        float startX = applet.width / 2 - 850; // 750 pixels to the left of the center
        float endX = applet.width / 2 - 380; // 375 pixels to the left of the center
        float y = applet.height / 2; // Same y-coordinate as the center

        // Calculate the coordinates of the bottom right segment
        float tipX = endX + 22; // Adjust the x-coordinate for the position of the segment
        float tipY2 = y + 50; // Adjust the y-coordinate for the position of the segment

        // Draw the main line
        applet.stroke(255); // Set line color to white
        applet.strokeWeight(2); // Set line thickness
        applet.line(startX, y, endX, y);

        // Draw the bottom right segment
        applet.line(endX, y, tipX, tipY2); // Lower segment of the bottom right segment

        // Draw the info box
        // Draw the info box
        float boxWidth = 400;
        float boxHeight = 150;
        float boxX = (startX + endX) / 2 - boxWidth / 2; // Center the box horizontally
        float boxY = y - boxHeight - 10; // Position the box above the line with some margin
        applet.fill(0); // Set fill color to black
        applet.rect(boxX, boxY, boxWidth, boxHeight); // Draw the rectangle

        // Add text inside the box
        String infoText = planet.getDescription(); // Replace with your actual info text
        applet.fill(255); // Set fill color to white
        applet.textAlign(PApplet.CENTER, PApplet.CENTER); // Align text to center
        applet.text(infoText, boxX, boxY, boxWidth, boxHeight); // Draw the text inside the box
    }

    public void drawInfoBox(PApplet applet, String planetName, int numMoons, float minTemp, float maxTemp, float distanceFromSun, float earthDaysToOrbit, float gravity) {
        int boxWidth = 400;
        int boxHeight = 200;
        int margin = 20;
        int x = margin;
        int y = margin;
    
        // Draw background rectangle
        applet.fill(0, 150); // Semi-transparent black background
        applet.rect(x, y, boxWidth, boxHeight);
    
        // Display planet name
        applet.fill(255); // White text color
        applet.textSize(20);
        applet.textAlign(PApplet.LEFT, PApplet.TOP);
        applet.text(planetName, x + margin, y + margin);
    
        // Display other information
        applet.textSize(16);
        applet.text("Antal måner: " + numMoons, x + margin, y + margin * 3);
        applet.text("Temperatur: Svinger mellem " + minTemp + " °C og " + maxTemp + " °C", (float)(x + margin), (float)(y + margin * 4));
        applet.text("Afstand til solen: " + distanceFromSun + " millioner km", x + margin, y + margin * 5);
        applet.text("Én omgang om solen tager: " + earthDaysToOrbit + " dage på Jorden", x + margin, y + margin * 6);
        applet.text("Tyngdekraft ift. Jorden: " + gravity + "g", x + margin, y + margin * 7);
    }
        
    public void drawLeftInfoBox(){
     // Set text properties
applet.fill(255);
applet.textSize(14);

// Calculate the coordinates of the line's start and end points
float startX = applet.width / 2 - 675; // 350 pixels to the left of the center
float endX = applet.width / 2 - 370; // 650 pixels to the left of the center
float y = applet.height - 400; // 400 pixels above the bottom

// Calculate the coordinates of the bottom right segment
float tipX = endX + 25; // Adjust the x-coordinate for the position of the segment (100 pixels more to the right)
float tipY2 = y - 25; // Adjust the y-coordinate for the position of the segment

// Draw the main line
applet.stroke(255); // Set line color to white
applet.strokeWeight(2); // Set line thickness
applet.line(startX, y, endX, y);

// Draw the bottom right segment
applet.line(endX, y, tipX, tipY2); // Lower segment of the bottom right segment

// Draw the info box
float boxWidth = 420;
float boxHeight = 150;
float boxX = (startX + endX) / 2 - boxWidth / 2; // Center the box horizontally
float boxY = y + 10; // Position the box below the line with some margin
applet.fill(0); // Set fill color to black
applet.rect(boxX, boxY, boxWidth, boxHeight); // Draw the rectangle

// Add text inside the box
String infoText = planet.getDescription1(); // Replace with your actual info text
applet.fill(255); // Set fill color to white
applet.textAlign(PApplet.CENTER, PApplet.CENTER); // Align text to center
applet.text(infoText, boxX, boxY, boxWidth, boxHeight); // Draw the text inside the box

    }
    public void deactivateAnimation() {
        // animationPaused = false;
        program.deactivateAnimation(); // Call method in Program2 to deactivate animation
    }

    public void toggleActive() {
        planetActive = !planetActive;
    }

    public void deactivate() {
        planetActive = false;
        // animationPaused = false; 
    }
}
