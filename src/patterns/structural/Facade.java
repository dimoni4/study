package patterns.structural;

/**
 * Created by dvetrov on 20.03.15.
 */
public class Facade {
    public static void main(String[] args) {
        Math math = new Math();
        System.out.println(math.multiply(3, 2));
        System.out.println(math.sum(3, 2));
    }

    interface Operation {
        int calc(int a, int b);
    }

    static class Sum implements Operation {
        public int calc(int a, int b) {
            return a + b;
        }
    }

    static class Multiply implements Operation {
        public int calc(int a, int b) {
            return a * b;
        }
    }

    private static class Math {
        Sum sum = new Sum();
        Multiply multiply = new Multiply();

        public int sum(int a, int b) {
            return sum.calc(a, b);
        }

        public int multiply(int a, int b) {
            return multiply.calc(a, b);
        }
    }
}