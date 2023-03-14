import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        synchronizedIntegerClassDemo();
    }

    public static void synchronizedIntegerClassDemo() throws InterruptedException {
        SynchronizedInteger integer = new SynchronizedInteger();

        Thread t1 = new Thread(() -> integer.run("1. "));
        Thread t2 = new Thread(() -> integer.run("2. "));
        Thread t3 = new Thread(() -> integer.run("3. "));

        t1.start();
        t2.start();
        t3.start();
    }

    public static void synchronizedClassDemo() {
        Timer timer1 = new Timer();
        Timer timer2 = new Timer();
        Timer timer3 = new Timer();
        Timer timer4 = new Timer();
        Timer timer5 = new Timer();

        SynchronizedClass synchronizedClass = new SynchronizedClass();

        List.of(timer1, timer2, timer3, timer4, timer5).forEach(timer -> {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    synchronizedClass.incrementWithLockHeld();
                }
            }, 0, 10);
        });
    }
}