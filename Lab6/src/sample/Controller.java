package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.controllers.AddTaskController;
import sample.model.Task;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.lang.String.format;


public class Controller implements Initializable {

    private static final String ADD_TASK_FXML = "./view/AddTask.fxml";


    private Task exTask;
    public void setExTask(Task exTask) {
        this.exTask = exTask;
    }
    @FXML
    private TableColumn<Task, String> toDoTableColumn;

    @FXML
    private TableColumn<Task, String> inProgressTableCollumn;

    @FXML
    private TableColumn<Task, String> doneTableColumn;

    @FXML
    public TableView<Task> toDoTable;

    @FXML
    private TableView<Task> inProgressTable;

    @FXML
    private TableView<Task> doneTable;

    @FXML
    ListView<Task> IN_PROGRESS;


    public ObservableList<Task> toDoList;
    public ObservableList<Task> inProgressList;
    public ObservableList<Task> doneList;

    @FXML
    public void closeApplication() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void aboutAuthor() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("About author");
        informationAlert.setHeaderText("Marcin Nguyen");
        informationAlert.setContentText("content text");
        informationAlert.showAndWait();
    }

    @FXML
    public void addTask() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource(ADD_TASK_FXML));
        Pane Pane = loader.load();
        Scene scene = new Scene(Pane);
        Stage addTaskStage = new Stage();
        addTaskStage.setScene(scene);
        addTaskStage.setTitle("Add new task");
        addTaskStage.show();
        addTaskStage.setResizable(false);

        AddTaskController addTaskController = loader.getController();
        Task task1 = addTaskController.getTask();
        toDoTable.getItems().add(task1);

        System.out.println(task1.getTitle());


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Task> exList = FXCollections.observableArrayList(
                new Task("title", "niskie", LocalDate.now(),"asdf")
        );
        toDoTableColumn.setEditable(true);
        toDoTableColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));

        toDoTable.setItems(exList);
        toDoList = FXCollections.observableArrayList();

        inProgressList = FXCollections.observableArrayList();
        doneList = FXCollections.observableArrayList();


        toDoTableColumn.setCellFactory(new Callback<TableColumn<Task, String>, TableCell<Task, String>>() {
            @Override
            public TableCell<Task, String> call(TableColumn<Task, String> param) {
                return new TableCell<Task, String>() {

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (!empty) {
//                            setText(format(item));

                            if (item.) {

                                setTextFill(Color.CHOCOLATE);
                            } else {
                                setTextFill(Color.BLACK);
                            }

                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });



    }


}
