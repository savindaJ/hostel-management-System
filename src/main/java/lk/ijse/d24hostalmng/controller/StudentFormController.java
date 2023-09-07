package lk.ijse.d24hostalmng.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.StudentBO;
import lk.ijse.d24hostalmng.dto.StudentDTO;
import lk.ijse.d24hostalmng.dto.tm.StudentTM;
import lk.ijse.d24hostalmng.util.CustomAlert;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentFormController {

    public JFXTextField txtStudentNic;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public JFXComboBox<String> cmbGender;
    public TableView<StudentTM> tblStudentDetail;
    public TableColumn colNIC;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDate;
    public TableColumn colGender;
    public DatePicker datePicker;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXComboBox<String> cmbOption;
    public JFXTextField txtSearch;

    private String nic;
    private String name;
    private String address;
    private String contact;
    private Date dob;
    private String gender;
    private boolean visible = true;

    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    private List<StudentDTO> currentStuList = new ArrayList<>();

    private ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();

    @FXML
    void initialize(){
        initUI();
        setGender();
        fillTable();
        setCellValueFactory();
        cmbOption.getItems().setAll("NAME","ADDRESS","NIC");
        tblStudentDetail.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
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

                btnUpdate.setDisable(false);
                btnDelete.setDisable(false);
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
            currentStuList.add(dto);
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
        btnAdd.setDisable(false);
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
        cmbGender.setValue("");
        btnDelete.setDisable(true);
        btnAdd.setDisable(true);
        btnUpdate.setDisable(true);
    }

    private boolean setDetail() {
       try {
           nic = txtStudentNic.getText();
           name = txtStudentName.getText();
           address = txtStudentAddress.getText();
           contact = txtStudentContact.getText();
           dob = Date.valueOf(datePicker.getValue());
           gender = cmbGender.getValue();
           return true;
       }catch (Exception e){
           return false;
       }
    }

    public void btnAddOnAction(ActionEvent event) {
        if (setDetail()){
            boolean save = studentBO.save(new StudentDTO(nic, name, address, contact, dob, gender));

            if (save)
                new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","Student Save successful !").show();
            else
                new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();

        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Invalid ! ","Not valid values !","please enter valid values !").show();
        }
        initUI();
        fillTable();
    }

    public void btnDeleteOnAction(ActionEvent event) {

        if (!txtStudentNic.getText().isEmpty()){
            boolean delete = studentBO.delete(txtStudentNic.getText());

            if (delete)
                new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Student Delete successful !").show();
            else
                new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Delete !","Delete not successful !").show();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Delete !","Not selected student id !").show();
        }
        initUI();
        fillTable();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        if (setDetail()){
            boolean update = studentBO.update(new StudentDTO(nic, name, address, contact, dob, gender));

            if (update)
                new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
            else
                new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();

        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Invalid ! ","Not valid values !","please enter valid values !").show();
        }
        initUI();
        fillTable();
    }

    public void mouseClicked(MouseEvent event) {
        if (visible){
            txtSearch.clear();
            cmbOption.setValue("");
            txtSearch.setVisible(true);
            cmbOption.setVisible(true);
            visible = false;
        }else {
            txtSearch.clear();
            cmbOption.setValue("");
            txtSearch.setVisible(false);
            cmbOption.setVisible(false);
            visible = true;
        }
    }

    public void mouseEnterd(MouseEvent event) {
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

    public void mouseExit(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);
        }

    }

    /*public void txtSearchKeyTyped(KeyEvent keyEvent) {

        if (txtSearch.getText().equals("")){
            fillTable();
        }else {
            studentTMS.removeAll();
            studentTMS.clear();
            for (StudentDTO dto : currentStuList){
                if (cmbOption.getValue().equals("NAME")){
                    studentTMS.clear();
                    if (dto.getStudentNAme().equals(txtSearch.getText())){
                        studentTMS.add(new StudentTM(
                                dto.getStudentNIC(),
                                dto.getStudentNAme(),
                                dto.getAddress(),
                                dto.getContact(),
                                dto.getDob(),
                                dto.getGender()
                        ));
                    }
                }else if (cmbOption.getValue().equals("ADDRESS")){
                    studentTMS.clear();
                    if (dto.getAddress().equals(txtSearch.getText())){
                        studentTMS.add(new StudentTM(
                                dto.getStudentNIC(),
                                dto.getStudentNAme(),
                                dto.getAddress(),
                                dto.getContact(),
                                dto.getDob(),
                                dto.getGender()
                        ));
                    }
                }else {
                    if (dto.getStudentNIC().equals(txtSearch.getText())){
                        studentTMS.add(new StudentTM(
                                dto.getStudentNIC(),
                                dto.getStudentNAme(),
                                dto.getAddress(),
                                dto.getContact(),
                                dto.getDob(),
                                dto.getGender()
                        ));
                    }
                }
            }
            tblStudentDetail.setItems(studentTMS);
        }
    }*/

    public void txtSearchKeyRelease(KeyEvent keyEvent) {
        if (txtSearch.getText().equals("")){
            fillTable();
        }else {

            for (StudentDTO dto : currentStuList){
                if (cmbOption.getValue().equals("NAME")){
                    if (dto.getStudentNAme().equals(txtSearch.getText())){
                        studentTMS.add(new StudentTM(
                                dto.getStudentNIC(),
                                dto.getStudentNAme(),
                                dto.getAddress(),
                                dto.getContact(),
                                dto.getDob(),
                                dto.getGender()
                        ));
                    }
                }else if (cmbOption.getValue().equals("ADDRESS")){
                    if (dto.getAddress().equals(txtSearch.getText())){
                        studentTMS.add(new StudentTM(
                                dto.getStudentNIC(),
                                dto.getStudentNAme(),
                                dto.getAddress(),
                                dto.getContact(),
                                dto.getDob(),
                                dto.getGender()
                        ));
                    }
                }else {
                    if (dto.getStudentNIC().equals(txtSearch.getText())){
                        studentTMS.add(new StudentTM(
                                dto.getStudentNIC(),
                                dto.getStudentNAme(),
                                dto.getAddress(),
                                dto.getContact(),
                                dto.getDob(),
                                dto.getGender()
                        ));
                    }
                }
            }
            tblStudentDetail.refresh();
            tblStudentDetail.setItems(studentTMS);
        }
    }
}
