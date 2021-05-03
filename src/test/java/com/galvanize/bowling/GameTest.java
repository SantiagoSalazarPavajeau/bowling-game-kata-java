package com.galvanize.bowling;




// strike 1 try
//      bonus next two balls

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void testNewGameStartAtZero(){
        Game game = new Game();
        int expectedScore = 0;

        int actualScore = game.getScore();

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testRollingBall(){
        Game game = new Game();
        int expectedRoll = 3;

        game.rollTheBall(2); // +1
        game.rollTheBall(5);// +1
        game.rollTheBall(5);// +1

        assertEquals(expectedRoll, game.getCurrentRoll());
    }

    @Test
    public void testAllGutters(){
        Game game = new Game();
        int expectedScore = 0;
        int expectedRoll = 20;

        for(int i =0; i < expectedRoll; i++){
            game.rollTheBall(0);
        }

        assertEquals(expectedRoll, game.getCurrentRoll());// 20 game is over
        assertEquals(expectedScore, game.getScore()); // score is 0
    }

    @Test
    public void testAllOnes(){
        Game game = new Game();
        int expectedScore = 20;
        int expectedRoll = 20;

        for(int i =0; i < expectedRoll; i++){
            game.rollTheBall(1);
        }

//        assertEquals(expectedRoll, game.getCurrentRoll());// 20 game is over
        assertEquals(expectedScore, game.getScore()); // score is 0
    }

    @Test
    public void testOneSpareTwoThreesAnd17Gutters(){
        Game game = new Game();
        int expectedScore = 19;

        game.rollTheBall(5);
        game.rollTheBall(5);// spare
        // spare 2 tries to 10
        //      bonus next ball
        game.rollTheBall(3);// bonus
        game.rollTheBall(3);

        for(int i =0; i < 16; i++){
            game.rollTheBall(0);
        }

        assertEquals(expectedScore, game.getScore());
    }

    @Test
    public void testStrike(){
        Game game = new Game();
        int expectedScore = 22;

        game.rollTheBall(10);
        game.rollTheBall(3);// spare
        // spare 2 tries to 10
        //      bonus next ball
        game.rollTheBall(3);// bonus

//        for(int i =0; i < 17; i++){
//            game.rollTheBall(0);
//        }

        assertEquals(expectedScore, game.getScore());
    }

    @Test
    public void testAllStrike(){
        Game game = new Game();
        int expectedScore = 300;

        for(int i =0; i < 20; i++){
            game.rollTheBall(10);
        }

        assertEquals(expectedScore, game.getScore());
    }



}