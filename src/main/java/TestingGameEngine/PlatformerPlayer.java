package TestingGameEngine;

import Entities.Entity;
import GameComponents.Kinematic2D;
import Graphics.*;
import Utilities.EngineMath;
import Utilities.Vector2f;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlatformerPlayer extends Entity{

    private Kinematic2D kinematic2D;
    private Vector2f velocityGoal;

    public PlatformerPlayer(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        kinematic2D = new Kinematic2D(this);
        velocityGoal = new Vector2f(0, 0);

        addComponent(kinematic2D);
    }

    public PlatformerPlayer(int x, int y, int width, int height, float rotationAngle, Color color) {
        super(x, y, width, height, rotationAngle, color);
    }

    @Override
    public void render(EngineGraphics g) {
        g.drawBorder(getX(),getY(),width,height,4,Color.WHITE);
        g.drawRect(getX(),getY(),width,height,color,true);
    }

    public Kinematic2D getKinematic2D() {
        return kinematic2D;
    }

    public void setKinematic2D(Kinematic2D kinematic2D) {
        this.kinematic2D = kinematic2D;
    }

    public Vector2f getVelocityGoal() {
        return velocityGoal;
    }

    public void setVelocityGoal(Vector2f velocityGoal) {
        this.velocityGoal = velocityGoal;
    }

    @Override
    public void update(float delta) {
        kinematic2D.getVelocity().setX(EngineMath.Lerp(velocityGoal.getX(), kinematic2D.getVelocity().getX(), delta *30));
        kinematic2D.getVelocity().setY(EngineMath.Lerp(velocityGoal.getY(), kinematic2D.getVelocity().getY(), delta *30));
        if(Renderer.getInput().KeyDown(KeyEvent.VK_D)){
            setVelocityGoal(new Vector2f(getMoveSpeed(), 0));
        }
        if(Renderer.getInput().KeyDown(KeyEvent.VK_A)){
            setVelocityGoal(new Vector2f(-getMoveSpeed(), 0));
        }

        if(Renderer.getInput().KeyUp(KeyEvent.VK_D)){
            setVelocityGoal(new Vector2f(0, 0));
        }
        if(Renderer.getInput().KeyUp(KeyEvent.VK_A)){
            setVelocityGoal(new Vector2f(0, 0));
        }

    }
}
