package kanban.view;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class RootLayoutController {

    public void closeApplication() {
        Platform.exit();
        System.exit(0);
    }

    public void aboutAuthor() {

        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("About author");
        informationAlert.setHeaderText("Information");
        informationAlert.setContentText("Marcin Nguyen\n" +
                "Applied Computer Science\n"+
                "AGH University of Science and Technology\n");
        informationAlert.showAndWait();
    }
}
