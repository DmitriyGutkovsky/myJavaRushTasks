package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String catGrandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(catGrandFatherName);

        String catGrandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(catGrandMotherName);

        String catFatherName = reader.readLine();
        Cat catFather = new Cat(catFatherName, catGrandFather);
        catFather.sex = "male";

        String catMotherName = reader.readLine();
        Cat catMother = new Cat(catMotherName, catGrandMother);
        catMother.sex = "female";

        String catSonName = reader.readLine();
        Cat catSon = new Cat(catSonName, catMother, catFather);

        String catDaughterName = reader.readLine();
        Cat catDaughter = new Cat(catDaughterName, catMother, catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent;
        private Cat parent2;
        private String sex;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent) {
            this.name = name;
            this.parent = parent;
        }

        Cat(String name, Cat parent,Cat parent2){
            this.name = name;
            this.parent = parent;
            this.parent2 = parent2;
            this.sex = null;

        }

        @Override
        public String toString() {
            if (parent == null)
                return "The cat's name is " + name + ", no mother, no father";
            else if (sex == "female")
                  return "The cat's name is " + name + ", mother is " + parent.name + ", no father";
            else
                if (sex == "male")
                return ("The cat's name is " + name + ", no mother, father is " + parent.name);
            else
                return ("The cat's name is " + name + " , mother is " + parent.name + ", father is " + parent2.name);
        }

        }
    }


