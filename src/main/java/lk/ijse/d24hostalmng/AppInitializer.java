package lk.ijse.d24hostalmng;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("")));
        primaryStage.setScene(scene);
        primaryStage.setTitle("hostel management system");
        primaryStage.getIcons().add(new Image(""));
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();

        TranslateTransition tt = new TranslateTransition(Duration.millis(350), scene.getRoot());
        tt.setFromX(-scene.getWidth());
        tt.setToX(0);
        tt.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
