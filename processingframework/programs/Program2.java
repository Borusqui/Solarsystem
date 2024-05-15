package processingframework.programs;

import processing.core.PApplet;
import processing.core.PImage;
import processingframework.ProcessingProgram;

import java.util.ArrayList;
import java.util.List;

public class Program2 implements ProcessingProgram {
    private List<Planet> planets;
    private double timeElapsed;
    private Sun sun;
	private List<PlanetStance> planetStances;
	private boolean animationPaused = false;
	private AsteroidBelt asteroidBelt;
	private boolean introMenuShown;
	private SpaceStation spaceStation;
	private boolean spaceStationShow; 
	private InfoBox infoBox;
	private InfoBox keyBox;


    public Program2() {
        planets = new ArrayList<>();
		planetStances = new ArrayList<>();
		infoBox = new InfoBox(400,500,40);
		keyBox = new InfoBox(400, 200, 40);

    }
	


    @Override
    public void setup(PApplet applet) {
		
        applet.fullScreen();
		introMenuShown = false;
		spaceStationShow = false;
		
        // Load images
        PImage sunImage = applet.loadImage("Sun.png");
        PImage mercuryImage = applet.loadImage("Mercury.png");
        PImage venusImage = applet.loadImage("Venus.png");
        PImage earthImage = applet.loadImage("Earth.png");
        PImage marsImage = applet.loadImage("Mars.png");
        PImage jupiterImage = applet.loadImage("Jupiter.png");
        PImage saturnImage = applet.loadImage("Saturn.png");
        PImage uranusImage = applet.loadImage("Uranus.png");
        PImage neptuneImage = applet.loadImage("Neptune.png");
		PImage moonImage = applet.loadImage("EarthMoon.png");
		PImage marsMoonImage = applet.loadImage("MarsMoon.png");
		PImage marsMoon1Image = applet.loadImage("MarsMoon1.png");
		PImage neptuneMoonImage = applet.loadImage("MarsMoon.png");

		PImage asteroidBeltImage = applet.loadImage("AsteroidBelt.png");
		PImage spaceStationImage = applet.loadImage("SpaceStation.png");

		// Resize images with manual adjustments
		mercuryImage.resize(30, 30);  
		venusImage.resize(50, 50);    
		earthImage.resize(65, 65);     
		marsImage.resize(40, 40);      
		jupiterImage.resize(140, 140); 
		saturnImage.resize(120, 120);  
		uranusImage.resize(90, 90);    
		neptuneImage.resize(75, 75);  

		moonImage.resize(17, 17);
		marsMoonImage.resize(8,8);
		marsMoon1Image.resize(10,10);
		neptuneMoonImage.resize(10,10);

		asteroidBeltImage.resize(1000, 1000);
		spaceStationImage.resize(950,950);
		


        // Initialize Sun
        sun = new Sun(applet, "Sun", 50, 5778, 1, 500000000, sunImage, "The sun is hot and old");

        // Initialize Planets
		planets.add(new Planet("Mercury", 2440, 57.91f, 8.8f, 0, -173, 427, 0.38f, "Merkur er den mindste planet i Solsystemet og den nærmeste til Solen. Den har ekstreme temperaturudsving mellem dag og nat.", "NASAs MESSENGER (MErcury Surface, Space ENvironment, GEochemistry, and Ranging) mission kredsede omkring Merkur fra 2011 til 2015 og leverede værdifulde data om dens overflade, sammensætning og magnetfelt.", mercuryImage));
		planets.add(new Planet("Venus", 6052, 108.2f, 22.5f, 0, 462, 465, 0.91f, "Venus er den anden planet fra Solen og kaldes ofte Jordens søsterplanet. Den har en tyk atmosfære, der skaber en intens drivhuseffekt.", "Sovjetunionens Venera-program gennemførte adskillige vellykkede landing på Venus i 1970'erne og 1980'erne og leverede de første nærbilleder og data om dens overflade og atmosfære.\nNASAs Magellan-rumsonde kortlagde Venus' overflade med radar i starten af 1990'erne og afslørede dens vulkanske træk og højlande.", venusImage));
		planets.add(new Planet("Earth", 6371, 149.6f, 36.525f, 1, -30, 30, 1.0f, "Jorden er den tredje planet fra Solen og den eneste kendte planet, der understøtter liv. Den har en mangfoldig biosfære og en unik blå farve på grund af dens atmosfære.", "Talrige satellitter til jordobservation overvåger konstant vores planets overflade, atmosfære og have og leverer data afgørende for klimastudier, vejrudsigt og miljøovervågning.", earthImage));
		planets.add(new Planet("Mars", 3389, 227.9f, 68.7f, 2, -60, 20, 0.38f, "Mars er den fjerde planet fra Solen og kendes som den Røde Planet. Den har polarcapser, og dens overflade er præget af bjerge, kløfter og tørrede floder.", "NASAs Mars-rovere, herunder Spirit, Opportunity, Curiosity og Perseverance, har udforsket Mars' overflade og studeret dens geologi, klima og potentielle beboelighed.\nMars Reconnaissance Orbiter (MRO) og Mars Odyssey-rumsonden fortsætter med at kredse om Mars og studere dens atmosfære, overflade og potentielle vandressourcer.", marsImage));
		planets.add(new Planet("Jupiter", 69910, 778.5f, 433.26f, 79, -145, 1700, 2.36f, "Jupiter er den største planet i Solsystemet og er en gas kæmpe. Den har en stærk magnetosfære og mere end 70 kendte måner.", "NASAs Juno-rumsonde ankom til Jupiter i 2016 og har studeret dens atmosfære, magnetosfære og indre struktur for bedre at forstå planetens dannelse og udvikling.", jupiterImage));
		planets.add(new Planet("Saturn", 58230, 1429f, 1075.95f, 82, -224, 49, 0.92f, "Saturn er den sjette planet fra Solen og er kendt for sine fremtrædende ringe. Den har også mange måner, hvoraf Titan er den største.", "NASAs Cassini-rumsonde kredsede om Saturn fra 2004 til 2017 og leverede enestående billeder af dens ringe, måner og atmosfæriske træk. Cassinis mission afsluttedes med en dramatisk dykning ned i Saturns atmosfære.\nDen Europæiske Rumfartsorganisation ESA's Huygens-sonde, en del af Cassini-Huygens-missionen, landede succesfuldt på Saturns måne Titan i 2005 og studerede dens overflade og atmosfære.", saturnImage));
		planets.add(new Planet("Uranus", 25362, 2871f, 3068.85f, 27, -224, 49, 0.89f, "Uranus er den syvende planet fra Solen og er en is kæmpe med en unik rotation. Den roterer på sin side, hvilket resulterer i voldsomme årstidsændringer.", "Uranus har ikke været det primære mål for nogen dedikerede rumfartsmissioner hidtil. Dog bidrager data fra teleskoper og rumobservatorier fortsat til vores forståelse af denne fjerne planet.", uranusImage));
		planets.add(new Planet("Neptune", 24622, 4498f, 6019.02f, 14, -218, 10, 1.12f, "Neptun er den ottende og fjerneste kendte planet fra Solen i Solsystemet. Den har en storm kaldet Den Store Mørke Plet og er omgivet af et tyndt system af ringe.", " På samme måde som Uranus har Neptun ikke været fokus for dedikerede rumfartsmissioner. De fleste af vores oplysninger om Neptun stammer fra teleskopiske observationer og Voyager 2-flybyen i 1989, der leverede nærbilleder og data om planeten og dens måner.", neptuneImage));
		
	// Create PlanetStance instances for each planet
for (Planet planet : planets) {
	PImage image = planet.getImage();
    planetStances.add(new PlanetStance(applet, image, planet, animationPaused, this));
}

// Find Earth planet
Planet earthPlanet = null;
for (Planet planet : planets) {
    if (planet.getName().equals("Earth")) {
        earthPlanet = planet;
        break;
    }
}
Planet marsPlanet = null;
for (Planet planet : planets) {
    if (planet.getName().equals("Mars")) {
       marsPlanet = planet;
        break;
    }
}
// Planet neptunePlanet = null;
// for (Planet planet : planets) {
// 	if (planet.getName().equals("Neptune")){
// 		neptunePlanet = planet;
// 		break;
// 	}
// }

// Add Moon orbiting Earth
if (earthPlanet != null) {
    earthPlanet.addMoon("The Moon", 2.8f, 50f, moonImage, "Jordens måne, kendt som Luna, er den femte største naturlige satellit i solsystemet og den eneste måne omkring Jorden. Med en diameter på cirka 3.474 kilometer er den relativt stor sammenlignet med sin moderplanet. Luna er kendt for sin påvirkning på tidevandene på Jorden og har været et fascinerende objekt for astronomer og forskere i århundreder. Den har en grålig overflade, der er præget af kratere, bjergkæder og mørke sletter kaldet hav. Luna er også genstand for udforskning fra forskellige rummissioner og har været et fokus for videnskabelig forskning om solsystemets historie og udvikling.");
} else {
    System.out.println("Error: Earth planet not found.");
}

if (marsPlanet != null) {
    marsPlanet.addMoon("Phobos", 0.032f, 25f, marsMoonImage, "Mars har to små måner, Phobos og Deimos, der begge er opkaldt efter figurer fra græsk mytologi, som ledsager krigsguden Ares (Mars' græske pendant). Disse måner er bemærkelsesværdige for deres usædvanlige udseende og deres tætte kredsløb omkring Mars. Phobos, den største af de to, har en ujævn overflade og bevæger sig hurtigt nok til at optræde som en op-og-ned-opgang for observatører på Mars' overflade. Deimos er mindre og bevæger sig langsommere, og dens overflade er præget af kratere og klipper. Begge måner antages at være fangede asteroider, der blev fanget af Mars' tyngdekraft i fortiden. Deres oprindelse giver indsigt i den tidlige historie og udvikling af Mars og solsystemet som helhed.");
	marsPlanet.addMoon("Deimos", 0.127f, 32, marsMoon1Image, null);
} else {
    System.out.println("Error: Mars planet not found.");
}

asteroidBelt = new AsteroidBelt(asteroidBeltImage, 0, -0.003f);

spaceStation = new SpaceStation(spaceStationImage, 0, -0.001f);

}
// if (neptunePlanet != null) {
	// neptunePlanet.addMoon("Moon 1",0.5f, 80, neptuneMoonImage);
	// neptunePlanet.addMoon("Moon 1",1.5f, 82, neptuneMoonImage);
	// neptunePlanet.addMoon("Moon 1",2.5f, 84, neptuneMoonImage);
	// neptunePlanet.addMoon("Moon 1",1.2f, 85, neptuneMoonImage);

// }

// 		}
	
    @Override
	public void update(PApplet applet, double timeElapsed, float mouseX, float mouseY) {
		this.timeElapsed = timeElapsed;
		for (Planet planet : planets) {
			planet.update(timeElapsed);
		}
	}

	private boolean cooldown = false;
	private final int cooldownDuration = 500;
	private long lastClickTime = 0;

	public void drawButtons(PApplet applet, List<Planet> planets, float zoomFactor, float panX, float panY) {
		int numButtons = planets.size();
		int buttonWidth = applet.width / numButtons;
		int buttonHeight = 50;
		int buttonY = applet.height - buttonHeight;
	
		for (int i = 0; i < numButtons; i++) {
			int buttonX = i * buttonWidth;

			// Draw the button rectangle
			applet.fill(255);
			applet.rect(buttonX - (int)(panX * zoomFactor), buttonY - (int)(panY * zoomFactor), buttonWidth * zoomFactor, buttonHeight * zoomFactor);
	
			// Draw the button label
			applet.fill(0);
			applet.textAlign(PApplet.CENTER, PApplet.CENTER);
			applet.text(planets.get(i).getName(), buttonX, buttonY, buttonWidth, buttonHeight);
	
			// Check if the button is clicked
			if (applet.mouseX >= buttonX - (int)(panX * zoomFactor) && applet.mouseX <= buttonX + buttonWidth * zoomFactor - (int)(panX * zoomFactor) &&
            applet.mouseY >= buttonY - (int)(panY * zoomFactor) && applet.mouseY <= buttonY + buttonHeight * zoomFactor - (int)(panY * zoomFactor) &&
            applet.mousePressed && !cooldown) {
            buttonClicked(i, applet, cooldown);
            cooldown = true;
            lastClickTime = System.currentTimeMillis();
        }
		}
	
		// Reset cooldown if enough time has passed
		if (cooldown && System.currentTimeMillis() - lastClickTime >= cooldownDuration) {
			cooldown = false;
		}
	}
	private void drawIntroMenu(PApplet applet) {
        // Draw background for menu
		applet.background(0);
		PImage backgroundImage = applet.loadImage("Background.png");
		applet.image(backgroundImage, 0, 0, applet.width, applet.height);

		float buttonX = applet.width / 2 - 100;
		float buttonY = applet.height / 2 - 50;
		float buttonHeight = 50;
		float buttonWidth = 200;

		drawButton(applet, "Solsystemet", buttonX, buttonY, buttonWidth, buttonHeight);
		if (applet.mouseX >= buttonX  && applet.mouseX <= buttonX + buttonWidth  &&
		applet.mouseY >= buttonY  && applet.mouseY <= buttonY + buttonHeight &&
		applet.mousePressed && !cooldown) {
		introButtonClicked(applet);
		cooldown = true;
		lastClickTime = System.currentTimeMillis();
	}
	// Reset cooldown if enough time has passed
	if (cooldown && System.currentTimeMillis() - lastClickTime >= cooldownDuration) {
		cooldown = false;
	}
		float buttonY2 = applet.height / 2 + 50;

        drawButton(applet, "Space Station", buttonX, buttonY2, buttonWidth, buttonHeight);
		if (applet.mouseX >= buttonX  && applet.mouseX <= buttonX + buttonWidth  &&
		applet.mouseY >= buttonY2  && applet.mouseY <= buttonY2 + buttonHeight &&
		applet.mousePressed && !cooldown) {
		spaceStationButtonClicked(applet);
		cooldown = true;
		lastClickTime = System.currentTimeMillis();
	}
	// Reset cooldown if enough time has passed
	if (cooldown && System.currentTimeMillis() - lastClickTime >= cooldownDuration) {
		cooldown = false;
	}
	}

	private void drawButton(PApplet applet, String label, float x, float y, float width, float height) {
        applet.fill(255);
        applet.rect(x, y, width, height);
        applet.fill(0);
        applet.textAlign(PApplet.CENTER, PApplet.CENTER);
        applet.text(label, x, y, width, height);
    }
	

	private void introButtonClicked(PApplet applet) {
		introMenuShown = true;
	}

	private void spaceStationButtonClicked(PApplet applet){
		introMenuShown = true;
		spaceStationShow = true;
	}

	private void buttonClicked(int index, PApplet applet, boolean planetActive) {
		Planet clickedPlanet = planets.get(index);
		System.out.println("Planet clicked: " + clickedPlanet.getName());

		animationPaused = false;
		
		// Toggle the planetActive flag of the associated PlanetStance instance
		for (PlanetStance planetStance : planetStances) {
			if (planetStance.getPlanet().getName().equals(clickedPlanet.getName())) {
				planetStance.toggleActive();
				planetStance.deactivateAnimation();
				animationPaused = true; // Toggle animation pause state
			} else {
				planetStance.deactivate();
			}
		}
	}

	public void deactivateAnimation(){
	animationPaused = false;
	}

	public void resetCooldown() {
		cooldown = false;
	}

	public void returnToMenu(PApplet applet) {
        introMenuShown = false;
		spaceStationShow = false;
		System.out.println("introMenuShown" + introMenuShown + "spaceStationShow" + spaceStationShow);
    }
	
    @Override
	public void draw(PApplet applet, float zoomFactor, float panX, float panY) {
    applet.background(0);
	if (!introMenuShown && !spaceStationShow) {
		drawIntroMenu(applet);
	} else if (introMenuShown && spaceStationShow){
		spaceStation.draw(applet);
	} else {

    if (!animationPaused) { // Check if animation is not paused
        float sunX = applet.width / 2;
        float sunY = applet.height / 2;
        sun.draw(applet, sunX, sunY);
		asteroidBelt.draw(applet);
	
        for (Planet planet : planets) {
			System.out.println("Planet " + planet.getName() + " X: " + planet.getX() + " Y: " + planet.getY());
			planet.draw(applet, sunX, sunY, timeElapsed);

			for (Moon moon : planet.getMoons()) {
				moon.draw(applet, (sunX + planet.getX()), (sunY + planet.getY()), timeElapsed);
				System.out.println("Planet " + planet.getName() + " X: " + planet.getX() + " Y: " + planet.getY());

			}
        }
		if (zoomFactor == 1.0f){
        infoBox.drawInfoBox(applet, zoomFactor, panX, panY);
        keyBox.drawKeyBox(applet, zoomFactor, panX, panY);
        drawButtons(applet, planets, zoomFactor, panX, panY);
		}
    }

    for (PlanetStance planetStance : planetStances) {
        if (planetStance.planetActive()) {
            planetStance.draw(planetStances);
        }
    }
}
}
}


		
	// 	// Draw information box
	// 	drawInfoBox(applet);
	// 	drawKeyBox(applet);
    // 	drawButtons(applet, planets);
		

    //     float sunX = applet.width / 2;
    //     float sunY = applet.height / 2;
    //     sun.draw(applet, sunX, sunY);

    //     // Draw planets
    //     for (Planet planet : planets) {
	// 		planet.draw(applet, sunX, sunY, timeElapsed);
	// 	}

	// 	for (PlanetStance planetStance : planetStances) {
	// 		if (planetStance.isTransitioning()) {
	// 			planetStance.transitionEffect(applet);
	// 		} else {
	// 			planetStance.draw();
	// 		}
	// 	}
	// }