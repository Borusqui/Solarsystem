package processingframework.programs;

import processing.core.PApplet;
import processing.core.PImage;

public class MoonStance {

    private PApplet applet;
    private boolean moonActive = false;
    private boolean isSetupDone = false;
    private PImage moonPhaseImage;
    private InfoBox topLeftInfoBox, moonInfoBox;
    
    public MoonStance(PApplet applet) 
    {
        this.applet = applet;  
        topLeftInfoBox = new InfoBox(400,500,40);
        moonInfoBox = new InfoBox(400, 185, 30);
    }

    // SETUP
    private void setup()
    {
        moonPhaseImage = applet.loadImage("MoonPhaseImage.png");
        moonPhaseImage.resize(750,750);
    }

    //GETTER AND SETTERS
    public boolean moonActive()
    {
        return moonActive;
    }

    public void activateMoonStance()
    {
        moonActive = true;
    }

    // MAIN DRAW METHOD
    public void draw(PApplet applet2) 
    {
        if (moonActive) 
        {
            applet.background(0);
            if (!isSetupDone) 
            {
                setup();
                isSetupDone = true;
            }

            float imageX = applet.width / 2 - moonPhaseImage.width / 2;
            float imageY = applet.height / 2 - moonPhaseImage.height / 2;

            applet.image(moonPhaseImage, imageX, imageY);        
            String newInfoText = "De månefaser, også kendt som månens faser, henviser til de forskellige udseender af Månen, når den kredser om Jorden.\nFaserne gentages i en forudsigelig cyklus, kendt som den månedlige måned, der varer cirka 29,5 dage. Månefaserne påvirkes af Månens kredsløb om Jorden og de relative positioner af Månen, Jorden og Solen. Observation af månefaserne kan give indblik i himmelmekanik og kulturel betydning på tværs af forskellige samfund gennem historien.";
            topLeftInfoBox.drawInfoBox(applet, newInfoText);
            String infoText = "New Moon: Månen er ikke synlig fra Jorden, da den er i linje med solen.\r\n" + //
                                "Waxing Crescent: En lille kile af månen bliver synlig, når den begynder at vokse eller øges.\r\n" + //
                                "First Quarter: Halvdelen af månen er oplyst, hvilket ligner en \"D\" form.\r\n" + //
                                "Waxing Gibbous: Mere end halvdelen af månen er oplyst, og den nærmer sig fuldmåne.\r\n" + //
                                "Full Moon: Hele månens overflade er synlig fra Jorden og ser ud som en komplet cirkel.\r\n" + //
                                "Waning Gibbous: Mere end halvdelen af månen er stadig synlig, men den begynder at aftage.\r\n" + //
                                "Last Quarter: Halvdelen af månen er oplyst, men nu i den modsatte retning af First Quarter.\r\n" + //
                                "Waning Crescent: En lille kile af månen er stadig synlig, når den begynder at aftage.\r\n" + //
                                "Supermoon: En fuldmåne, der ser større og lysere ud end normalt på grund af sin nærhed til Jorden.\r\n" + //
                                "Blue Moon: Den anden fuldmåne, der forekommer inden for en kalendermåned, og som synes relativt sjælden.";
            moonInfoBox.drawMoonInfoBox(applet, infoText);    
        }
            drawBackButton(applet);
    }

    // EXTRA
    private void drawBackButton(PApplet applet) 
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
        applet.text("Tilbage til Solsystemet", buttonX, buttonY, buttonWidth, buttonHeight);
    
        // Check if the button is clicked
        if (applet.mouseX >= buttonX && applet.mouseX <= buttonX + buttonWidth &&
            applet.mouseY >= buttonY && applet.mouseY <= buttonY + buttonHeight &&
            applet.mousePressed) {
            moonActive = false;
            }
    }
}
