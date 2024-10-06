package edu.augustana;

import java.io.IOException;

public class HamRadioClientHoang implements HamRadioClientInterface{
    private double transmissionFrequency;
    private double receivedFrequency;
    private double bandWidth;
    private boolean isConnected;

    /***
     * Users connect to the system and set the required bandwidth to receieve
     * sounds and target frequency to transmit. Their activate status should be on.
     */
    public void connect(double frequency, double bandwidth){
        this.transmissionFrequency = frequency;
        this.receivedFrequency = frequency;
        this.bandWidth = bandWidth;
        isConnected = true;
    }

    @Override
    public void connectToServer(String serverIp, int serverPort) throws IOException {
        return;

    }

    /**
     * Filter bandwidth is adjustible. On UI, it would look like a slider.
     * @param bandWidth
     */
    @Override
    public void filerBandWidth(double bandWidth) {
        this.bandWidth = bandWidth;
    }

    @Override
    public void receiveAndProcessSignal(byte[] signal) {

    }

    @Override
    public void sendCWSignal(String morseCode) {

    }

    @Override
    public void setReceivingFrequency(double freq) {
        this.receivedFrequency = freq;
    }

    @Override
    public void setTransmitFrequency(double freq) {

    }

    @Override
    public void closeConnection() {

    }

}


