package edu.augustana;

import java.io.IOException;
import javafx.fxml.FXML;

public class WelcomeScreenController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("HamUI");
    }
}
