package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.StudentBO;
import lk.ijse.d24hostalmng.dto.StudentDTO;
import lk.ijse.d24hostalmng.dto.tm.StudentTM;
import lk.ijse.d24hostalmng.util.CustomAlert;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        initUI();
        setGender();
        fillTable();
        setCellValueFactory();
        tblStudentDetail.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){
                StudentTM selectedItem = (StudentTM) tblStudentDetail.getSelectionModel().getSelectedItem();
                txtStudentNic.setText(selectedItem.getStudentNIC());
                txtStudentName.setText(selectedItem.getStudentNAme());
                txtStudentContact.setText(selectedItem.getContact());
                txtStudentAddress.setText(selectedItem.getAddress());
                cmbGender.setValue(selectedItem.getGender());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String date = String.valueOf(selectedItem.getDob());
                datePicker.setValue(LocalDate.parse(date,formatter));

                txtStudentAddress.setDisable(false);
                txtStudentContact.setDisable(false);
                txtStudentName.setDisable(false);
                txtStudentNic.setDisable(true);
                cmbGender.setDisable(false);
                datePicker.setDisable(false);
                txtStudentNic.requestFocus();

                tblStudentDetail.refresh();
            }
        });
    }

    private void setCellValueFactory() {
        colNIC.setCellValueFactory(new PropertyValueFactory<>("studentNIC"));
        colName.setCellValueFactory(new PropertyValueFactory<>("studentNAme"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    private void fillTable() {
        ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();
        for (StudentDTO dto : studentBO.getAll()){
            studentTMS.add(new StudentTM(
                    dto.getStudentNIC(),
                    dto.getStudentNAme(),
                    dto.getAddress(),
                    dto.getContact(),
                    dto.getDob(),
                    dto.getGender()
            ));
        }
        tblStudentDetail.setItems(studentTMS);
    }


    private void setGender() {
        cmbGender.getItems().setAll("Male","Female","Other");
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
        boolean save = studentBO.save(new StudentDTO(nic, name, address, contact, dob, gender));

        if (save)
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","Student Save successful !").show();
        else
            new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();
        initUI();
        fillTable();
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnUpdateOnAction(ActionEvent event) {
        setDetail();
        boolean update = studentBO.update(new StudentDTO(nic, name, address, contact, dob, gender));

        if (update)
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
        else
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        initUI();
        fillTable();
    }
}
