package edu.augustana;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HamRadioClient implements HamRadioClientInterface {
    private Socket socket;
    private DataInputStream inputHandler;
    private DataOutputStream outputHandler;
    private double transmitFrequency;
    private double receiveFrequency;
    private double bandwidth;

    public void connectToServer(String serverIp,int serverPort) throws IOException {
        this.socket = new Socket(serverIp, serverPort);
        this.inputHandler = new DataInputStream(socket.getInputStream());
        this.outputHandler = new DataOutputStream(socket.getOutputStream());

        // Thread to receive signal from server
        new Thread(new ReceiveSignalThread()).start();
    }
    
    //Thread to handle signals from server
    class ReceiveSignalThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    int signalSize = inputHandler.readInt();
                    byte[] receivedSignal = new byte[signalSize];
                    inputHandler.readFully(receivedSignal);
                    receiveAndProcessSignal(receivedSignal);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //HamRadioClient code
    public void sendCWSignal(String morseCode) throws IOException {
        byte[] signal = parseMorseCodeToCW(morseCode);
        outputHandler.writeInt(signal.length);
        outputHandler.write(signal);
    }
    
    public void receiveAndProcessSignal(byte[] signal) {
        //parseFromCWSignalToMorse
        //code to filering and shit...
        //play sound that morse
    }

    public void setReceivingFrequency(double freq) {
        this.receiveFrequency = freq;
    }
    
    public void filerBandWidth(double bandWidth) {
        this.bandwidth = bandWidth;
    }
    
    public void setTransmitFrequency(double freq) {
        this.transmitFrequency = freq;
    }
    
    public void closeConnection() {

    }

    //helper methods:
    private byte[] parseMorseCodeToCW(String morseCode) {
        byte[] byteBuffer = new byte[1024];
        return byteBuffer;
    }
}

//next:
//signal processing code (tmr)
//WebSocket API client-server config (sat)
//test (sun)
