package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TestController {

    @FXML
    private CheckBox ChBSklad;

    @FXML
    private CheckBox ChBPogod;

    @FXML
    private CheckBox ChBGnuch;

    @FXML
    private CheckBox ChBDruz;

    @FXML
    private Label lblTrueAnswer;

    @FXML
    private ChoiceBox ChoiceB;

    @FXML
    private Label lblAnswerChoice;

    @FXML
    private Label lblCombo;

    @FXML
    private ComboBox ComboBox;

    @FXML
    private Label lblRadio;

    @FXML
    private RadioButton RBProp;

    @FXML
    private RadioButton RBLay;

    @FXML
    private RadioButton RBCode;

    @FXML
    private RadioButton RBHier;

    private ToggleGroup radioGroup;

    private int correctAnswers = 0;

    @FXML
    Label lblResult;

    public void initialize() {
        lblTrueAnswer.setText("");

        lblAnswerChoice.setText("");
        ChoiceB.getItems().addAll("Правильно","Неправильно");

        lblCombo.setText("");
        ComboBox.getItems().addAll("BorderPane","AncorePane","VBox","HBox");

        lblRadio.setText("");
        radioGroup = new ToggleGroup();
        this.RBProp.setToggleGroup(radioGroup);
        this.RBLay.setToggleGroup(radioGroup);
        this.RBCode.setToggleGroup(radioGroup);
        this.RBHier.setToggleGroup(radioGroup);
    }
    @FXML
    void checkBoxAnswer(ActionEvent event) {
        boolean correct =
                !ChBSklad.isSelected() &&
                        ChBPogod.isSelected() &&
                        ChBGnuch.isSelected() &&
                        ChBDruz.isSelected();

        if (correct) {
            lblTrueAnswer.setText("Правильна відповідь!");
            correctAnswers++;
        } else {
            lblTrueAnswer.setText("Подумайте ще!");
        }

    }
    @FXML
    void choiceBoxAnswer(ActionEvent event) {;
        String answer = ChoiceB.getValue().toString();
        String correctAnswer = "Неправильно";
        if (answer !=null && answer.equals(correctAnswer)) {
            lblAnswerChoice.setText("Ваша відповідь правильна!");
            correctAnswers++;
        }else {
            lblAnswerChoice.setText("Ваша відповідь неправильна!");
        }
    }
    @FXML
    void comboBoxPressed(ActionEvent event) {
        String answer = ComboBox.getValue().toString();
        String correctAnswer = "BorderPane";
        if (answer !=null && answer.equals(correctAnswer)) {
            lblCombo.setText("Ваша відповідь правильна!");
            correctAnswers++;
        }else {
            lblCombo.setText("Ваша відповідь неправильна!");
        }
    }
    @FXML
    void RadioAnswer(ActionEvent event) {
        RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
        String answer = selectedRadio.getText();
        String correctAnswer = "Properties";
        if (answer.equals(correctAnswer)) {
            lblRadio.setText("Ваша відповідь правильна!");
            correctAnswers++;
        }else {
            lblRadio.setText("Ваша відповідь неправильна!");
        }
    }

    @FXML
    void showResult(ActionEvent event) {
        lblResult.setText("Ви набрали " + correctAnswers + " правильних відповідей з 4 можливих.");
    }

}