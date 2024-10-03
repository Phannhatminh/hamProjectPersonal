package edu.augustana;

public interface HamRadioClientInterface {
    //main method to start the client that to be called in a main client program with the GUI
    void start();

    //configuration methods to set configuration for the ham radio
    void tunningFrequency(double frequency);
    void filterBandWidth();
    void setTransmitFrequency(double frequency);

    //helper methods to transmit and handle recieve signals
    void transmitSignal(byte[] transmitSignals);
    void onRecievingSignals(byte[] recievedSignals);
}