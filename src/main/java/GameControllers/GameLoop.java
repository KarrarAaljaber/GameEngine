package GameControllers;

import Graphics.Renderer;

public class GameLoop implements  Runnable{


    private  Renderer renderer;
    private Thread thread;
    private boolean isRunning = false;


    private final int MAX_FPS = 1000;
    private final int MAX_UPS = 60;

    public GameLoop(Renderer renderer){
        this.renderer = renderer;
    }




    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        int fps = 0, ups = 0;
        double deltaTime = 0, deltaRenderTime = 0;
        double optimalUpdateTime = 1000000000 / MAX_UPS;
        double optimalRenderTime = 1000000000 / MAX_FPS;

        long startTime = System.nanoTime();
        while (isRunning) {
            long curTime = System.nanoTime();
            deltaTime += (curTime - startTime);
            deltaRenderTime += (curTime - startTime);
            startTime = curTime;

            if (deltaTime >= optimalUpdateTime) {
                renderer.update((float) deltaTime / 1000000000);
                ups++;
                deltaTime -= optimalUpdateTime;
            }
            if (deltaRenderTime >= optimalRenderTime) {
                renderer.renderToScreen();
                renderer.render();
                fps++;
                deltaRenderTime -= optimalRenderTime;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println(String.format("FPS : %d, UPS: %d", fps, ups));
                fps = 0;
                ups = 0;
                timer += 1000;
            }

        }
    }

    public void start() {
        thread = new Thread(this, "mainThread");
        thread.start();
        isRunning = true;
    }

}
