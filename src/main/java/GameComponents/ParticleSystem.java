package GameComponents;

import GameHandlers.GameObject;
import Graphics.EngineGraphics;
import Particles.Particle;
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

    @Override
    public void init() {

    }

    public void addParticles(Particle particle, int amount){
        for(int i=0; i < amount; i++){
            particles.add(particle);
        }
    }

    @Override
    public void update(double delta){
        for(int i=0; i < particles.size(); i++){
            particles.get(i).update(parent, delta);


        }

    }


    public float randomFloat(int min, int max){
        float random = min + rand.nextFloat() * (max - min);
        return  random;
    }

    @Override
    public void render(EngineGraphics g) {

    }

    public void RenderParticles(EngineGraphics g){
        for(int i=0; i < particles.size(); i++){
            particles.get(i).render(g);
        }
    }
}