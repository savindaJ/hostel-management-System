package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RoomFormController {

    public JFXTextField txtRoomQty;
    public JFXComboBox<String> cmbRoomType;
    public JFXTextField txtKeyMoney;
    public Label lblNextRoomID;
    public TableView tblRoom;
    public TableColumn colRoomID;
    public TableColumn colRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public JFXButton btnAddNew;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnAdd;

    @FXML
    void initialize(){

    }

    public void btnAddNewOnAction(ActionEvent event) {
    }

    public void btnUpdateOnAction(ActionEvent event) {
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnAddOnAction(ActionEvent event) {

    }
}
