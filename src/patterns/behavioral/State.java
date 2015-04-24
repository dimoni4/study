package patterns.behavioral;

/**
 * Created by dvetrov on 24/04/15.
 */
public abstract class State {
    Context context;

    public State(Context context) {
        this.context = context;
    }

    public void goNext() {
        throw new UnsupportedOperationException();
    }
}

class ClientState {
    public static void main(String[] args) {
        Context context = new Context();
        context.goNext();
        context.goNext();
        context.goNext();
        context.goNext();
        context.goNext();
        context.goNext();
        context.goNext();
        context.goNext();
        context.goNext();
        context.goNext();
        context.goNext();
    }
}

class Context {
    State state;

    public Context() {
        this.state = new AState(this);
    }

    public void goNext() {
        state.goNext();
    }

    public void setState(State state) {
        this.state = state;
    }
}

class AState extends State {
    public AState(Context context) {
        super(context);
    }

    @Override
    public void goNext() {
        System.out.println("A -> B");
        context.setState(new BState(context));
    }
}

class BState extends State {
    public BState(Context context) {
        super(context);
    }

    @Override
    public void goNext() {
        System.out.println("B -> C");
        context.setState(new CState(context));
    }
}

class CState extends State {
    public CState(Context context) {
        super(context);
    }

    @Override
    public void goNext() {
        System.out.println("C -> A");
        context.setState(new AState(context));
    }
}