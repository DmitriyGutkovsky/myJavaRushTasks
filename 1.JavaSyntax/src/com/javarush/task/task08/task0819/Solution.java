package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        //напишите тут ваш код. step 3 - пункт 3
        for (Cat cat : cats){
            cats.remove(cat);
            break;
        }
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> catsCreated = new HashSet<>();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        catsCreated.add(cat1);
        catsCreated.add(cat2);
        catsCreated.add(cat3);
        return catsCreated;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext()){
            Cat text = iterator.next();
            System.out.println(text);
        }

    }

    // step 1 - пункт 1
    public static class Cat{

    }

}
