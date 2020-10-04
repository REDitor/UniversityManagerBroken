package nl.inholland.universitymanager.ui.windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import nl.inholland.universitymanager.ui.scenes.StudentListScene;
import nl.inholland.universitymanager.ui.scenes.StyledScene;
import nl.inholland.universitymanager.ui.scenes.TeacherListScene;

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
                StudentListScene sl = new StudentListScene();
                layout.getChildren().remove(1);
                layout.getChildren().add(sl.getScene().getRoot());
            }
        });

        teachersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TeacherListScene tl = new TeacherListScene();
                layout.getChildren().remove(1);
                layout.getChildren().add(tl.getScene().getRoot());
            }
        });

        // Add the subscene. Default view will be the student list view
        StudentListScene sl = new StudentListScene();
        layout.getChildren().addAll(menu, sl.getScene().getRoot());

        // Create the main scene
        Scene mainScene = new StyledScene(layout);

        // Let's go!
        stage.setTitle("University Management");
        stage.setScene(mainScene);
    }
}
