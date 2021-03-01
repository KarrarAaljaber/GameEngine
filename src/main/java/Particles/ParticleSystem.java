package Particles;

import GameComponents.GameComponent;
import GameComponents.Rigidbody;
import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Particles.Particle;
import Utilities.EngineMath;
import Utilities.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ParticleSystem extends GameComponent {

     private ArrayList<Particle> particles;
    private Random rand = new Random();

    public ParticleSystem(GameObject parent) {
        super(parent);
        particles = new ArrayList<>();
        rand = new Random();
    }
    public ParticleSystem() {
        particles = new ArrayList<>();
        rand = new Random();
    }



    @Override
    public void init() {

    }
    public void addParticles(Particle particle, int amount){
        for(int i=0; i< amount; i++){
            particles.add(particle);
        }
    }


    @Override
    public void update(float delta){
        for(int i=0; i < particles.size(); i++){
            particles.get(i).update(delta);
            particles.get(i).getRigidbody().update(delta);

        }
        for(int i=particles.size() -1; i >=0; i--){
            Particle p = particles.get(i);

            var angleInRadians =(int)p.getRotationAngle() * Math.PI / 180;
            p.getRigidbody().getVelocity().setX((float) ( p.getMoveSpeed()* Math.cos(angleInRadians) * delta));
            p.getRigidbody().getVelocity().setY((float) (p.getMoveSpeed()* Math.sin(angleInRadians) * delta));
            if(particles.get(i).getTimeToLive() <=0){
                particles.remove(particles.get(i));
            }
        }




    }




    @Override
    public void render(EngineGraphics g) {
        for(int i=0; i < particles.size(); i++){
            particles.get(i).render(g);
        }
    }


}
