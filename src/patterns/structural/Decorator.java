package patterns.structural;

/**
 * Created by dvetrov on 20.03.15.
 */
public class Decorator {
    public static void main(String[] args) {
        Message message = new HelloMessage();
        message.print("hello");
        Message message2 = new WelcomeMessageDecorator(new WorldMessageDecorator(new HelloMessage()));
        message2.print("hello");
    }
}

interface Message {
    void print(String message);
}

class HelloMessage implements Message {
    public void print(String messageString) {
        System.out.println(messageString);
    }
}

class MessageDecorator implements Message {

    Message message;

    MessageDecorator(Message message) {
        this.message = message;
    }

    public void print(String messageString) {
        message.print(messageString);
    }
}

class WorldMessageDecorator extends MessageDecorator {

    WorldMessageDecorator(Message message) {
        super(message);
    }

    @Override
    public void print(String messageString) {
        super.print(messageString + "World");
    }
}

class WelcomeMessageDecorator extends MessageDecorator {
    WelcomeMessageDecorator(Message message) {
        super(message);
    }
    @Override
    public void print(String messageString) {
        super.print("Welcome"+messageString);
    }
}
