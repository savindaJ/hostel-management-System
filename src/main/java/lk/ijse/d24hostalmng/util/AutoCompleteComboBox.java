package lk.ijse.d24hostalmng.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class AutoCompleteComboBox<T> extends ComboBox<T> {

    private final ObservableList<T> originalItems;

    public AutoCompleteComboBox(ObservableList<T> items) {
        super();
        this.originalItems = FXCollections.observableArrayList();
        this.setEditable(true);
        this.setOnKeyReleased(event -> handleAutoComplete());
        super.setItems(items);
        originalItems.setAll(items);
    }

    private void handleAutoComplete() {
        String enteredText = this.getEditor().getText();
        ObservableList<T> filteredItems = FXCollections.observableArrayList();

        if (enteredText.isEmpty()) {
            filteredItems.setAll(originalItems);
        } else {
            for (T item : originalItems) {
                if (item.toString().toLowerCase().contains(enteredText.toLowerCase())) {
                    filteredItems.add(item);
                }
            }
        }

        this.setItems(filteredItems);
        this.show();
    }
}
