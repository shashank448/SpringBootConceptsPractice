package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("MyGameManager")
public class GameManager {

    @Autowired
    @Qualifier("ludo")
    private Game game;

    public void manage(){
        game.play();
    }


}
