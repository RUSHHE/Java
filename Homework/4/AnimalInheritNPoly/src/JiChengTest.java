/**
 * 形参 a 1 b 2
 */
public class JiChengTest {

    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub
        String name = args[0];
        String id = args[1];
        String name1 = args[2];
        String id1 = args[3];
        Animal a1 = new Hamster(name, Integer.parseInt(id));
        Animal a2 = new Mouse(name1, Integer.parseInt(id1));

        eat(a1);
        eat(a2);
    }

    public static void eat(Animal obj) {
        System.out.println("call  eat(Animal    obj)  function");
        obj.eat();

        if (obj instanceof Mouse)
        {
            eat((Mouse) obj);
        } else {
            System.out.println("is  not  a  Mouse  obj");
        }

        if (obj instanceof Hamster)
        {
            eat((Hamster) obj);
        } else {
            System.out.println("is  not  a  Hamster  obj");
        }

    }

    public static void eat(Mouse obj) {
        System.out.println("call  eat(Mouse    obj)  function");

    }

    public static void eat(Hamster obj) {
        System.out.println("call  eat(Hamster    obj)  function");
    }

}


class Animal {
    protected String name;
    protected int id;

    public Animal(String myName, int myid) {
        name = myName;
        id = myid;
    }

    public void eat() {
        System.out.println(name + "  eating,Animal");
    }

}

//  Mouse    class  extends    Animal
class Mouse extends Animal {
    public Mouse(String myName, int myid) {
        super(myName, myid);
    }

    @Override
    public void eat() {
        System.out.println(name + " eating,Mouse" + " id:" + id);
    }
}

//  Hamster  class  extends  Mouse
class Hamster extends Mouse {
    public Hamster(String myName, int myid) {
        super(myName, myid);
    }

    @Override
    public void eat() {
        System.out.println(name + " eating,Hamster" + " id:" + id);
    }
}