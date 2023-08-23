package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentFormController {

    public JFXTextField txtStudentNic;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public JFXComboBox<String> cmbGender;
    public TableView tblStudentDetail;
    public TableColumn colNIC;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDate;
    public TableColumn colGender;
    public DatePicker datePicker;

    @FXML
    void initialize(){

    }

    public void btnAddNewOnAction(ActionEvent event) {
    }

    public void btnAddOnAction(ActionEvent event) {
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnUpdateOnAction(ActionEvent event) {

    }
}
