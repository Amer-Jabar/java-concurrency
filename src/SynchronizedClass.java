import java.util.concurrent.atomic.AtomicReference;

public class SynchronizedClass {
    int number = 0;
    public void incrementWithLockHeld() {
        synchronized (this) {
            System.out.println(++number);
        }
    }

}
