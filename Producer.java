package producerconsumer;

public class Producer extends Thread {
    private MessageBoard board;

    public Producer(MessageBoard b) {
        this.board = b;
    }

    @Override
    public void run() {
        String[] msgs = {
            "Exam on Monday",
            "Holiday on Tuesday",
            "Workshop on Wednesday"
        };

        for (String msg : msgs) {
            board.put(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
