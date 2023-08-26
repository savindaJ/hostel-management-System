package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.ReservationBO;

public class ReservationFormController {
    public JFXComboBox cmdStudentNic;
    public Label lblStudentName;
    public Label lblStuAddress;
    public Label lblContact;
    public JFXComboBox cmbRoomId;
    public JFXComboBox cmbPaymentStatus;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXButton btnReservation;
    public JFXComboBox cmbReservationId;
    public Label lblStuId;
    public Label lblStuName;
    public JFXComboBox cmbPStatusEdit;
    public JFXTextField txtRoomTypeEdit;
    public JFXTextField txtKeyMoneyEdit;
    public JFXTextField txtQtyEdit;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public Label lblResId;
    public TableColumn colReseId;
    public TableColumn colStuNic;
    public TableColumn colStuName;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colDate;
    public TableColumn colKeyMoney;
    public TableColumn colKeyMoneyStatus;
    public TableColumn colExpDate;

    private final ReservationBO reservationBO = BOFactory.getInstance().getBO(BOFactory.BOType.RESERVATION);

    @FXML
    void initialize(){
        setResId();
    }

    private void setResId() {
        lblResId.setText(reservationBO.getNextResID());
    }

    public void cmdStudentNicOnAction(ActionEvent event) {
    }

    public void cmbRoomIdOnAction(ActionEvent event) {
    }

    public void btnReservationOnAction(ActionEvent event) {
    }

    public void cmbReservationIdOnAction(ActionEvent event) {
    }

    public void btnUpdateOnAction(ActionEvent event) {
    }

    public void btnDeleteOnAction(ActionEvent event) {

    }
}
