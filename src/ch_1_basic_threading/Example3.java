package ch_1_basic_threading;

/*
Thread can be in different states
 */

class Cthread extends Thread {
    public void run() {
        try {
            System.out.println("Thread State 1: " + getState());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Example3 {

    public static void main(String[] args)  throws InterruptedException {
        Cthread cthread = new Cthread();
        System.out.println("Thread State 0: " + cthread.getState());
        cthread.start();
        Thread.sleep(500);
        System.out.println("Thread State 2: " + cthread.getState());
        cthread.join();
        System.out.println("Thread State 4: " + cthread.getState());
    }
}
