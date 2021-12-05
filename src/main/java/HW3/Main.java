package HW3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String name;

        String[] arrays =  {"Петров","Сидоров","Носков","Павлов","Дьяков","Самощенко","Вартанов","Петров","Сидоров","Носков"};


Arrays.uniqueness(arrays);

        Phonebook pb = new Phonebook();

        pb.add("Ivanov", "123");
        pb.add("Petrov", "456");
        pb.add("Petrov", "789");

        System.out.println(pb.get("Petrov"));






    }
}
