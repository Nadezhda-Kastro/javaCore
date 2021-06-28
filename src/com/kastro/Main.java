package com.kastro;

import com.kastro.lesson3.Apple;
import com.kastro.lesson3.Box;
import com.kastro.lesson3.Orange;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(1));
        appleBox.add(new Apple(1));
        appleBox.add(new Apple(1));
        appleBox.add(new Apple(1));

        System.out.println("Вес:" + appleBox.getWeight() +"\n Содержимое: " + appleBox.getFruits());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange(1.5));
        orangeBox.add(new Orange(1.5));

        System.out.println("Вес:" + orangeBox.getWeight() +"\n Содержимое: " + orangeBox.getFruits());
        System.out.println("Равны ли: " + appleBox.compare(orangeBox));

        Box<Apple> newAppleBox = new Box<>();
        appleBox.move(newAppleBox);
        System.out.println("Old: " + appleBox.getFruits());
        System.out.println("New: " + newAppleBox.getFruits());
    }

    public void changePlace(Object[] array) {
        if (array.length > 2) {
            Object obj = array[0];
            array[0] = array[1];
            array[1] = obj;
        }
    }
}