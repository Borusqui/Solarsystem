package processingframework.programs;

import processing.core.PApplet;

public class InfoBox {
    private int boxWidth;
    private int boxHeight;
    private int margin;

    public InfoBox(int boxWidth, int boxHeight, int margin) {
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
        this.margin = margin;
    }

    public void drawInfoBox(PApplet applet, float zoomFactor, float panX, float panY) {
        int x = (int)((margin + panX) * zoomFactor);
        int y = (int)((margin + panY) * zoomFactor);

        // Draw background rectangle
        applet.fill(0);
        applet.rect(x, y, (int)(boxWidth * zoomFactor), (int)(boxHeight * zoomFactor));

        // Display text 
        applet.fill(255); 
        applet.textSize(16 * zoomFactor);
        applet.textLeading(20 * zoomFactor);
        applet.textAlign(PApplet.LEFT, PApplet.TOP);
        String solarSystemInfo = "- Solsystemet består af Solen og otte planeter: Merkur, Venus, Jorden, Mars, Jupiter, Saturn, Uranus og Neptun.\n" +
            "- Solen er en stjerne placeret i centrum af Solsystemet. Den indeholder cirka 99,8% af Solsystemets samlede masse.\n" +
            "- Planeterne kredser om Solen i elliptiske baner og følger Keplers love for planetarisk bevægelse.\n" +
            "- Solsystemet blev dannet for cirka 4,6 milliarder år siden fra en gigantisk roterende sky af gas og støv kaldet soltågen.";
        applet.text(solarSystemInfo, (x + margin * zoomFactor), (y + margin * zoomFactor), (int)((boxWidth - 2 * margin) * zoomFactor), (int)((boxHeight - 2 * margin) * zoomFactor));
    }

    public void drawKeyBox(PApplet applet, float zoomFactor, float panX, float panY) {
        int x = (int)(((applet.width - boxWidth - margin) + panX) * zoomFactor);
        int y = (int)((margin + panY) * zoomFactor);

        // Draw background rectangle
        applet.fill(0);
        applet.rect(x, y, (int)(boxWidth * zoomFactor), (int)(boxHeight * zoomFactor));

        // Display text 
        applet.fill(255); 
        applet.textSize(16 * zoomFactor);
        applet.textLeading(20 * zoomFactor);
        applet.textAlign(PApplet.LEFT, PApplet.TOP);
        String keyInfo = "Zoom ind: +\n" +
            "Zoom ud: -\n" +
            "Tilbage til start: R\n" +
            "Pause: P\n" +
            "Benyt piletaster til at bevæge billedet";

        applet.text(keyInfo, (x + margin * zoomFactor), (y + margin * zoomFactor), (int)((boxWidth - 2 * margin) * zoomFactor), (int)((boxHeight - 2 * margin) * zoomFactor));
    }

    public void drawLeftInfoBox(PApplet applet){
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
   float boxHeight = 350;
   float boxX = (startX + endX) / 2 - boxWidth / 2; // Center the box horizontally
   float boxY = y + 10; // Position the box below the line with some margin
   applet.fill(0); // Set fill color to black
   applet.rect(boxX, boxY, boxWidth, boxHeight); // Draw the rectangle
   
   // Add text inside the box
   String infoText = "Den Internationale Rumstation (ISS) er et vidunder af moderne ingeniørarbejde og internationalt samarbejde.\n         1. Boliger: Besætningsmedlemmer bor i kompakte boliger om bord på ISS, som fungerer både som hjem og arbejdsplads under deres lange missioner.\n2. Jordobservation: Fra sin position i lav jordbane tilbyder ISS betagende udsigter over vores planets landskaber, vejrforhold og naturlige fænomener, fanget gennem imponerende fotografier taget af astronauter.\n3. Rumvandringer: Astronauter begiver sig regelmæssigt ud på rumvandringer, eller extravehicular activities (EVAs), for at udføre vedligeholdelsesopgaver, reparere udstyr og installere nye komponenter på stationens yderside, hvilket giver enestående oplevelser og udsigter til rummet.\n 4. International Besætning: ISS eksemplificerer internationalt samarbejde, med astronauter fra forskellige lande, der bor og arbejder sammen i rummet, hvilket fremmer samarbejde og kammeratskab ud over geopolitiske grænser.\n" ; 
   applet.fill(255); // Set fill color to white
   applet.textAlign(PApplet.CENTER, PApplet.CENTER); // Align text to center
   applet.text(infoText, boxX, boxY, boxWidth, boxHeight); // Draw the text inside the box
}

public void drawInfoBox(PApplet applet, String infoText) {
    int x = (int)(margin) ;
    int y = (int)(margin);

    // Draw background rectangle
    applet.fill(0);
    applet.rect(x, y, (int)(boxWidth), (int)(boxHeight));

    // Display text 
    applet.fill(255); 
    applet.textSize(16 );
    applet.textLeading(20);
    applet.textAlign(PApplet.LEFT, PApplet.TOP);
    applet.text(infoText, (x + margin), (y + margin), (int)((boxWidth - 2 * margin)), (int)((boxHeight - 2 * margin)));
}

}
