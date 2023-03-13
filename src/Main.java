import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
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