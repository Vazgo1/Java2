package HW4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        List<Integer> l = List.of(2, 4, 6, 8);
        List<String> d = List.of("add","afde","asd","fdse");


        System.out.println(search(l, list -> list.indexOf(5)));

        System.out.println(StringReverse(s -> new StringBuilder(s).reverse().toString(), "озеро в лесу"));

        System.out.println(maximum(l, list -> Collections.max(l)));

        System.out.println(average(l, list -> list.stream().mapToInt(number -> number).average().getAsDouble()));

        //первая попытка задание 5 )))
        System.out.println(search1(d, list -> String.valueOf(d.stream().filter(x -> x.length() ==3  ).count())));

        System.out.println(search1(d, list -> {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i).length() == 3) && (list.get(i).charAt(0) == 'a')) {
                    result.add(list.get(i));
                }

            }
            return String.valueOf(result);

        }));
    }

    public static Integer search(List<Integer> list, Function<List<Integer>, Integer> function) {
        return function.apply(list);
    }

    public static String StringReverse(UnaryOperator<String> unaryOperator, String s) {
        return unaryOperator.apply(s);

    }

    public static Integer maximum(List<Integer> list, Function<List<Integer>, Integer> function) {
        return function.apply(list);
    }

    public static Double average(List<Integer> list, Function<List<Integer>, Double> function) {
        return function.apply(list);
    }

    public static String search1(  List<String> list, Function<List<String>, String> function) {
        return function.apply(list);
    }


}


