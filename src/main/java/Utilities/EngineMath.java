package Utilities;

import java.awt.*;
import java.util.Random;

public class EngineMath {

    public static Random rand = new Random();
    //smooth movement
    public static float Lerp(float goal, float current, float deltaTime){
        float Diff = goal - current;
        if(Diff > deltaTime) {
            return current + deltaTime;
        }
        if(Diff < -deltaTime){
            return current - deltaTime;
        }
        else
            return 0;
    }


    public static float randomFloat(int min, int max){
        float random = min + rand.nextFloat() * (max - min);
        return  random;
    }

}
