public class Change {

    public static void main(String[] args) throws InterruptedException {
        //  TODO  Auto-generated  method  stub
        for (int i = 0; i < 5; i++) {
            new Cattle().start();
        }
    }

}

class Cattle extends Thread {
    public void run() {
        Louse louse = new Louse();
        System.out.println("Thread " + this.getId() + ": I'm " + Louse.count + " louse.");
    }
}

class Louse {
    public static int count = 0;

    Louse() {
        cale();
    }

    private void cale() {
        count++;
    }
}
