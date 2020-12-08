package model;

import java.util.Set;

public class Player {
    private int iDPlayer;
    private String name;
    private static int hp;
    private Set listCards;

    private Player(){};
    private Player(int iDPlayer,String name, int HP){
        this.iDPlayer=iDPlayer;
        this.name=name;
    }
}
