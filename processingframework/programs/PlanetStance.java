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
    private InfoBox infoBox, infoBoxMoon, infoBoxLine, infoBoxPlanets;

    public PlanetStance(PApplet applet, PImage planetImage, Planet planet, boolean animationPaused, Program2 program) 
    {
        this.applet = applet;
        this.planetImage = planetImage;
        this.planet = planet;
        // this.animationPaused = animationPaused;
        this.program = program;
        infoBox = new InfoBox(400,500,40);
        infoBoxMoon = new InfoBox(400, 185, 30);
        infoBoxLine = new InfoBox(400, 200, 40);
        infoBoxPlanets = new InfoBox(400, 200, 20);
    }

//SETUP
    private void setup()
    {
        moonStance = new MoonStance(applet);
        planetImage = applet.loadImage(planet.getName() + ".png");
        planetImage.resize(750,750);

        if (planet.getNumMoons() > 0) 
        {
        moonImage = applet.loadImage(planet.getName()+"Moon.png");
        if (moonImage != null) 
        {
        moonImage.resize(400,400);
        } 
        else 
        {
            moonImage = null;
        }
        }
    }

//GETTERS AND SETTERS
    public boolean planetActive()
    {
        return planetActive;
    }

    public Planet getPlanet() 
    {
        return planet;
    }

    public String getPlanetName() 
    {
        return planet.getName();
    }

    public void deactivateAnimation() 
    {
        program.deactivateAnimation();
    }

    public void toggleActive() 
    {
        planetActive = !planetActive;
    }

    public void deactivate() 
    {
        planetActive = false;
    }

    // MAIN DRAW METHOD
    public void draw(List<PlanetStance> planetStances) 
    {
        if (planetActive) 
        {
            if (!isSetupDone) 
            {
                setup();
                isSetupDone = true;
            }

            float imageX = applet.width / 2 - planetImage.width / 2;
            float imageY = applet.height / 2 - planetImage.height / 2;
            // Draw the planet image
            applet.image(planetImage, imageX, imageY);

            List<Moon> moons = planet.getMoons();

        if (moons != null && !moons.isEmpty())
        {
            float moonX = applet.width - moonImage.width - 100;
            float moonY = 0 + 100;
                applet.image(moonImage, moonX, moonY);

                if (applet.mouseX >= moonX && applet.mouseX <= moonX + moonImage.width &&
                applet.mouseY >= moonY && applet.mouseY <= moonY + moonImage.height &&
                applet.mousePressed) 
                {
                    System.out.println("Moon clicked!");
                    moonStance.activateMoonStance();
                }

            moon = planet.getMoons().get(0);
            String infoText = moon.getDescription(); // Replace with your actual info text
            infoBox.drawMoonInfoBox(applet, infoText);
        }    
            String infoText = planet.getDescription1(); // Replace with your actual info text
            infoBoxMoon.drawLeftInfoBoxPlanet(applet, infoText);
            
            infoBoxLine.drawLineInfoBox(applet, infoText);
            infoBoxPlanets.drawInfoBoxPlanets(applet, planet.getName(), planet.getNumMoons(), planet.getMinTemperature(), planet.getMaxTemperature(), planet.getSunDist(), planet.getRotationTime()*10, planet.getGravity());
            drawBackButton(applet, planetStances);
        }
        moonStance.draw(applet);
    }

    // EXTRA
    private void drawBackButton(PApplet applet, List<PlanetStance> planetStances) 
    {
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
}
