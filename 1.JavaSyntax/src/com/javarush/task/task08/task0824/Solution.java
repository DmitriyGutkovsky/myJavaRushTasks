package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandFather1 = new Human();
        grandFather1.name = "FirstGrandFather";
        grandFather1.age = 69;
        grandFather1.sex = true;


        Human grandMother1 = new Human();
        grandMother1.name = "FirstGrandMother";
        grandMother1.age = 68;
        grandMother1.sex = false;

        Human grandFather2 = new Human();
        grandFather2.name = "FirstGrandFather";
        grandFather2.age = 72;
        grandFather2.sex = true;

        Human grandMother2 = new Human();
        grandMother2.name = "FirstGrandMother";
        grandMother2.age = 71;
        grandMother2.sex = false;

        Human father = new Human();
        father.name = "Father";
        father.age = 45;
        father.sex = true;
        grandFather1.children.add(father);
        grandMother1.children.add(father);

        Human mother = new Human();
        mother.name = "Mother";
        mother.age = 40;
        mother.sex = false;
        grandFather2.children.add(mother);
        grandMother2.children.add(mother);

        Human child1 = new Human();
        child1.name = "Child1";
        child1.age = 10;
        child1.sex = true;
        father.children.add(child1);
        mother.children.add(child1);

        Human child2 = new Human();
        child2.name = "Child2";
        child2.age = 10;
        child2.sex = true;
        father.children.add(child2);
        mother.children.add(child2);

        Human child3 = new Human();
        child3.name = "Child3";
        child3.age = 10;
        child3.sex = true;
        father.children.add(child3);
        mother.children.add(child3);

        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
