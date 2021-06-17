package com.kastro.lesson1;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void use(Participant participant) {
        participant.jump(height);
    }
}
