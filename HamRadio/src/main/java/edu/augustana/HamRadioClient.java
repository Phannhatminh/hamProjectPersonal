package edu.augustana;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HamRadioClient implements HamRadioClientInterface {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private double transmitFrequency;
    private double recieveFrequency;
    private double bandwidth;

    public void connectToServer(String serverIp,int serverPort) throws IOException {
        this.socket = new Socket(serverIp, serverPort);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        // Thread để nhận tín hiệu từ server
        new Thread(new RecieveSignalThread()).start();
    }

    //Thread to handle signals from server
    class RecieveSignalThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    int signalSize = in.readInt();
                    byte[] recievedSignal = new byte[signalSize];
                    in.readFully(recievedSignal);
                    recieveAndProcessSignal(recievedSignal);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //HamRadioClient code
    @Override
    public void sendCWSignal(String morseCode) throws IOException {
        byte[] signal = parseMorseCodeToCW(morseCode);
        out.writeInt(signal.length);
        out.write(signal);
    }

    @Override
    public void recieveAndProcessSignal(byte[] signal) {
        //parseFromCWSignalToMorse
        //code to filering and shit...
        //play sound that morse
    }

    @Override
    public void setRecievingFrequency(double freq) {
        this.recieveFrequency = freq;
    }

    @Override
    public void filerBandWidth(double bandWidth) {
        this.bandwidth = bandWidth;
    }

    @Override
    public void setTransmitFrequency(double freq) {
        this.transmitFrequency = freq;
    }

    @Override
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
