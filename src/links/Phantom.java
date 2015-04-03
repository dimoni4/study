package links;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;

/**
 * Created by dvetrov on 02/04/15.
 */
public class Phantom {



    public static void main(String[] args) {
        final Controller controller = new Controller();

        controller.getPhantomReferences().add(new ConnectionPhantomReference(new Connection(), controller.getQueue()));
        Thread.yield();
        Thread referenceThread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        ConnectionPhantomReference ref = (ConnectionPhantomReference)controller.getPhantomReferences().remove();
                        ref.cleanup();
                        controller.getPhantomReferences().remove(ref);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        };
        referenceThread.setDaemon(true);
        referenceThread.start();
    }
}

class ConnectionPhantomReference extends PhantomReference {
    private Connection connection;

    public ConnectionPhantomReference(Connection connection, ReferenceQueue queue) {
        super(connection, queue);
        this.connection = connection;
    }

    public void cleanup() {
        connection.close();
    }
}

class Connection {
    public void close() {
        System.out.println("Close connection");
    }
}

class Controller {
    private LinkedList phantomReferences = new LinkedList();
    private ReferenceQueue queue = new ReferenceQueue();

    public LinkedList getPhantomReferences() {
        return phantomReferences;
    }

    public void setPhantomReferences(LinkedList phantomReferences) {
        this.phantomReferences = phantomReferences;
    }

    public ReferenceQueue getQueue() {
        return queue;
    }

    public void setQueue(ReferenceQueue queue) {
        this.queue = queue;
    }
}