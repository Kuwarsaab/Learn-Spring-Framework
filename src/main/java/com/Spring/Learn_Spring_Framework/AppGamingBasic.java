package com.Spring.Learn_Spring_Framework;
import com.Spring.Learn_Spring_Framework.game.MarioGame;
import com.Spring.Learn_Spring_Framework.game.GameRunner;
import com.Spring.Learn_Spring_Framework.game.SuperContraGame;

public class AppGamingBasic {
    public static void main(String[] args){

//        var marioGame = new MarioGame();
        var superContra = new SuperContraGame();
        var gameRunner = new GameRunner(superContra);
        gameRunner.run();
    }
}
