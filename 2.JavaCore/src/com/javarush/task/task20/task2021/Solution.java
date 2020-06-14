package com.javarush.task.task20.task2021;

import java.io.*;

/*
Сериализация под запретом
*/
public class Solution implements Serializable {

    public static class SubSolution extends Solution {

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            throw new NotSerializableException();
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException();
        }

    }

    public static void main(String[] args) {

        String fileName = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2021\\test.txt";

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){

            SubSolution subSolution = new SubSolution();
            subSolution.writeObject(objectOutputStream);

            SubSolution subSolutionLoaded = (SubSolution) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
