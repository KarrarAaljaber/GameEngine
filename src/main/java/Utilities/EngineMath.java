package Utilities;

import java.awt.*;
import java.util.Random;

public class EngineMath {

    private static Random rand = new Random();
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

    public static Color fadeToColor(Color sColor, Color eColor, float delta, int timeToLive) {
        final Color oldColour = sColor;
        int dRed = (int) EngineMath.Lerp(eColor.getRed(), oldColour.getRed(), delta);
        int dGreen = (int) EngineMath.Lerp(eColor.getGreen(), oldColour.getGreen(), delta);
        int dBlue = (int) EngineMath.Lerp(eColor.getBlue(), oldColour.getBlue(), delta);
        Color color = new Color(dRed, dGreen, dBlue, (timeToLive /255) );


        return color;

    }
    public static float randomFloat(int min, int max){
        float random = min + rand.nextFloat() * (max - min);
        return  random;
    }

}
