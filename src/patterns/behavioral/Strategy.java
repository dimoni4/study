package patterns.behavioral;

/**
 * Created by dvetrov on 19.03.15.
 */
public class Strategy {
    public static void main(String[] args) {
        StrategyExample strategy;
        if(!true){
            strategy = new StrategyImplA();
        } else {
            strategy = new StrategyImplB();
        }


        strategy.doSomething();
    }
}

interface StrategyExample {
    void doSomething();
}

class StrategyImplA implements StrategyExample {
    public void doSomething() {
        System.out.println("StrategyImplA.doSomething");
    }
}

class StrategyImplB implements StrategyExample {
    public void doSomething() {
        System.out.println("StrategyImplB.doSomething");
    }
}
