package org.example.demo;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnOth;

    @FXML
    private Button btnTest;

    @FXML
    private TableView<Person> tableAddressBook;

    @FXML
    private TableColumn<Person, String> columnPip;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private Label labelCount;

    @FXML
    private VBox scenePane;

    @FXML
    private RadioMenuItem first;

    @FXML
    private RadioMenuItem second;

    @FXML
    private ToggleGroup toggleContextText;

    private Stage dialogStage;
    private EditController editController;
    private Parent editRoot;
    private Stage newStage;





//    @FXML
//    void openNewWindow(ActionEvent event) {
//        Stage stage = new Stage();
//        FXMLLoader mainLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/demo/edit.fxml"));
//        Scene mainScene = null;
//        try {
//            mainScene = new Scene(mainLoader.load(), 600, 200);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.setTitle("Edit!");
//        stage.setScene(mainScene);
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initOwner(btnAdd.getScene().getWindow());
//        stage.show();
//    }

    @FXML
    void new_Alert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");

        alert.setHeaderText("Confirmation:");
        alert.setContentText("Deleting may change the order of people in your Address Book! ");
        alert.showAndWait();

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void openNewWindowOtherLabs() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/demo/other.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Other Labs");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnSearch.getScene().getWindow());

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void updateCountLabel(){
        labelCount.setText("Кількість записів: " + addressBookImpl.getPersonList().size());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnPip.setCellValueFactory(new PropertyValueFactory<Person, String>("pip"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
                updateCountLabel();
            }
        });

        addressBookImpl.fillTestData();
        tableAddressBook.setItems(addressBookImpl.getPersonList());

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/edit.fxml"));
            editRoot = loader.load();
            editController = loader.getController();

            System.out.println("editController = " + editController); // Debug: не має бути null

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showDialog() {
        if (dialogStage == null) {
            dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(tableAddressBook.getScene().getWindow());
            dialogStage.setScene(new Scene(editRoot));
        }
        dialogStage.showAndWait();
    }


    @FXML
    void openWindow(ActionEvent event) {
        Button btn = (Button) event.getSource();
        Person selected = tableAddressBook.getSelectionModel().getSelectedItem();

        switch (btn.getId()) {
            case "btnAdd":
                editController.setPerson(new Person("", ""));
                showDialog();
                addressBookImpl.add(editController.getPerson());
                break;

            case "btnEdit":
                if (selected != null) {
                    editController.setPerson(selected);
                    showDialog();
                }
                break;

            case "btnDelete":
                if (selected != null) {
                    addressBookImpl.delete(selected);
                }
                break;
        }
    }

    @FXML
    void openNewWindow() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("test.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 400);
            stage.setTitle("Test");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnTest.getScene().getWindow());

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exitButton(ActionEvent event) {
        newStage = (Stage) scenePane.getScene().getWindow();
        System.out.println("Success");
        newStage.close();
    }

    @FXML
    void toggleContextText(ActionEvent event) {
        if (toggleContextText.getSelectedToggle().equals(this.first))
            txtSearch.setText("RandomText");
        else if (toggleContextText.getSelectedToggle().equals(this.second))
            txtSearch.setText(null);
    }



}





