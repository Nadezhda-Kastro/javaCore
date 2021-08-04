package com.kastro.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> fruits = new ArrayList<>();
//    Fruit[] fruitsArray;

    public List<T> getFruits() {
        return fruits;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void addAll(Box<T> box) {
        fruits.addAll(box.getFruits());
    }

    public void remove(T fruit) {
        fruits.remove(fruit);
    }

    public double getWeight() {
        return fruits.get(0).getWeight() * fruits.size();
    }

    public <T extends Fruit> boolean compare(Box<T> tBox) {
//        if (this.getWeight() == tBox.getWeight()) {
//            return true;
//        } else {
//            return false;
//        }

        return this.getWeight() == tBox.getWeight();
    }

    public void move(Box<T> tBox) {
        tBox.addAll(this);
        fruits.clear();
    }

}
