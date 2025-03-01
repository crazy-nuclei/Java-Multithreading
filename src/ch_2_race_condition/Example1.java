package ch_2_race_condition;

/*

Since both the threads are trying to access the same counter.
There is possibility of simultaneous access of the data.
Therefore, the final count value will be less 2000.

This is called as race condition.
 */

class Counter {
    private int count;

    public void increment() {
        count += 1;
    }

    public int getCount() {
        return count;
    }
}

public class Example1 {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

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
