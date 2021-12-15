package projjava.testprojjavafx;

public class TestClass implements Runnable {
    private int i;
    private StringBuilder s = new StringBuilder("s =");
    final int stopS = 20;

    @Override
    public void run() {
        for (i = 0; i < stopS; i++) {
            s.append(" ").append(Integer.toString(i));
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }
    }
}
