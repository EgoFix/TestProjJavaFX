package projjava.testprojjavafx;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class HelloController{
    @FXML
    private Label welcomeText;
    @FXML
    private Label labelToCheck;
    @FXML
    private TextArea textArea;
    @FXML
    private Text text;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(){


        Service<Void> service = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        for (int i = 0; i < 20; i++){
//                            labelToCheck.setText(Integer.toString(i));
                            text.setText(Integer.toString(i));
                            Thread.sleep(150);
//                            labelToCheck.requestFocus();
//                            textArea.setText(Integer.toString(i));
//                            Thread.sleep(150);
                        }
                        return null;
                    }
                };
            }
        };


//        Platform.runLater(new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++){
//                    labelToCheck.setText(Integer.toString(i));
//                    try {
//                        Thread.sleep(250);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });

        Service<Void> service1 = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        test2class test = new test2class();
                        test.run();
                        return null;
                    }
                };
            }
        };

        service.start();

        service1.start();
    }

}