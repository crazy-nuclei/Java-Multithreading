package ch_3_deadlock;

/*
In this case the two threads will keep waiting for each other to release the resource.

To avoid this use :
    Lock Ordering
    Use tryLock()

 */

class Thing {
    public String name;

    Thing(String name) {
        this.name = name;
    }
}

public class Example1 {
    public static void main(String[] args) throws  InterruptedException {
        final Thing thing1 = new Thing("one");
        final Thing thing2 = new Thing("two");

        Thread thread1 = new Thread(() -> {
            synchronized (thing1) {
                System.out.println(Thread.currentThread().getName() + " acquired " + thing1.name);
                try {Thread.sleep(100);} catch (InterruptedException e) {}
                synchronized (thing2) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + thing2.name);
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            synchronized (thing2) {
                System.out.println(Thread.currentThread().getName() + " acquired " + thing2.name);
                try {Thread.sleep(100);} catch (InterruptedException e) {}
                synchronized (thing1) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + thing1.name);
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
