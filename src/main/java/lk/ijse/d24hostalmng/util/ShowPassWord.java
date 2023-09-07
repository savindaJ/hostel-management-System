package lk.ijse.d24hostalmng.util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowPassWord extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // text field to show password as unmasked
        final TextField textField = new TextField();
        // Set initial state
        textField.setManaged(false);
        textField.setVisible(false);

        // Actual password field
        final PasswordField passwordField = new PasswordField();

        CheckBox checkBox = new CheckBox("Show/Hide password");

        // Bind properties. Toggle textField and passwordField
        // visibility and managability properties mutually when checkbox's state is changed.
        // Because we want to display only one component (textField or passwordField)
        // on the scene at a time.
        textField.managedProperty().bind(checkBox.selectedProperty());
        textField.visibleProperty().bind(checkBox.selectedProperty());

        passwordField.managedProperty().bind(checkBox.selectedProperty().not());
        passwordField.visibleProperty().bind(checkBox.selectedProperty().not());

        // Bind the textField and passwordField text values bidirectionally.
        textField.textProperty().bindBidirectional(passwordField.textProperty());

        VBox root = new VBox(10);
        root.getChildren().addAll(passwordField, textField, checkBox);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
