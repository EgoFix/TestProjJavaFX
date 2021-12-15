module projjava.testprojjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens projjava.testprojjavafx to javafx.fxml;
    exports projjava.testprojjavafx;
}