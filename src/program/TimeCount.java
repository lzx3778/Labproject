package program;

import javax.swing.*;

/**
 * Created by lenovo on 2017-2-17.
 */
public class TimeCount implements Runnable{

    private static Thread thread;

    private static double timeNumber;
    private static boolean isCountDown;
    private static boolean isCountUp;

    public TimeCount(){
        initialize();
        thread = new Thread(this);
        thread.start();
    }

    private static void initialize(){
        timeNumber = 0;
        isCountDown = false;
        isCountUp = false;
    }

    private static void setTimeNumber(double t){
        timeNumber = t;
    }

    public static double getTimeNumber(){
        return timeNumber / 100;
    }

    public static void startCountDown(double countdownTime){
        setTimeNumber(countdownTime * 100);
        isCountDown = true;
        isCountUp = false;
    }

    public static void startCountUp(){
        setTimeNumber(0);
        isCountUp = true;
        isCountDown = false;
    }

    public static void stop(){
        initialize();
    }

    @Override
    public void run() {
        while (true){
            if (timeNumber >= 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isCountDown) {
                    timeNumber--;
                } else if (isCountUp) {
                    timeNumber++;
                } else {
                    stop();
                }
            }else {
                timeNumber = 0;
            }

        }
    }
}
