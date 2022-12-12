package com.company;

public class Player {
    private String name;

    private int length;
    private int points;

    private MovementVector direction;

    //public final static int DEFAULT_LENGTH_

    public Player(String name) {
        this.name = name;
        this.direction = Settings.DEFAULT_DIRECTION;
    }

    public Player(String name, int length) {
        this.name = name;
        this.length = length;
    }

}
