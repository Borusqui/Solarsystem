import processing.core.PApplet;
import processingframework.ProcessingProgram;
import processingframework.programs.Program2;

public class ProcessingRun extends PApplet {
    private static ProcessingProgram prg = new Program2();
    private static long lastTime;
    private static RunState state = RunState.RUNNING;
    private float zoomFactor = 1.0f;
    private float panX = 0;
    private float panY = 0;
    private float curTimeSeconds;
    

    public enum RunState {
        RUNNING,
        PAUSED,
        ORBIT_PAUSED
    }

    public void settings() 
    {
        prg.setup(this);
        lastTime = System.currentTimeMillis();
    }


    public void draw() 
    {
        long curTime = System.currentTimeMillis();
        double timeElapsed = 0;
        curTimeSeconds = (curTime - lastTime) / 1000;
        System.out.println(curTimeSeconds);

        if (state != RunState.PAUSED) {
            timeElapsed = (curTime - lastTime) / 1000.0;
			}

		// ZOOM FUNCTION
		scale(zoomFactor);
        translate(panX, panY);
	
		// UPDATED ZOOM MOUSE COORDINATES
		float scaledMouseX = (mouseX - panX) / zoomFactor;
		float scaledMouseY = (mouseY - panY) / zoomFactor;

		if (state == RunState.RUNNING) {
			prg.update(this, timeElapsed, scaledMouseX, scaledMouseY);
		}
    
		prg.draw(this, zoomFactor, panX, panY);

		resetMatrix();
        }
    

    public void keyPressed() 
    {
        if (key == 'p') {
            togglePause();
        }
        if (key == ' ') {
            toggleOrbitPause();
        }
        if (key == '+') {
            zoomIn();
        }
        if (key == '-') {
            zoomOut();
        }
        if (key == 'r' || keyCode == 'R') {
            resetZoom();
        }
        if (keyCode == 'b' || keyCode == 'B') {
        prg.returnToMenu(null); 
        }
        if (key == CODED) {
            if (keyCode == UP) {
                panY += 20;
            } else if (keyCode == DOWN) {
                panY -= 20;
            } else if (keyCode == LEFT) {
                panX += 20;
            } else if (keyCode == RIGHT) {
                panX -= 20;
            }
        }
    }

    public static boolean isOrbitPaused() 
    {
        return state == RunState.ORBIT_PAUSED;
    }

    private void togglePause() 
    {
        if (state == RunState.RUNNING) {
            state = RunState.PAUSED;
        } else {
            state = RunState.RUNNING;
        }
    }

    private void toggleOrbitPause() 
    {
        if (state == RunState.ORBIT_PAUSED) {
            state = RunState.RUNNING;
        } else {
            state = RunState.ORBIT_PAUSED;
        }
    }

    private void zoomIn() 
    {
        zoomFactor *= 1.1;
    }

    private void zoomOut() 
    {
        zoomFactor /= 1.1;
    }

    private void resetZoom() 
    {
        zoomFactor = 1.0f;
        panX = 0;
        panY = 0;
    }

    public static void main(String[] args) 
    {
        PApplet.main("ProcessingRun");
    }
}