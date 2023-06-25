class Food {
    private final double nutrition;//营养值

    public Food(double nutrition) {
        this.nutrition = nutrition;
    }

    public double getNutrition() {
        return nutrition;
    }
}

class Meat extends Food {
    public Meat() {
        super(10);
    }
}

class Starch extends Food {//淀粉
    public Starch() {
        super(5);
    }
}

class Fruits extends Food {
    public Fruits() {
        super(2);
    }
}

class Monkey {
    private final String name;
    private double weight = 5.0;

    public Monkey(String name) {
        this.name = name;
    }

    public void eat(Food food) {

        this.weight += food.getNutrition() * 0.1;
    }

    @Override
    public String toString() {
        return "Monkey{" + "name='" + name + '\'' + ",  weight=" + weight + '}';
    }
}


public class MonkeyGama {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);//N只猴子
        Monkey[] monkeys = new Monkey[N];
        for (int i = 0; i < N; i++) {
            monkeys[i] = new Monkey("Monkey" + (i + 1));//猴子编号名称
        }

        int M = Integer.parseInt(args[1]);//M次投放食物
        for (int i = 0; i < M; i++) {
            int code = Integer.parseInt(args[2 + i * 2]);//投给猴子的编号
            int type = Integer.parseInt(args[2 + i * 2 + 1]);//食物类型
            Food f = null;
            switch (type) {
                case 1:
                    f = new Meat();
                    break;
                case 2:
                    f = new Starch();
                    break;
                case 3:
                    f = new Fruits();
                    break;
            }
            if (f != null) {
                monkeys[code-1].eat(f);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(monkeys[i].toString());
        }
    }
}