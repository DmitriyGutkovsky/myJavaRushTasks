package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу

        String filename = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\test.txt";

        try {
            File yourFile = File.createTempFile(filename, null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Ivanov");
            user.setBirthDate(new Date(2020, 05, 20));
            user.setCountry(User.Country.OTHER);
            user.setMale(true);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            if (javaRush.equals(loadedObject)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            // 1-й способ: если сделать класс User с интерфесом  Serializable

//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//            for (User user : users) {
//                objectOutputStream.writeObject(user);
//            }
//            objectOutputStream.close();

            // 2-ой способ

            PrintWriter printWriter = new PrintWriter(outputStream);
            if (!users.isEmpty()) {
                for (User user : users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate().getTime());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            // 1-й способ: если сделать класс User с интерфесом  Serializable

//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            while (inputStream.available()>0){
//            this.users.add((User)objectInputStream.readObject());
//            }
//            objectInputStream.close();

            // 2-ой способ

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                Long birthDate = Long.parseLong(reader.readLine());
                boolean isMale = Boolean.parseBoolean(reader.readLine());
                User.Country country = User.Country.valueOf(reader.readLine());

                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirthDate(new Date(birthDate));
                user.setMale(isMale);
                user.setCountry(country);

                this.users.add(user);

            }

            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
