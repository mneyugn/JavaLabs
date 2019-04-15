package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Controller;
import sample.model.Task;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddTaskController implements Initializable {

    private Task task;

    @FXML
    public TableView<Task> toDoTable;

    @FXML
    private TextField titleInput;

    @FXML
    private TextField textInput;

    @FXML
    private ComboBox<String> priorytyInput;

    @FXML
    private DatePicker dateInput;

    @FXML
    void addTask() {
        System.out.println("add Task handler");
        Task task = new Task();
        task.setTitle(titleInput.getText());
        task.setPriority(priorytyInput.getAccessibleText());
        task.setDate(dateInput.getValue());
        task.setText(textInput.getText());

        this.task = task;

        System.out.println(task.getTitle());
        System.out.println(task.getPriority());
        System.out.println(task.getDate());
        System.out.println(task.getText());

        Stage stage = (Stage) textInput.getScene().getWindow();
        stage.close();
    }

    public Task getTask() {
        return task;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        priorytyInput.getItems().add("Low");
        priorytyInput.getItems().add("Medium");
        priorytyInput.getItems().add("High");

        task = new Task();
        task.setTitle("ttttttt");
        priorytyInput.getSelectionModel().selectFirst();

//        Controller con = new Controller();
//        con.setExTask(task);

        dateInput.setValue(LocalDate.now());


    }
}
