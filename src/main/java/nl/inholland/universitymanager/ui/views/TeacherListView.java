package nl.inholland.universitymanager.ui.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.universitymanager.data.Database;
import nl.inholland.universitymanager.models.Teacher;

public class TeacherListView extends VBox {

    // This is just a mess that is there for filler. Has nothing to do with the assignments ;)

    private TableView<Teacher> table = new TableView<>();
    private Database db;

    public TeacherListView() {

        db = new Database();

        ObservableList<Teacher> data = FXCollections.observableArrayList(db.getTeachers());

        this.setPadding(new Insets(20));

        Label heading = new Label();
        heading.setText("Teachers");
        heading.getStyleClass().add("header");


        table.setEditable(true);
        table.getSelectionModel().setCellSelectionEnabled(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(150);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(220);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("lastName"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(250);
        emailCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("email"));

        TableColumn groupCol = new TableColumn("Salary");
        groupCol.setMinWidth(250);
        groupCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("salary"));

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, groupCol);


        HBox studentMenu = new HBox();
        studentMenu.setPadding(new Insets(20,0,0,0));
        studentMenu.setSpacing(10);

        Button addTeacherButton = new Button("Add Teacher");
        Button editTeacherButton = new Button("Edit Teacher");
        Button deleteTeacherButton = new Button("Delete Teacher");
        studentMenu.getChildren().addAll(addTeacherButton, editTeacherButton, deleteTeacherButton);

        this.getChildren().addAll(heading, table, studentMenu);
    }
}
