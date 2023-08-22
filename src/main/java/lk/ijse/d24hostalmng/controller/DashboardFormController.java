package lk.ijse.d24hostalmng.controller;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class DashboardFormController {
    public Label lblRoomTotal;
    public Label lblStuTotal;
    public Label lblAvRoom;
    public ImageView btnDashbord;
    public ImageView btnReservation;
    public ImageView btnStudent;
    public ImageView btnRoom;

    public void btnDashbordOnAction(MouseEvent event) {
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
    }

    public void btnStudentOnAction(MouseEvent event) {
    }

    public void btnRoomOnAction(MouseEvent event) {
    }

    public void btnLogoutOnAction(MouseEvent event) {

    }
}
