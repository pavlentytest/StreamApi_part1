package filterandcount;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;




public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1","a2","a3","a1");

        // Количество вхождений
        long count = list
                .stream()
                .filter("a1"::equals).count();
        System.out.println(count);

        System.out.println();

        // выбрать все элементы по шаблону
        List<String> result = list
                .stream()
                .filter((s)->s.contains("1"))
                .collect(Collectors.toList());
        System.out.println(result);


        List<Student> students = Arrays.asList(
                new Student("Ivan", 20, 1),
                new Student("Petr",18,2),
                new Student("Olga",15,1),
                new Student("Maria",19, 3)
        );


        // Найти средний возраст в группе 1
        double avg = students
                .stream()
                .filter((p)->p.getGroup()==1)
                .mapToInt(Student::getAge)
                .average()
                .getAsDouble();
        System.out.println(avg);

        // выбрать всех студентов, в диапазоне возраста
        List<Student> agesList =
                students.stream()
                        .filter((p)-> p.getAge() >= 16
                        && p.getAge() <= 24)
                        .collect(Collectors.toList());
        System.out.println(agesList);



    }
}
class Student {
    private String name;
    private Integer age;

    private Integer group;

    public Student(String name, Integer age, Integer group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }
}
