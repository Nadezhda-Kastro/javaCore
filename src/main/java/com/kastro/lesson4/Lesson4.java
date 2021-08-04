package com.kastro.lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.

public class Lesson4 {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>();
        wordsList.add("яблоко");
        wordsList.add("азбука");
        wordsList.add("лимон");
        wordsList.add("скакалка");
        wordsList.add("яблоко");
        wordsList.add("лимон");
        wordsList.add("яблоко");
        wordsList.add("арбуз");
        wordsList.add("кофе");
        wordsList.add("авокадо");
        wordsList.add("помидор");

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : wordsList) {

            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }

        }
        System.out.println("Уникальные слова: " + wordsMap.keySet());
        System.out.println("Количество слов: " + wordsMap);

        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add("Смирнова", "89885454852");
        phoneDictionary.add("Косицын", "89885412345");
        phoneDictionary.add("Иванова", "89995402332");
        phoneDictionary.add("Иванов", "89881122352");
        phoneDictionary.add("Иванов", "89258528352");

        System.out.println(phoneDictionary.get("Смирнова"));
        System.out.println(phoneDictionary.get("Иванов"));
    }
}


