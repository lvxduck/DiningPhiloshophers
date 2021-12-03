import java.util.Random;

public class Philosopher implements Runnable {
    private final Random numGenerator = new Random();
    private int philNumber;
    final private int leftFork;
    final private int rightFork;
    private Gui frame;

    public Philosopher(int philNumber, int leftFork, int rightFork, Gui frame) {
        this.philNumber = philNumber;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.frame = frame;
    }

    @Override
    public void run() {
        try {
            while (true) {
                DiningPhiloshophers.wait(leftFork);
                frame.philosopherPickLeftFork(philNumber);
                DiningPhiloshophers.wait(rightFork);
                frame.philosopherPickRightFork(philNumber);
                eat();
                DiningPhiloshophers.signal(leftFork);
                frame.philosopherPutDownLeftFork(philNumber);
                DiningPhiloshophers.signal(rightFork);
                frame.philosopherPutDownRightFork(philNumber);
                think();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        frame.PhilosopherThinking(philNumber);
        Thread.sleep(numGenerator.nextInt(3000)+2000);
    }

    private void eat() throws InterruptedException {
        frame.PhilosopherEating(philNumber);
        Thread.sleep(numGenerator.nextInt(3000)+2000);
    }
}