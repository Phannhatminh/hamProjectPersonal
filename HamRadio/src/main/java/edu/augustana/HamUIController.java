package edu.augustana;

import java.io.IOException;
import javafx.fxml.FXML;

public class HamUIController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("WelcomeScreen");
    }
}