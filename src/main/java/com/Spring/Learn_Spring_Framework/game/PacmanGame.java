package com.Spring.Learn_Spring_Framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole{
    public void up(){
        System.out.println("UP");
    }
    public void down(){
        System.out.println("DOWN");
    }
    public void left(){
        System.out.println("LEFT");
    }
    public void right(){
        System.out.println("RIGHT");
    }
    
}
