package ch_1_basic_threading;

/*
Implementing the runnable interface.
We have to create a new object for this class and pass it to thread object.
We can then call the start method on thread.
 */

class Task implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 4; i++) {
            System.out.println("Count no : " + i);
        }
    }
}

class Example2 {

    public static void main(String[] args) {
        Task task = new Task();
        Thread cthread = new Thread(task);

        cthread.start();
    }
}
