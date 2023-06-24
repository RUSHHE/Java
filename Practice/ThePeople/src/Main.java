interface ServeThePeople {
    void Service();
}

public class Main {
    public static void main(String[] args) {
        new Teacher();
        new Doctor();
        new Police();
        new Solider();
        new Others();
    }
}

class Teacher implements ServeThePeople {

    public Teacher() {
        Service();
    }

    @Override
    public void Service() {
        System.out.println("Preach,Knowledge,Dispels doubt.");
    }
}

class Doctor implements ServeThePeople {

    public Doctor() {
        Service();
    }

    @Override
    public void Service() {
        System.out.println("heal the wounded and rescue the dying.");
    }
}

class Police implements ServeThePeople {

    public Police() {
        Service();
    }

    @Override
    public void Service() {
        System.out.println("uphold the rule of law.");
    }
}

class Solider implements ServeThePeople {

    public Solider() {
        Service();
    }

    @Override
    public void Service() {
        System.out.println("protect our homes and defend our country.");
    }
}

class Others implements ServeThePeople {

    public Others() {
        Service();
    }

    @Override
    public void Service() {
        System.out.println("Do your job.");
    }
}