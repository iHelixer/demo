package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import javafx.scene.media.Media;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MediaController implements Initializable {

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    @FXML
    private MediaView mediaView;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

    }


    @FXML
    void playButton_method(ActionEvent event) { // реалізація кнопки Play
        mediaPlayer.play();
    }
    @FXML
    void pauseButton_method(ActionEvent event) { // реалізація кнопки Pause
        mediaPlayer.pause();
    }
    @FXML
    void resetButton_method(ActionEvent event) { // реалізація кнопки Reset
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
            mediaPlayer.play();
        }
    }




}
