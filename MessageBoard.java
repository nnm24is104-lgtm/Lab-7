package producerconsumer;

public class MessageBoard {
    private String message;
    private boolean hasMessage = false;

    public synchronized void put(String msg) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        message = msg;
        hasMessage = true;
        System.out.println("Producer sends: " + msg);
        notify();
    }

    public synchronized String get() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String msg = message;
        hasMessage = false;
        System.out.println("Consumer reads: " + msg);
        notify();
        return msg;
    }
}
