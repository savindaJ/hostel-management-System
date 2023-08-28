package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.UserBO;
import lk.ijse.d24hostalmng.dto.UserDTO;
import lk.ijse.d24hostalmng.util.CustomAlert;

import java.io.IOException;

public class SettingFormController {
    public JFXPasswordField txtPasswordConfirmed;
    public JFXTextField txtGmail;
    public JFXPasswordField txtPassword;
    public JFXButton btnChange;
    public JFXButton btnDeleteAccunt;

    private final UserBO userBO = BOFactory.getInstance().getBO(BOFactory.BOType.USER);

    public void btnChangeOnAction(ActionEvent event) {
        boolean update = userBO.update(new UserDTO(
                txtGmail.getText(),
                txtPasswordConfirmed.getText()
        ));
        if (update)
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
        else
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
    }

    public void btnDeleteAccuntOnAction(ActionEvent event) {
        Stage stage=new Stage();
        boolean delete = userBO.delete(txtGmail.getText());
        if (delete){
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Login-form.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.getIcons().add(new Image("assets/icons8-house-512.png"));
            stage.setTitle("hostel management system");
            stage.show();
            stage.setResizable(false);
            Stage stage2= (Stage) btnDeleteAccunt.getScene().getWindow();
            stage2.close();
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Student Delete successful !").show();
        }
        else
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Delete !","Delete not successful !").show();
    }
}
