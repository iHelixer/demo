package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class FilechooserController {
    
    @FXML
    private ImageView imgView;
    
    @FXML
    private Button scenePane;
    




    @FXML
    void filechooser(ActionEvent event) throws IOException{
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Get Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        Stage stage = (Stage) scenePane.getScene().getWindow();

        File file = fileChooser.showOpenDialog(stage);

        if (file !=null){
            URI uri = file.toURI();
            Image image = new Image(uri.toString());
            imgView.setImage(image);
        }
    }



}
