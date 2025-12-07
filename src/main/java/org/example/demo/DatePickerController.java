package org.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DatePickerController {

    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker myDatePicker;

    @FXML
    private ColorPicker myColorPicker;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Slider mySlider;

    @FXML
    private Label sliderLabel;

    private int score;



    @FXML
    public void initialize() {

        myDatePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                String dateFormatter =
                        newDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                dateLabel.setText(dateFormatter);
            }
        });


        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                score = (int) mySlider.getValue();
                sliderLabel.setText(score + " Балів");

            }
        });


    }

    @FXML
    void changeColor(ActionEvent event) {
        Color myColor = myColorPicker.getValue();
        scenePane.setBackground(new Background(new BackgroundFill(myColor,null, null)));
    }








}
