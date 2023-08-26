package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.ReservationBO;
import lk.ijse.d24hostalmng.dto.CustomReservationDTO;
import lk.ijse.d24hostalmng.dto.ReservationDTO;
import lk.ijse.d24hostalmng.dto.RoomDTO;
import lk.ijse.d24hostalmng.dto.StudentDTO;
import lk.ijse.d24hostalmng.dto.tm.CustomResTM;
import lk.ijse.d24hostalmng.util.CustomAlert;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ReservationFormController {
    public JFXComboBox<String> cmdStudentNic;
    public Label lblStudentName;
    public Label lblStuAddress;
    public Label lblContact;
    public JFXComboBox<String> cmbRoomId;
    public JFXComboBox<String> cmbPaymentStatus;
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
    public TableView tblResView;
    private final ReservationBO reservationBO = BOFactory.getInstance().getBO(BOFactory.BOType.RESERVATION);


    @FXML
    void initialize(){
        setResId();
        setStudentIDs();
        setRoomIds();
        setPaymentStatus();
        fillTableAll();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colExpDate.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colReseId.setCellValueFactory(new PropertyValueFactory<>("reservationID"));
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("currentDate"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colStuName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colStuNic.setCellValueFactory(new PropertyValueFactory<>("studentNic"));
        colKeyMoneyStatus.setCellValueFactory(new PropertyValueFactory<>("keyMoneyStatus"));
    }

    private void fillTableAll() {
        ObservableList<CustomResTM> resTMS = FXCollections.observableArrayList();
        List<CustomReservationDTO> reservationDTO = reservationBO.getAllReservation();
        for (CustomReservationDTO dto : reservationDTO){
            resTMS.add(new CustomResTM(
                    dto.getReservationID(),
                    dto.getStudentNic(),
                    dto.getStudentName(),
                    dto.getRoomID(),
                    dto.getRoomType(),
                    dto.getCurrentDate(),
                    dto.getKeyMoney(),
                    dto.getKeyMoneyStatus(),
                    dto.getExpDate()
            ));

        }
        tblResView.setItems(resTMS);
    }

    private void setPaymentStatus() {
        cmbPaymentStatus.getItems().setAll("PAID","PENDING");
    }

    private void setRoomIds() {
        ObservableList<String> roomIdList = FXCollections.observableArrayList();
        for (String ids : reservationBO.getRoomIds()){
            roomIdList.add(ids);
        }
        cmbRoomId.setItems(roomIdList);
    }

    private void setStudentIDs() {
        ObservableList<String> idList = FXCollections.observableArrayList();
        for (String ids : reservationBO.getStudentIDs()){
            idList.add(ids);
        }
        cmdStudentNic.setItems(idList);
    }

    private void setResId() {
        lblResId.setText(reservationBO.getNextResID());
    }

    public void cmdStudentNicOnAction(ActionEvent event) {
        StudentDTO studentDTO = reservationBO.getStudent(cmdStudentNic.getValue());
        lblStudentName.setText(studentDTO.getStudentNAme());
        lblStuAddress.setText(studentDTO.getAddress());
        lblContact.setText(studentDTO.getContact());
    }

    public void cmbRoomIdOnAction(ActionEvent event) {
        RoomDTO roomDTO = reservationBO.getRoom(cmbRoomId.getValue());
        txtKeyMoney.setText(String.valueOf(roomDTO.getKeyMoney()));
        txtRoomQty.setText(String.valueOf(roomDTO.getQty()));
        txtRoomType.setText(roomDTO.getRoomType());
    }

    public void btnReservationOnAction(ActionEvent event) {
        boolean save = reservationBO.save(new ReservationDTO(
                lblResId.getText(),
                LocalDate.now(),
                cmbPaymentStatus.getValue(),
                cmdStudentNic.getValue(),
                cmbRoomId.getValue()
        ));

        if (save)
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","Student Save successful !").show();
        else
            new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();
    }

    public void cmbReservationIdOnAction(ActionEvent event) {
    }

    public void btnUpdateOnAction(ActionEvent event) {

    }

    public void btnDeleteOnAction(ActionEvent event) {

    }
}
