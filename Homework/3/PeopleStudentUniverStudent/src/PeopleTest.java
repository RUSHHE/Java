public class PeopleTest {

    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub
        Student zhangsan = new Student();
        zhangsan.age = 17;
        zhangsan.number = 100101;
        zhangsan.showPeopleMess();
        zhangsan.tellNumber();
        int x = 9, y = 29;
        System.out.print("add:");
        int result = zhangsan.add(x, y);
        System.out.printf("%d+%d=%d\n", x, y, result);
        UniverStudent lisi = new UniverStudent();
        lisi.age = 21;
        lisi.number = 6609;
        lisi.showPeopleMess();
        lisi.tellNumber();
        System.out.print("add:");
        result = lisi.add(x, y);
        System.out.printf("%d+%d=%d\t", x, y, result);
        System.out.print("multi:");
        result = lisi.multi(x, y);
        System.out.printf("%dX%d=%d\n", x, y, result);
    }
}

class People {
    int age, leg = 2, hand = 2;

    protected void showPeopleMess() {
        System.out.printf("age:%d,foot:%d,hand:%d\t", age, leg, hand);
    }
}

class Student extends People {
    int number;

    public void tellNumber() {
        System.out.print("number:" + number + "\t");
    }

    public int add(int x, int y) {
        return x + y;
    }
}

class UniverStudent extends Student {
    public int multi(int x, int y) {
        return x * y;
    }
}
