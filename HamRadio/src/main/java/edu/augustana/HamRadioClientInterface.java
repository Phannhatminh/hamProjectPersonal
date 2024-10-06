package edu.augustana;

public interface HamRadioClientInterface {
    // connect to server
    void connectToServer(String serverUri) throws Exception;

    // Send CW as byte buffer
    void sendCWSignal(String morseCode);

    // Recieve and handle signals from server
    void receiveAndProcessSignal(byte[] signal);

    // set the frequency
    void setReceivingFrequency(double freq);

    // set the bandwidth
    void filerBandWidth(double bandWidth);

    // set transmitting frequency
    void setTransmitFrequency(double freq);

    // close WebSocket connection
    void closeConnection();
}
