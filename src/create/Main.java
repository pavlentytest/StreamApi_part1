package create;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Stream<String> streamvalues = Stream.of("a1","a2","a3");
        System.out.println(streamvalues.collect(Collectors.toList()));

        String[] array = {"a2","a3", "a4"};
        Stream<String> streamfromarray = Arrays.stream(array);
        // печать

        // Создание из файла
        File file = new File("1.txt");
        PrintWriter out = new PrintWriter(file);
        out.println("1");
        out.println("2");
        out.println("3");
        out.close();

        Stream<String> streamFromFile = Files.lines(Paths.get(file.getAbsolutePath()));
        System.out.println(streamFromFile.collect(Collectors.toList()));

        List<String> list = Arrays.asList("a","b","c");
        Stream<String> streafromlist = list.stream();
        // печать

        // числовой стрим из строки

        System.out.println();
        IntStream streamFromString = "123".chars();
        streamFromString.forEach((t)-> System.out.print(t + ","));
        System.out.println();

        // Stream.iterate()
        Stream<Integer> integerStream = Stream.iterate(1, n->n+2);
        System.out.println(integerStream
                        .limit(5)
                        .collect(Collectors.toList()));

        // Stream.generate()
        Stream<String> generateStream = Stream.generate(() -> "hello");
        System.out.println(generateStream
                .limit(3)
                .collect(Collectors.toList()));

        Stream<String> emptyStream = Stream.empty();

        System.out.println();
        // Стрим из списка файлов по определенному пути
        Stream<Path> streamPath = Files.list(Paths.get("c:/123"));
        System.out.println(streamPath.collect(Collectors.toList()));
        System.out.println();
        // Создать стрим из текстового файла
        Path path = Files.write(Paths.get("2.txt"), "test 1\ntest2\n".getBytes());
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        Stream<String> fileStream = reader.lines();
        System.out.println(fileStream.collect(Collectors.toList()));

    }
}