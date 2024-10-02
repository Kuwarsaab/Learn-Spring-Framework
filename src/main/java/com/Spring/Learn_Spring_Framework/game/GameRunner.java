package com.Spring.Learn_Spring_Framework.game;

import java.sql.SQLOutput;

public class GameRunner {
//    MarioGame game;
    private GamingConsole game;

//    public GameRunner(MarioGame game){
//        this.game = game;
//    }
    public GameRunner(GamingConsole game){
        this.game = game;
    }

    public void run(){
        System.out.println("Running Game: "+ game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
