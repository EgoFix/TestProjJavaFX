package projjava.testprojjavafx;

import javafx.animation.KeyValue;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label labelToCheck;
    @FXML
    private TextArea textArea;
    @FXML
    private Text text;
    @FXML
    private ProgressBar bar;
    @FXML
    private Button Hello;


    CalcTask myTask; // экземпляр класса вычислений в контроллере

    // стандартная реализация
    @FXML
    public void initialize() {
        Hello.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (myTask != null && myTask.isRunning()) {
                    myTask.cancel();
                }

                myTask = new CalcTask();
                Thread thread = new Thread(myTask);
                thread.setDaemon(true);
                thread.start();

                bar.progressProperty().bind(myTask.progressProperty());

                Hello.disableProperty().bind(myTask.runningProperty());
            }
        });
    }

    // альтернативная реализация
    public void startTask(ActionEvent event) {
        if (myTask != null && myTask.isRunning()) {
            myTask.cancel();
        }

        myTask = new CalcTask();// инициализация экземпляра класса, где производятся вычисления
        Thread thread = new Thread(myTask); // далее создается поток, в который помещается данный экземпляр
        thread.setDaemon(true);
        thread.start();

        bar.progressProperty().bind(myTask.progressProperty());

        Hello.disableProperty().bind(myTask.runningProperty());
    }

    public void cancelTask(ActionEvent event) {
        if (myTask != null) myTask.cancel();
    }


}