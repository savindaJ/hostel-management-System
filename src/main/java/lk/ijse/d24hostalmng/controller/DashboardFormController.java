package lk.ijse.d24hostalmng.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class DashboardFormController {
    public ImageView btnDashbord;
    public ImageView btnReservation;
    public ImageView btnStudent;
    public ImageView btnRoom;
    public AnchorPane mainRoot;

    @FXML
    void initialize(){
        setHomeUi();
    }

    private void setHomeUi() {
        try {
            setUi("home-form.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDashbordOnAction(MouseEvent event) {
       setHomeUi();
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

    public void btnReservationOnAction(MouseEvent event) {
        try {
            setUi("reservation-form.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnStudentOnAction(MouseEvent event) {
        try {
            setUi("student-form.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnRoomOnAction(MouseEvent event) {
        try {
            setUi("room-form.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUi(String fileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + fileName));
        Pane root = fxmlLoader.load();
        try {
            mainRoot.getChildren().clear();
            mainRoot.getChildren().setAll(root);
            TranslateTransition tt = new TranslateTransition(Duration.millis(350), root);
            tt.setFromX(-root.getWidth());
            tt.setToX(0);
            tt.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
