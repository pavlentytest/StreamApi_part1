package distinct;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1","a2","a2","a1","a3","a3");
        HashSet<String> hashSet = new HashSet<>(list);

        // порядок не гарантируется

        List<String> hashlist = hashSet.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
        System.out.println(hashlist);

        // порядок гарантируется

        List<String> listordered = list.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
        System.out.println(listordered);
    }
}
