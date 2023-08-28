package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.UserBO;
import lk.ijse.d24hostalmng.dto.UserDTO;

import java.io.IOException;
import java.util.Objects;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField textPassword;
    public AnchorPane root;
    public Label lblWarning;
    public Hyperlink hypCreate;
    private int openCount = 0;

    private final UserBO userBO = BOFactory.getInstance().getBO(BOFactory.BOType.USER);

    public void txtPasswordOnAction(ActionEvent actionEvent) {
    }

    public void btnLogInOnAction(MouseEvent event) throws IOException {

        UserDTO userDTO = userBO.findCredential(txtUserName.getText());
        System.out.println(userDTO);

        if (userDTO!=null){
            if (userDTO.getGmail()!=null && textPassword.getText().equals(userDTO.getPassword())){
                Parent root = null;
                root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashbord-form.fxml")));
                if (root != null) {
                    Scene subScene = new Scene(root);
                    Stage primaryStage = (Stage) this.root.getScene().getWindow();
                    primaryStage.setScene(subScene);
                    primaryStage.centerOnScreen();

                    TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                    tt.setFromX(-subScene.getWidth());
                    tt.setToX(0);
                    tt.play();
                }
            }
        }else {
           lblWarning.setText("empty value or Invalid UserNAme or Password !");
        }
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

    public void hypOnAction(ActionEvent event) {
        openCount++;
        Stage satge1=new Stage();
        if (openCount==1){
            try {
                satge1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/create-form.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            satge1.getIcons().add(new Image("assets/icons8-house-512.png"));
            satge1.setTitle("hostel management system");
            satge1.show();
            satge1.setResizable(false);
        }

        satge1.setOnCloseRequest((w)->{
            openCount = 0;
        });
    }
}
