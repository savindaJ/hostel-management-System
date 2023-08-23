package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.StudentBO;
import lk.ijse.d24hostalmng.entity.Student;

import java.sql.Date;

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

    private String nic;
    private String name;
    private String address;
    private String contact;
    private Date dob;
    private String gender;

    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    @FXML
    void initialize(){

    }

    public void btnAddNewOnAction(ActionEvent event) {
        txtStudentAddress.setDisable(false);
        txtStudentContact.setDisable(false);
        txtStudentName.setDisable(false);
        txtStudentNic.setDisable(false);
        cmbGender.setDisable(false);
        datePicker.setDisable(false);
        txtStudentNic.requestFocus();
    }

    void initUI(){
        txtStudentAddress.setDisable(true);
        txtStudentContact.setDisable(true);
        txtStudentName.setDisable(true);
        txtStudentNic.setDisable(true);
        cmbGender.setDisable(true);
        datePicker.setDisable(true);
        txtStudentAddress.clear();
        txtStudentContact.clear();
        txtStudentName.clear();
        txtStudentNic.clear();
        cmbGender.getItems().clear();
    }

    private void setDetail() {
        nic = txtStudentNic.getText();
        name = txtStudentName.getText();
        address = txtStudentAddress.getText();
        contact = txtStudentContact.getText();
        dob = Date.valueOf(datePicker.getValue());
        gender = cmbGender.getValue();
    }

    public void btnAddOnAction(ActionEvent event) {
        setDetail();
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnUpdateOnAction(ActionEvent event) {
        setDetail();
    }
}
