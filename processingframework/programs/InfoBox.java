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

    public void drawInfoBox(PApplet applet, float zoomFactor, float panX, float panY) 
    {
        int x = (int)((margin + panX) * zoomFactor);
        int y = (int)((margin + panY) * zoomFactor);

        applet.fill(0);
        applet.rect(x, y, (int)(boxWidth * zoomFactor), (int)(boxHeight * zoomFactor));

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

    public void drawKeyBox(PApplet applet, float zoomFactor, float panX, float panY) 
    {
        int x = (int)(((applet.width - boxWidth - margin) + panX) * zoomFactor);
        int y = (int)((margin + panY) * zoomFactor);

        applet.fill(0);
        applet.rect(x, y, (int)(boxWidth * zoomFactor), (int)(boxHeight * zoomFactor));

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

    public void drawLeftInfoBox(PApplet applet)
    {   
        applet.fill(255);
        applet.textSize(14);
        
        float startX = applet.width / 2 - 675; 
        float endX = applet.width / 2 - 370; 
        float y = applet.height - 400; 
        
        float tipX = endX + 25; 
        float tipY2 = y - 25;
        
        applet.stroke(255); 
        applet.strokeWeight(2); 
        applet.line(startX, y, endX, y);
        
        applet.line(endX, y, tipX, tipY2);
    
        float boxWidth = 420;
        float boxHeight = 350;
        float boxX = (startX + endX) / 2 - boxWidth / 2; 
        float boxY = y + 10; 
        applet.fill(0); 
        applet.rect(boxX, boxY, boxWidth, boxHeight); 
        
        String infoText = "Den Internationale Rumstation (ISS) er et vidunder af moderne ingeniørarbejde og internationalt samarbejde.\n         1. Boliger: Besætningsmedlemmer bor i kompakte boliger om bord på ISS, som fungerer både som hjem og arbejdsplads under deres lange missioner.\n2. Jordobservation: Fra sin position i lav jordbane tilbyder ISS betagende udsigter over vores planets landskaber, vejrforhold og naturlige fænomener, fanget gennem imponerende fotografier taget af astronauter.\n3. Rumvandringer: Astronauter begiver sig regelmæssigt ud på rumvandringer, eller extravehicular activities (EVAs), for at udføre vedligeholdelsesopgaver, reparere udstyr og installere nye komponenter på stationens yderside, hvilket giver enestående oplevelser og udsigter til rummet.\n 4. International Besætning: ISS eksemplificerer internationalt samarbejde, med astronauter fra forskellige lande, der bor og arbejder sammen i rummet, hvilket fremmer samarbejde og kammeratskab ud over geopolitiske grænser.\n" ; 
        applet.fill(255); 
        applet.textAlign(PApplet.CENTER, PApplet.CENTER); 
        applet.text(infoText, boxX, boxY, boxWidth, boxHeight); 
        }

public void drawInfoBox(PApplet applet, String infoText) 
{
    int x = (int)(margin) ;
    int y = (int)(margin);

    applet.fill(0);
    applet.rect(x, y, (int)(boxWidth), (int)(boxHeight));

    applet.fill(255); 
    applet.textSize(16 );
    applet.textLeading(20);
    applet.textAlign(PApplet.LEFT, PApplet.TOP);
    applet.text(infoText, (x + margin), (y + margin), (int)((boxWidth - 2 * margin)), (int)((boxHeight - 2 * margin)));
}

public void drawMoonInfoBox(PApplet applet, String infoText) 
{
    applet.fill(255);
    applet.textSize(14);

    float startX = applet.width / 2 + 400; 
    float endX = applet.width / 2 + 850; 
    float y = applet.height / 2; 

    float tipX = startX - 22; 
    float tipY1 = y - 50; 

    applet.stroke(255); 
    applet.strokeWeight(2); 
    applet.line(startX, y, endX, y);

    applet.line(startX, y, tipX, tipY1);

    float boxWidth = 400;
    float boxHeight = 385;
    float boxX = (startX + endX) / 2 - boxWidth / 2; 
    float boxY = y + 10; 
    applet.fill(0); 
    applet.rect(boxX, boxY, boxWidth, boxHeight);

    applet.fill(255);
    applet.textAlign(PApplet.CENTER, PApplet.CENTER);
    applet.text(infoText, boxX, boxY, boxWidth, boxHeight);
}

public void drawLeftInfoBoxPlanet(PApplet applet, String infoText)
{
   applet.fill(255);
   applet.textSize(14);

   float startX = applet.width / 2 - 675; 
   float endX = applet.width / 2 - 370; 
   float y = applet.height - 400; 

   float tipX = endX + 25; 
   float tipY2 = y - 25;

   applet.stroke(255); 
   applet.strokeWeight(2);
   applet.line(startX, y, endX, y);

   applet.line(endX, y, tipX, tipY2); 

   float boxWidth = 420;
   float boxHeight = 150;
   float boxX = (startX + endX) / 2 - boxWidth / 2; 
   float boxY = y + 10; 
   applet.fill(0); 
   applet.rect(boxX, boxY, boxWidth, boxHeight);

   applet.fill(255);
   applet.textAlign(PApplet.CENTER, PApplet.CENTER);
   applet.text(infoText, boxX, boxY, boxWidth, boxHeight);
}

public void drawLineInfoBox(PApplet applet, String infoText) 
{
    applet.fill(255);
    applet.textSize(14);

    float startX = applet.width / 2 - 850; 
    float endX = applet.width / 2 - 380; 
    float y = applet.height / 2;

    float tipX = endX + 22; 
    float tipY2 = y + 50;

    applet.stroke(255);
    applet.strokeWeight(2);
    applet.line(startX, y, endX, y);

    applet.line(endX, y, tipX, tipY2); 

    float boxWidth = 400;
    float boxHeight = 150;
    float boxX = (startX + endX) / 2 - boxWidth / 2;
    float boxY = y - boxHeight - 10; 
    applet.fill(0); 
    applet.rect(boxX, boxY, boxWidth, boxHeight); 

    applet.fill(255);
    applet.textAlign(PApplet.CENTER, PApplet.CENTER);
    applet.text(infoText, boxX, boxY, boxWidth, boxHeight);
}

public void drawInfoBoxPlanets(PApplet applet, String planetName, int numMoons, float minTemp, float maxTemp, float distanceFromSun, float earthDaysToOrbit, float gravity) 
{
    int boxWidth = 400;
    int boxHeight = 200;
    int margin = 20;
    int x = margin;
    int y = margin;

    applet.fill(0, 150);
    applet.rect(x, y, boxWidth, boxHeight);

    applet.fill(255);
    applet.textSize(20);
    applet.textAlign(PApplet.LEFT, PApplet.TOP);
    applet.text(planetName, x + margin, y + margin);

    applet.textSize(16);
    applet.text("Antal måner: " + numMoons, x + margin, y + margin * 3);
    applet.text("Temperatur: Svinger mellem " + minTemp + " °C og " + maxTemp + " °C", (float)(x + margin), (float)(y + margin * 4));
    applet.text("Afstand til solen: " + distanceFromSun + " millioner km", x + margin, y + margin * 5);
    applet.text("Én omgang om solen tager: " + earthDaysToOrbit + " dage på Jorden", x + margin, y + margin * 6);
    applet.text("Tyngdekraft ift. Jorden: " + gravity + "g", x + margin, y + margin * 7);
}
}
