package com.kastro.lesson1;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        Participant[] participants = team.getParticipants();
        for (int i = 0; i < participants.length; i++) {
            for (int y = 0; y < obstacles.length; y++) {
                obstacles[y].use(participants[i]);
            }
        }
    }
}
