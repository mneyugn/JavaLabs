package sample.dialogs;

import javafx.scene.control.Alert;

public class DialogsUtils {

    public static void dialogAboutAuthor() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("About author");
        informationAlert.setHeaderText("Marcin Nguyen");
        informationAlert.setContentText("content text");
        informationAlert.showAndWait();
    }
}
