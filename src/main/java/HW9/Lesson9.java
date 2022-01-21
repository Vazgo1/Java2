package HW9;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson9 {
    public static void main(String[] args) {


        String[] arrayString1 = new String[4];
        arrayString1[0] = "a";
        arrayString1[1] = "b";
        arrayString1[2] = "c";
        arrayString1[3] = "d";

        arr(arrayString1);
         swap(arrayString1, 0, 3);

         Apple apple = new Apple(1);
         Orange orange = new Orange(1);

         Box<Orange> orangeBox = new Box<>();
         Box<Apple> appleBox = new Box<>();
         orangeBox.fruitBox.add(orange);
        appleBox.fruitBox.add(apple);
        System.out.println(appleBox);
        System.out.println(orangeBox.compare(appleBox));


    }

    public static void swap(String[] arr, int n1, int n2){
        System.out.println("Массив в оригенале "+ Arrays.toString(arr));
        String s = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=s;
        System.out.println("Измененный массив "+Arrays.toString(arr));
    }

    public static <T> void arr(T[]arr){

        ArrayList<T> alt = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Массив преобразован в ArrayList "+alt);

    }

}

