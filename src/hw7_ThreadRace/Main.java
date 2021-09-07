package hw7_ThreadRace;

public class Main {

    public static void main(String[] args) {

        SimpleRunnable simpleRunnable = new SimpleRunnable();
        Thread thread1 = new Thread(simpleRunnable);
        Thread thread2 = new Thread(simpleRunnable);
        Thread thread3 = new Thread(simpleRunnable);
        Thread thread4 = new Thread(simpleRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

}
