package ch_3_deadlock;

/*
Use the same lock ordering in both threads.
This way we can overcome deadlocks.
 */

class Thing1 {
    public String name;

    Thing1(String name) {
        this.name = name;
    }
}

public class Example2 {

    public static void main(String[] args) {
        final Thing1 thing1 = new Thing1("one");
        final Thing1 thing2 = new Thing1("two");

        Thread thread1 = new Thread(() -> {
            synchronized (thing1) {
                System.out.println(Thread.currentThread().getName() + " acquired " + thing1.name);
                synchronized (thing2) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + thing2.name);
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            synchronized (thing1) {
                System.out.println(Thread.currentThread().getName() + " acquired " + thing1.name);
                synchronized (thing2) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + thing2.name);
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
