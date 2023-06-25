public class DifferentPeopleToString {

    public static void main(String[] args) {
        m(new GraduateStudent());
        m(new Student());
        m(new Person());
    }

    public static void m(Object x) {
        System.out.println(x.toString());
    }
}

class Person {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Student extends Person {

}

class GraduateStudent extends Student {

}