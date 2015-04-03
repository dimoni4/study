package patterns.creational;

public class Singleton {

    public static void main(String[] args) {
        SingletonExample testSingletonExample = SingletonExample.getInstance();
        testSingletonExample.speak();
    }


}


class SingletonExample {

    private static SingletonExample testSingletonExample;

    private void TestSingletonExample() {
    }

    public static SingletonExample getInstance() {
        if (testSingletonExample == null) {
            synchronized (SingletonExample.class) {
                if (testSingletonExample == null) {
                    testSingletonExample = new SingletonExample();
                }
            }
        }
        return testSingletonExample;
    }

    public void speak() {
        System.out.println("HellO!");
    }
}

