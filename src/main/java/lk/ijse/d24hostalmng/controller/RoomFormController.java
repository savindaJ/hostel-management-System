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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.RoomBO;
import lk.ijse.d24hostalmng.dto.RoomDTO;
import lk.ijse.d24hostalmng.dto.tm.RoomTM;
import lk.ijse.d24hostalmng.util.CustomAlert;

public class RoomFormController {

    public JFXTextField txtRoomQty;
    public JFXComboBox<String> cmbRoomType;
    public JFXTextField txtKeyMoney;
    public Label lblNextRoomID;
    public TableView<RoomTM> tblRoom;
    public TableColumn colRoomID;
    public TableColumn colRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public JFXButton btnAddNew;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXComboBox<String> cmbRoomAvailability;
    public TableColumn colAvailability;

    private String roomID;
    private String roomType;
    private Integer roomQTY;
    private String roomAvailability;
    private Double keyMoney;

    private final RoomBO roomBO = BOFactory.getInstance().getBO(BOFactory.BOType.ROOM);

    @FXML
    void initialize(){
        setCellValueFactory();
        initUI();
        setRoomID();
        setTypes();
        fillTable();
        tblRowOnAction();
    }

    private void tblRowOnAction() {
        tblRoom.setOnMouseClicked((MouseEvent event)->{
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                RoomTM selectedItem = tblRoom.getSelectionModel().getSelectedItem();

                lblNextRoomID.setText(selectedItem.getRoomId());
                txtRoomQty.setText(String.valueOf(selectedItem.getQty()));
                txtKeyMoney.setText(String.valueOf(selectedItem.getKeyMoney()));
                cmbRoomAvailability.setValue(selectedItem.getRoomAvailability());
                cmbRoomType.setValue(selectedItem.getRoomType());

                txtKeyMoney.setDisable(false);
                txtRoomQty.setDisable(false);
                cmbRoomType.setDisable(false);
                cmbRoomAvailability.setDisable(false);

                btnUpdate.setDisable(false);
                btnDelete.setDisable(false);
                btnAdd.setDisable(true);
            }
        });
    }

    private void fillTable() {
        ObservableList<RoomTM> roomTMS = FXCollections.observableArrayList();
        for (RoomDTO room : roomBO.getAll()){
            roomTMS.add(new RoomTM(
                    room.getRoomId(),
                    room.getRoomType(),
                    room.getKeyMoney(),
                    room.getQty(),
                    room.getAvailability()
            ));
        }
        tblRoom.setItems(roomTMS);
    }


    private void setTypes() {
        cmbRoomType.getItems().setAll("AC","AC-FOOD","NON-AC","NON-AC/FOOD");
        cmbRoomAvailability.getItems().setAll("AVAILABLE","PENDING","NOT-AVAILBLE");
    }

    private void setRoomID() {
        lblNextRoomID.setText(roomBO.genarateID());
    }

    private boolean setData(){
        try {
            roomAvailability = cmbRoomAvailability.getValue();
            roomID = lblNextRoomID.getText();
            roomQTY = Integer.valueOf(txtRoomQty.getText());
            roomType = cmbRoomType.getValue();
            keyMoney = Double.valueOf(txtKeyMoney.getText());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private void initUI() {
        txtKeyMoney.clear();
        txtKeyMoney.setDisable(true);
        txtRoomQty.clear();
        txtRoomQty.setDisable(true);
        cmbRoomAvailability.setDisable(true);
        cmbRoomType.setDisable(true);
        btnAdd.setDisable(true);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
    }

    private void setCellValueFactory() {
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("roomAvailability"));
    }

    public void btnAddNewOnAction(ActionEvent event) {
        txtKeyMoney.clear();
        txtKeyMoney.setDisable(false);
        txtRoomQty.clear();
        txtRoomQty.setDisable(false);
        cmbRoomAvailability.setDisable(false);
        cmbRoomType.setDisable(false);
        btnAdd.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        setRoomID();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        if (setData()){
            boolean update = roomBO.update(new RoomDTO(
                    roomID,
                    roomType,
                    keyMoney,
                    roomQTY,
                    roomAvailability
            ));

            if (update)
                new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Room Update successful !").show();
            else
                new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
            initUI();
            fillTable();
            setRoomID();
        }

    }

    public void btnDeleteOnAction(ActionEvent event) {
        boolean delete = roomBO.delete(lblNextRoomID.getText());
        if (delete)
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Room Delete successful !").show();
        else
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Delete !","Delete not successful !").show();
        fillTable();
        initUI();
        setRoomID();
    }

    public void btnAddOnAction(ActionEvent event) {
        if (setData()){
            boolean save = roomBO.save(new RoomDTO(
                    roomID,
                    roomType,
                    keyMoney,
                    roomQTY,
                    roomAvailability
            ));

            if (save)
                new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","Student Save successful !").show();
            else
                new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();
        }else {
            new CustomAlert(Alert.AlertType.WARNING,"Save ","Not Saved !","Please Enter Valid Data !").show();
        }
        fillTable();
        setRoomID();
        initUI();
    }
}
