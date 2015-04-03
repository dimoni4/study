package patterns.structural;

/**
 * Created by dvetrov on 20.03.15.
 */
public class Proxy {
    public static void main(String[] args) {
        Car car = new CarProxy();
        car.doSmth();
    }
}

interface Car {
    void doSmth();
}

class CarImpl implements Car {
    public void doSmth() {
        System.out.println("Car - doSmth");
    }
}

class CarProxy implements Car {
    Car car = new CarImpl();
    public void doSmth() {
        System.out.println("CarProxy - doSmth");
        car.doSmth();
    }
}