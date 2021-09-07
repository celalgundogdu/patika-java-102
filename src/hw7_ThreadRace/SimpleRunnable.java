package hw7_ThreadRace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleRunnable implements Runnable{

    private int threadId;
    ArrayList<Integer> numberList;
    ArrayList<Integer> evenList;
    ArrayList<Integer> oddList;
    private final Object LOCK;

    public SimpleRunnable() {
        threadId = 1;
        numberList = IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(ArrayList::new));
        evenList = new ArrayList<>();
        oddList = new ArrayList<>();
        LOCK = new Object();
    }

    @Override
    public void run() {
        int startIndex, lastIndex;

        synchronized (LOCK){
            startIndex = (this.threadId - 1) * 2500;
            lastIndex = (this.threadId) * 2500;
            this.threadId += 1;
        }

        List<Integer> subList = this.numberList.subList(startIndex, lastIndex);
        System.out.println(Thread.currentThread().getName() + " : " + subList);
        subList.forEach(number -> {
            if (number % 2 == 0){
                this.evenList.add(number);
            }else {
                this.oddList.add(number);
            }
        });
    }

}
