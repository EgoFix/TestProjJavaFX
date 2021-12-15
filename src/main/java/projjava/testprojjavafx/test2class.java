package projjava.testprojjavafx;

public class test2class implements Runnable {

    @Override
    public void run() {
        int f;
        final int stopF = 25;
        StringBuilder sb = new StringBuilder("sb =");

        for (f = 0; f < stopF; f++) {
            sb.append(" ").append(Integer.toString(f));
            System.out.println(sb);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
