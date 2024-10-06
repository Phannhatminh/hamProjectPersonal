package edu.augustana;

import java.io.IOException;

public interface HamRadioClientInterface {
    // connect to server
    void connectToServer(String serverIp, int serverPort) throws IOException;

    // Send CW as byte buffer
    void sendCWSignal(String morseCode) throws IOException;

    // Recieve and handle signals from server
    void recieveAndProcessSignal(byte[] signal);

    // set the frequency
    void setRecievingFrequency(double freq);

    // set the bandwidth
    void filerBandWidth(double bandWidth);

    // set transmitting frequency
    void setTransmitFrequency(double freq);

    // close WebSocket connection
    void closeConnection();
}
