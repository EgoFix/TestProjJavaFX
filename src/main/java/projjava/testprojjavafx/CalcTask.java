package projjava.testprojjavafx;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.text.Text;



public class CalcTask extends Task {
    @Override
    public Void call() {
        metod_1();
        return null;
    }

    final int MAX_WORK = 100;

    private Text done;

    public Text getDone() {
        return done;
    }

    private void method_2(){
        done = new Text("Done");
        done.visibleProperty().setValue(false);

    }

    private void metod_1() {
        updateMessage("Идет работа");
        for (int i = 0; i < MAX_WORK; i++) {
            System.out.print("Немного поработали. ");
            System.out.println(i + 1);
            updateProgress(i + 1,MAX_WORK);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        updateMessage("Работа завершена");
    }



    protected void updateMessage(String message) {
        System.out.println(message);
        super.updateMessage(message);
    }

    @FXML
    private Text done;
}
