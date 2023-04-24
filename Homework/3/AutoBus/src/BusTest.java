class Auto {
    double speed;

    public void start() {
        System.out.println("The auto is started.");
    }

    public void speedUp(double speed) {
        this.speed += speed;
        System.out.printf("The auto is speed up to %.1fkilo/h.\n",this.speed);
    }

    public void stop() {
        System.out.println("The auto is stopped.");
    }
}

class Bus extends Auto {
    int passenger;
    public void gotOn(int on) {
        passenger += on;
        System.out.println("The person on bus is: " + passenger);
    }

    public void gotOff(int off) {
        passenger -= off;
        System.out.println("The person on bus is: " + passenger);
    }
}

public class BusTest {
    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.start();
        bus.speedUp(60);
        bus.stop();
        bus.gotOn(10);
        bus.gotOff(5);
    }
}
