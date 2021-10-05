package nl.inholland.universitymanager.ui.windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.universitymanager.ui.StyledScene;
import nl.inholland.universitymanager.ui.views.StudentListView;
import nl.inholland.universitymanager.ui.views.TeacherListView;

public class MainWindow {
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public MainWindow() {
        // create a new Stage (window)
        stage = new Stage();

        // setup the global layout, menu on the left, subscene on the right
        HBox layout = new HBox();

        // the menu
        VBox menu = new VBox();
        menu.setPadding(new Insets(80,20,20,20));
        menu.setSpacing(10);
        menu.getStyleClass().add("menu");
        Button studentsButton = new Button("Students");
        studentsButton.setMinWidth(150);
        Button teachersButton = new Button("Teachers");
        teachersButton.setMinWidth(150);
        menu.getChildren().addAll(studentsButton, teachersButton);

        studentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout.getChildren().set(1, new StudentListView());
            }
        });

        teachersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout.getChildren().set(1, new TeacherListView());
            }
        });

        // Add the menu and the view. Default view will be the student list view
        layout.getChildren().addAll(menu, new StudentListView());

        // Create the main scene
        Scene mainScene = new StyledScene(layout);

        // Let's go!
        stage.setTitle("University Management");
        stage.setScene(mainScene);
    }
}
