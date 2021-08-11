package com.example;

/**
 * Graceful termination demo.
 */
public final class App {

    private static Thread main;

    private static final long THOUSAND = 1000;

    private static final int FOUR = 4;

    private App() {
    }

    /**
     * Java Runtime Shutdown Hook demo.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("TERM");
                main.interrupt();
                for (int i = 0; i < FOUR; i++) {
                    System.out.println("busy");
                    try {
                        Thread.sleep(THOUSAND);
                    } catch (InterruptedException e) { }
                }
                System.out.println("exit");
            }
        }));

        main = Thread.currentThread();
        while (true) {
            Thread.sleep(THOUSAND);
            System.out.println("run");
        }

    }
}
