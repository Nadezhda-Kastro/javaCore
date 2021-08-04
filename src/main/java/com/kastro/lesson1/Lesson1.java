package com.kastro.lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human(2, 9),
                new Cat(1, 1),
                new Robo(5, 100)
        };
        Obstacle[] obstacles = {
                new Wall(1),
                new JoggingRoad(10)
        };

        Course course = new Course(obstacles);
        Team team = new Team("команда", participants);
        course.doIt(team);
        team.showResult();
    }

}
