package lectures.recursion;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Timer {

    /**
     * @author Oscar
     */
    private long startTime, stopTime;
    private final NumberFormat formatter = new DecimalFormat("#0.000000000");

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        stopTime = System.currentTimeMillis();
    }

    public String toString() {
        return formatter.format((stopTime - startTime) / 1000d);
    }

    public long getTime() {
        return stopTime - startTime;
    }

    public static void main(String[] args) {
        Timer t = new Timer();
        t.startTimer();
        int b =0;
        for(int i = 0; i<10; i++) {
            for (int j = 0; j < 10; j++)
                b = i * j;
        }
        t.stopTimer();
        System.out.println(t.getTime()/1000+" seconds");
    }
}
