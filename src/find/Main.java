package find;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1","a2","a3","a1");

        // найти существуют ли все совпадения с шаблоном
        boolean flag = list.stream()
                .allMatch((s) -> s.contains("2"));
        System.out.println(flag);

        // сравнение на неравенство
        boolean flag2 = list.stream()
                .noneMatch("dfkfgk"::equals);
        System.out.println(flag2); // нет ли там этой строки




    }
}
