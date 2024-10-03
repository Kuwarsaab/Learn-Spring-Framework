package com.Spring.Learn_Spring_Framework;
import com.Spring.Learn_Spring_Framework.game.MarioGame;
import com.Spring.Learn_Spring_Framework.game.PacmanGame;
import com.Spring.Learn_Spring_Framework.game.GameRunner;
import com.Spring.Learn_Spring_Framework.game.SuperContraGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App01GamingBasic {
    public static void main(String[] args){

//        var game1 = new MarioGame();
//        var game2 = new SuperContraGame();
//        var game3 = new PacmanGame();
//        var gameRunner = new GameRunner(game3);
//        gameRunner.run();

        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address"));
    }
}
