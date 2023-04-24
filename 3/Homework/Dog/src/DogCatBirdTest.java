public class DogCatBirdTest {
    public static void main(String[] args) {
        Dog dog = new Dog(12, 5);
        Cat cat = new Cat();
        cat.setAge(3);
        cat.setWeight(6);
        Bird bird = new Bird(1, 2);
        dog.run();
        cat.run();
        cat.jump();
        bird.fly();
    }
}

class Animal {
    double weight;
    int age;

    public Animal(double weight,int age) {
        setWeight(weight);
        setAge(age);
    }

    public Animal() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

class Dog extends Animal {
    public Dog(double weight, int age) {
        super(weight, age);
    }

    public void run() {
        System.out.println("Dog run...");
    }

    public void jump() {
        System.out.println("Dog jump...");
    }
}

class Cat extends Animal {
    public Cat(double weight, int age) {
        super(weight, age);
    }

    public Cat() {
        super();
    }

    public void run() {
        System.out.println("Cat run...");
    }

    public void jump() {
        System.out.println("Cat jump...");
    }
}

class Bird extends Animal {
    public Bird(double weight, int age) {
        super(weight, age);
    }

    public void fly() {
        System.out.println("Bird fly...");
    }

    public void jump() {
        System.out.println("Bird jump...");
    }
}