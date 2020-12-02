
public class Main {

    static volatile int sch = 1;
    static final int repetitions = 5;
    static TextOutput textOutput = new TextOutput();

    static Object monitor = new Object();

    public static void main(String[] args) {


/*        new Thread(() -> {
            for (int i = 0; i < repetitions; i++) {
                while (sch != 1) {
                    try {
                        textOutput.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                textOutput.outputA();
                sch = 2;
                textOutput.notifyAll();
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < repetitions; i++) {
                while (sch != 2) {
                    try {
                        textOutput.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                textOutput.outputB();
                sch = 3;
                textOutput.notifyAll();
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < repetitions; i++) {
                while (sch != 3) {
                    try {
                        textOutput.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                textOutput.outputC();
                sch = 1;
                textOutput.notifyAll();
            }
        }).start();*/



        new Thread(() -> {
            for (int i = 0; i < repetitions; i++) {
                synchronized (monitor) {

                    while (sch != 1) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");;
                    sch = 2;
                    monitor.notifyAll();
                }
            }
        }).start();




        new Thread(() -> {
            for (int i = 0; i < repetitions; i++) {
                synchronized (monitor) {

                    while (sch != 2) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");;
                    sch = 3;
                    monitor.notifyAll();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < repetitions; i++) {
                synchronized (monitor) {

                    while (sch != 3) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");;
                    sch = 1;
                    monitor.notifyAll();
                }
            }
        }).start();


    }
}
