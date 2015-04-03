package concurrancy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dvetrov on 20.03.15.
 */
public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOn(car));
        executorService.execute(new WaxOff(car));
        Thread.sleep(3000);
        executorService.shutdownNow();
    }
}

class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car car) {
        this.car = car;
    }
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax on!");
                Thread.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exit Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car car) {
        this.car = car;
    }
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax off!");
                Thread.sleep(200);
                car.buffed();
                car.waitForWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exit Wax Off task");
    }
}