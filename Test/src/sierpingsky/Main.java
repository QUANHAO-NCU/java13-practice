package sierpingsky;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane= FXMLLoader.load(getClass().getResource("View/main.fxml"));
        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setTitle("塞尔平斯基");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
