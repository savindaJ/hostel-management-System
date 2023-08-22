package lk.ijse.d24hostalmng.controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HomeFormController {
    public Label lblRoomTotal;
    public Label lblStuTotal;
    public Label lblAvRoom;
    public Label lblTime;
    public ImageView btnLogOut;

    public void btnLogoutOnAction(MouseEvent event) {
        Stage satge1=new Stage();
        try {
            satge1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Login-form.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        satge1.getIcons().add(new Image("assets/icons8-house-512.png"));
        satge1.setTitle("hostel management system");
        satge1.show();
        satge1.setResizable(false);
        Stage stage2= (Stage) btnLogOut.getScene().getWindow();
        stage2.close();
    }

    public void mouseEnterImg(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(15);
            glow.setHeight(15);
            glow.setRadius(15);
            icon.setEffect(glow);
        }
    }

    public void mouseExitImg(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);
        }
    }
}
