package com.kastro.lesson1;

public class JoggingRoad implements Obstacle {
    private int distance;

    public JoggingRoad(int distance) {
        this.distance = distance;
    }

    @Override
    public void use(Participant participant) {
        participant.run(distance);
    }
}

