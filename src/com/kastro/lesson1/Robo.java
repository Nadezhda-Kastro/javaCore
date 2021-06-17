package com.kastro.lesson1;

public class Robo implements Participant {

    private int height;
    private int distance;
    private boolean isRunComplete;
    private boolean isJumpComplete;

    public Robo(int height, int distance) {
        this.height = height;
        this.distance = distance;
    }

    @Override
    public boolean isComplete() {
        return isRunComplete && isJumpComplete;
    }

    @Override
    public void run(int distance) {

        if (this.distance < distance) {
            System.out.println("Робот не может бежать");
        } else {
            System.out.println("Робот бежит");
            isRunComplete = true;
        }
    }

    @Override
    public void jump(int height) {
        if (this.height < height) {
            System.out.println("Робот не может прыгать");
        } else {
            System.out.println("Робот прыгает");
            isJumpComplete = true;
        }
    }

    @Override
    public String whoIs() {
        return "Робот";
    }
}


