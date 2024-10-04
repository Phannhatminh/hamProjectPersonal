module edu.augustana {
    requires javafx.controls;
    requires javafx.fxml;
    requires Java.WebSocket;
    requires tyrus.standalone.client;

    opens edu.augustana to javafx.fxml;
    exports edu.augustana;
}
