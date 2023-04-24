public class JiChengTest {

    public static void main(String[] args) {
        //    TODO    Auto-generated    method    stub
        String name = args[0];
        String id = args[1];
        String name1 = args[2];
        String id1 = args[3];
        Animal a1 = new Penguin(name, Integer.parseInt(id));
        Animal a2 = new Mouse(name1, Integer.parseInt(id1));

        a1.eat();
        ((Penguin) a1).sleep();
        a1.introduction();
        eat(new Penguin(name, Integer.parseInt(id)));

        a2.eat();
        a2.sleep();
        ((Mouse) a2).introduction();
        sleep(new Mouse(name1, Integer.parseInt(id1)));

    }

    public static void eat(Animal obj) {
        obj.eat();
    }

    public static void sleep(Animal obj) {
        obj.sleep();
    }
}

class Animal {
    private String name;
    private int id;

    public Animal(String myName, int myid) {
        name = myName;
        id = myid;
    }

    public void eat() {
        System.out.println(name + "  eating");
    }

    public void sleep() {
        System.out.println(name + "  sleeping");
    }

    public void introduction() {
        System.out.println("Hello,my  id  is  " + id + ",name  is  " + name + ".");
    }
}

//  Penguin    class
class Penguin extends Animal {
    public Penguin(String myName, int myid) {
        super(myName, myid);
    }
}

//  Mouse    class
class Mouse extends Animal {
    public Mouse(String myName, int myid) {
        super(myName, myid);
    }
}