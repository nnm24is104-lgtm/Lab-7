package producerconsumer;

public class Consumer extends Thread {
    private MessageBoard board;

    public Consumer(MessageBoard b) {
        this.board = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            board.get();
        }
    }
}
