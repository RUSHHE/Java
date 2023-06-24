/**
 * 5
 */
class Animal {
    public int age;
    public String name;

    public Animal() {
        System.out.print("Animal1");
    }

    public Animal(int a) {
        System.out.print("Animal2");
    }

    public void eat() {
        System.out.print("动物具有吃东西的能力");
    }
}

class Dog extends Animal {
    public Dog() {
        System.out.print("Dog1");
    }

    @Override
    public void eat() {
        System.out.print("Dog具有吃骨头的能力");
    }

    public void supermethod() {
        super.eat();
    }
}

class SmallDog extends Dog {
    public SmallDog() {
        System.out.print("SmallDog1");
    }

    public void eat() {
        System.out.print("SmallDog具有吃骨头的能力");
    }
}

public class Test1 {
    public static void main(String[] args) {
        Animal ani2 = new SmallDog();
    }
}