package patterns.structural;

/**
 * Created by dvetrov on 20.03.15.
 */
public class Adapter {
    public static void main(String[] args) {
        Math math = new Math();
        System.out.println(math.calc(new MinusAdapter(), 6, 5));
    }
}

interface Operation {
    int calc(int a, int b);
}

class Math {
    int calc(Operation operation, int a, int b) {
        return operation.calc(a, b);
    }
}

class Minus {
    public int evaluate(int a, int b) {
        return a - b;
    }
}

class MinusAdapter implements Operation {
    Minus minus = new Minus();
    public int calc(int a, int b) {
        return minus.evaluate(a, b);
    }
}