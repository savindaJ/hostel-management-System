package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.UserBO;
import lk.ijse.d24hostalmng.dto.UserDTO;
import lk.ijse.d24hostalmng.util.CustomAlert;

public class CreateFormController {
    public JFXTextField txtGmail;
    public JFXPasswordField txtPassword;
    public JFXButton btnCreate;

    private final UserBO userBO = BOFactory.getInstance().getBO(BOFactory.BOType.USER);

    public void btnCreateOnAction(ActionEvent event) {
        boolean save = userBO.save(new UserDTO(
                txtGmail.getText(),
                txtPassword.getText()
        ));
        if (save){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","User Save successful !").show();
            Stage stage2= (Stage) btnCreate.getScene().getWindow();
            stage2.close();
        }
        else
            new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();
    }
}
