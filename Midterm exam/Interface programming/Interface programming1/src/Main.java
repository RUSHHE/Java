interface ToDrink {
    void drink();
}

public class Main {
    public static void main(String[] args) {
        new Baby(args[0]).drink();
        new YoungPeople(args[1]).drink();
        new Adult(args[2]).drink();
    }
}

class Baby implements ToDrink {
    private final String Drinking;

    public Baby(String Drinking) {
        this.Drinking = Drinking;
    }

    @Override
    public void drink() {
        System.out.println(Drinking + "...");
    }
}

class YoungPeople implements ToDrink {
    private final String Drinking;

    public YoungPeople(String Drinking) {
        this.Drinking = Drinking;
    }
    @Override
    public void drink() {
        System.out.println(Drinking + "...");
    }
}

class Adult implements ToDrink {
    private final String Drinking;

    public Adult(String Drinking) {
        this.Drinking = Drinking;
    }
    @Override
    public void drink() {
        System.out.println(Drinking + "...");
    }
}