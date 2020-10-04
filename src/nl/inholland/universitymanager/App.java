package nl.inholland.universitymanager;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.inholland.universitymanager.ui.windows.MainWindow;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // rendering the text more crisply
        System.setProperty("prism.lcdtext", "false");

        // We should open a login window, but that is outside of scope for this lesson.
        // So we go straight to the main window of the application

        // open the main window
        MainWindow mw = new MainWindow();
        mw.getStage().show();
    }
}
