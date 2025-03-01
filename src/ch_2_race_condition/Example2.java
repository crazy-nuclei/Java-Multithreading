package ch_2_race_condition;

/*
By using the synchronized keyword the increment function
will only be accessed by one thread at a time.

synchronized makes it a critical section.

Final value of count will always be 2000.

synchronized keyword can also be used on a code block.
 */

class CounterS {
    private int count;

    public synchronized void increment() {
        count += 1;
    }

    public int getCount() {
        return count;
    }
}


public class Example2 {
    public static void main(String[] args) throws InterruptedException {

        CounterS counter = new CounterS();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final count : " + counter.getCount());
    }
}
