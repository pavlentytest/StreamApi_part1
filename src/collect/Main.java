package collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        // сумма нечетных
        /*int sum = numbers
                .stream()
                .collect(Collectors.summingInt((p) -> p%2 == 1 ? p : 0));

         */
        int sum = numbers
                .stream().mapToInt((p) -> p % 2 == 1 ? p : 0).sum();
        System.out.println(sum);

        // Вычесть из каждого элемента 1 и получить среднее
        double avg = numbers
                .stream()
                .collect(Collectors.averagingInt((p)->p-1));
        System.out.println(avg);

        // Получить сумму четных
        long sumeven = numbers
                .stream()
                .collect(Collectors.summarizingInt((p) -> p%2 == 0 ? p : 0))
                .getSum();
        System.out.println(sumeven);

        // Разделить числа на четные и нечетные
        Map<Boolean,List<Integer>> parts = numbers
                .stream()
                .collect(Collectors.partitioningBy((p) -> p%2 == 0));
        System.out.println(parts);

        List<String> strings = Arrays.asList("a1","b2","c3","a1");

        // получить массив уникальных значений из строк

        String[] result = strings
                .stream()
                .distinct()
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.asList(result));

        // Объеденить все элементы в одну строку через разделитель :
        // и обернуть тегами <b> ...</b>
        String joinString = strings
                .stream()
                .collect(Collectors.joining(" : ","<b>","</b>"));
        System.out.println(joinString);

        // Преобразовать в Map, где первый символ - ключ, второй - значение
        Map<String, String> map = strings
                .stream()
                .distinct()
                .collect(Collectors.toMap((p) -> p.substring(0,1),
                        (p) -> p.substring(1,2)));
        System.out.println(map);

        // Преобразовать в Map, отсортировать по первому символу
        Map<String,List<String>> map1 = strings
                .stream()
                .collect(Collectors.groupingBy((p) -> p.substring(0,1)));
        System.out.println(map1);


        //StringBuilder
        // Собственный коллектор, который объеденяет строки с помощь StringBuilder
        Collector<String, StringBuilder, String> collector =
                Collector.of(
                        StringBuilder::new, // метод инициализации
                        (k,s) -> k.append(s).append(", "), // метод обработки каждого элемента
                        (k,s) -> k.append(s).append(", "),
                        StringBuilder::toString
                );

        String joinResult = strings.stream().collect(collector);
        System.out.println(joinResult);

        List<String> list3 = Arrays.asList("222","234","23423");
        String res3 = String.join(", ",list3);
        System.out.println(res3);


    }
}
