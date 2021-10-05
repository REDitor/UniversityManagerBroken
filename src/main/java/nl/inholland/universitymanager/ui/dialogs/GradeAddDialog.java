package nl.inholland.universitymanager.ui.dialogs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.universitymanager.ui.StyledScene;

public class GradeAddDialog {

    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public GradeAddDialog() {
        stage = new Stage();

        VBox layout = new VBox();
        layout.setPadding(new Insets(20));
        layout.setSpacing(20);

        TextField courseField = new TextField();
        courseField.setPromptText("Course");
        TextField gradeField = new TextField();
        gradeField.setPromptText("Grade");

        HBox buttons = new HBox();

        Button addStudentButton = new Button("Add Grade");
        addStudentButton.setDefaultButton(true);
        Button cancelButton = new Button("Cancel");
        buttons.getChildren().addAll(addStudentButton, cancelButton);

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

        addStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

        buttons.setSpacing(10);

        layout.getChildren().addAll(courseField, gradeField, buttons);

        Scene mainScene = new StyledScene(layout);

        stage.setMinWidth(250);
        stage.setTitle("Add grade");
        stage.setScene(mainScene);
    }
}
