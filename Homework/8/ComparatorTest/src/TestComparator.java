import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    int rollno;
    String name;
    int age;

    Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }
}

//AgeComparator比较器
class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.age, o2.age);
    }
}

//NameComparator  比较器
class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class TestComparator {
    public static void main(String[] args) {

        ArrayList<Student> al = new ArrayList<Student>();
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));
        al.add(new Student(102, "KJai", 22));
        al.add(new Student(104, "KJai", 21));

        System.out.println("Sorting by Name");

        Collections.sort(al, new NameComparator());

        for (Student st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

        System.out.println("sorting  by  Age");

        Collections.sort(al, new AgeComparator());

        for (Student st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

        System.out.println("sorting  by  Rollno");
        //lambda  表达式的匿名比较器定义，通过比较rollno属性，rollno属性值唯一，不会存在相等的情况
        Collections.sort(al, Comparator.comparingInt(o -> o.rollno));

        for (Student st : al) {
            System.out.println(st.rollno + "  " + st.name + "  " + st.age);
        }
    }
}