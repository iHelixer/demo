package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerController {

    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker myDatePicker;


    @FXML
    public void initialize() {

        myDatePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                String dateFormatter =
                        newDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                dateLabel.setText(dateFormatter);
            }
        });


    }





}
