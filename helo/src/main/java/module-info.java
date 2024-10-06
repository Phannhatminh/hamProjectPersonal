module edu.augustana {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.websocket.api;
    requires tyrus.server;

    opens edu.augustana to javafx.fxml;
    exports edu.augustana;
}
