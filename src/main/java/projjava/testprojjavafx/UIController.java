package projjava.testprojjavafx;

import javafx.concurrent.Task;

public class UIController extends Task {
    @Override
    protected Object call() throws Exception {
        // в зависимости от условия класс выбирает функцию, нужно добавить listener для выбора функции в соответствии с задачей
        // если какой-то процесс завершился, то нужно передать выполнение другому процессу
        // либо UI, либо потоку вычисления



        return null;
    }
}
