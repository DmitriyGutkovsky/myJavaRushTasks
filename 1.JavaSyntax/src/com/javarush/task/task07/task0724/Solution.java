package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        Human grandFather1 = new Human("Dima",true, 69);
        Human grandMother1 = new Human("Nastya", false, 64);
        Human grandFather2 = new Human("Maksim", true, 72);
        Human grandMother2 = new Human("Olay", false, 64);
        Human father = new Human("Jenay", true, 32, grandFather1, grandMother1);
        Human mother = new Human("Polay", false, 27, grandFather2, grandMother2);
        Human sun1 = new Human("Kolya", true, 4, father, mother);
        Human sun2 = new Human("Timofei", true, 2, father, mother);
        Human daughter = new Human("Kseniya", false, 1, father, mother);


        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(sun1);
        System.out.println(sun2);
        System.out.println(daughter);
    }

    public static class Human {
        // напишите тут ваш код
        private  String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}