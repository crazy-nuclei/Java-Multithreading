package ch_1_basic_threading;

/*
Extending the thread class and overriding the run method from it.
Create a new object and call the start method to run the thread.

Major difference between extending thread class and implementing runnable interface
is that we can implement other interfaces as well in runnable interface.
Runnable interface is used when we want to share same tasks between multiple threads.
 */

class CustomThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Count no : " + i);
        }
    }
}

class Example1 {

    public static void main(String[] args) {
        CustomThread cthread = new CustomThread();
        cthread.start();
    }
}
