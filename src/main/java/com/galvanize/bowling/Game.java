package com.galvanize.bowling;

import java.util.HashMap;

public class Game {

    private int[] scores = new int[20];
    private int totalScore = 0;
    private int currentRoll = 0;

    public int getCurrentRoll(){
        return currentRoll;
    }

    public void rollTheBall(int points){
        scores[currentRoll++] = points;
    }

    public int getScore(){
        int j = 0; // pointer for frame
        int i = 0; // pointer for turn/game

        while(i < 10) {
            if(scores[j] == 10){ // strike
                totalScore += 10 + scores[j +1] + scores[j + 2];
                j++;
            }else if( scores[j] + scores[j+1] == 10){ // spare
                totalScore += 10 + scores[j+2];
                j+= 2;
            }else { // only pins thrown down
                totalScore += scores[j] + scores[j + 1];
                j += 2;
            }
            i++;
        }

        return totalScore;
    }

}
