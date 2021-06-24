package com.kastro.lesson1;

public class Cat implements Participant {

    private int height;
    private int distance;
    private boolean isRunComplete;
    private boolean isJumpComplete;

    public Cat(int height, int distance) {
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
            System.out.println("Кот не может бежать");
        } else {
            System.out.println("Кот бежит");
            isRunComplete = true;
        }
    }

    @Override
    public void jump(int height) {
        if (this.height < height) {
            System.out.println("Кот не может прыгать");
        } else {
            System.out.println("Кот прыгает");
            isJumpComplete = true;
        }
    }

    @Override
    public String whoIs() {
        return "Кот";
    }
}

