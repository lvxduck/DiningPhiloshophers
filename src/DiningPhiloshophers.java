public class DiningPhiloshophers {

    static int[] chopsticks;

    public static void main(String[] args) {
        final Philosopher[] philosophers = new Philosopher[5];
        chopsticks = new int[philosophers.length];
        Gui frame = new Gui();
        frame.setVisible(true);

        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = 1;
        }

        for (int i = 0; i < philosophers.length; i++) {
            int leftChopstick= i;
            int rightChopstick = (i + 1) % chopsticks.length;
            if (i == philosophers.length - 1) {
                // Triet gia cuoi cung lay dua ben phai truoc
                philosophers[i] = new Philosopher(
                    i + 1,
                    rightChopstick,
                    leftChopstick,
                    frame
                );
            } else {
                philosophers[i] = new Philosopher(
                    i + 1,
                    leftChopstick,
                    rightChopstick,
                    frame
                );
            }
            Thread t = new Thread(philosophers[i], "Triet gia " + (i + 1));
            t.start();
        }
    }

    static void wait(int index) throws InterruptedException {
        while(chopsticks[index]<=0){
            Thread.sleep(100);
        };
        chopsticks[index]-=1;
    }

    static void signal(int index){
        chopsticks[index]+=1;
    }
}
