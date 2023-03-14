public class SynchronizedInteger {
    public static int number = 1;

    public void run(String thread) {
        for (int i = 0; i < 50; i++) {
            incrementAndGetNumber(thread);
        }
    }

    public synchronized void incrementAndGetNumber(String thread) {
        System.out.println(thread + number++);
    }
}
