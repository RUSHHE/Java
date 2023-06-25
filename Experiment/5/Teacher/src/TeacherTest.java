public class TeacherTest {

    public static void main(String[] args) {
        CommonTeacher ct = new CommonTeacher(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        System.out.println(ct.pay());

        HighTeacher ht = new HighTeacher(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        System.out.println(ht.pay());

        SuperfineTeacher st = new SuperfineTeacher(Double.parseDouble(args[4]), Double.parseDouble(args[5]));
        System.out.println(st.pay());
    }
}

class Teacher {
    double rate;
    double baseSalary;

    public Teacher(double rate,double baseSalary) {
        this.rate = rate;
        this.baseSalary = baseSalary;
    }
    public double pay() {
        return baseSalary * rate;
    }
}

class
CommonTeacher extends Teacher {
    public CommonTeacher(double rate, double baseSalary) {
        super(rate, baseSalary);
    }

    @Override
    public double pay() {
        return baseSalary * rate + 1000;
    }
}

class HighTeacher extends Teacher {
    public HighTeacher(double rate, double baseSalary) {
        super(rate, baseSalary);
    }

    @Override
    public double pay() {
        return baseSalary * rate + 2000;
    }
}

class SuperfineTeacher extends Teacher{
    public SuperfineTeacher(double rate, double baseSalary) {
        super(rate, baseSalary);
    }

    @Override
    public double pay() {
        return baseSalary * rate + 3000;
    }
}
