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
    public void placeParticles(int spreadX, int spreadY){
        for(int i=0; i < particles.size(); i++){
            particles.get(i).setPosition(new Vector2f(  particles.get(i).getPosition().getX() + spreadX, particles.get(i).getPosition().getY() + spreadY));
        }
    }

    @Override
    public void init() {

    }


    public void addParticles(Particle particle, int amount){
        for(int i=0; i < amount; i++){
            particles.add(particle);
        }
    }
    public void addParticles(ArrayList<Particle> particle){
        for(int i=0; i < particle.size(); i++){
            particles.add(particle.get(i));
        }
    }

    @Override
    public void update(float delta){
        for(int i=0; i < particles.size(); i++){
            particles.get(i).update( delta);

            if(particles.get(i).getTimeToLive() <=0){
                particles.remove(i);
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
