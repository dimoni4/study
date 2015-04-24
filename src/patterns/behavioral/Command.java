package patterns.behavioral;

/**
 * Created by dvetrov on 24/04/15.
 */
public interface Command {
    public void execute();
}

class Client {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setButton1Command(new LightOnCommand(light));
        remoteControl.setButton2Command(new LightOffCommand(light));

        remoteControl.pressButton1();
        remoteControl.pressButton2();
    }
}

class RemoteControl {
    private Command button1Command;
    private Command button2Command;

    public void pressButton1() {
        button1Command.execute();
    }

    public void pressButton2() {
        button2Command.execute();
    }

    public void setButton1Command(Command button1Command) {
        this.button1Command = button1Command;
    }

    public void setButton2Command(Command button2Command) {
        this.button2Command = button2Command;
    }
}

class LightOnCommand implements Command {
    Light light;

    @Override
    public void execute() {
        light.on();
    }

    public LightOnCommand(Light light) {
        this.light = light;
    }
}


class LightOffCommand implements Command {
    Light light;

    @Override
    public void execute() {
        light.off();
    }

    public LightOffCommand(Light light) {
        this.light = light;
    }
}

class Light {
    private boolean on = false;

    public void on() {
        System.out.println("Light on!");
        on = true;
    }

    public void off() {
        System.out.println("Light off!");
        on = false;
    }
}