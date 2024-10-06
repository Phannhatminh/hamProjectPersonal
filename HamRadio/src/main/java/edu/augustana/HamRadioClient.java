package edu.augustana;

import javax.websocket.*;
import java.net.URI;
import java.nio.ByteBuffer;

@ClientEndpoint
public class HamRadioClient implements HamRadioClientInterface {
    private Session session;
    private double transmitFrequency;
    private double recieveFrequency;
    private double bandwidth;

    @Override
    public void connectToServer(String serverUri) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(this, new URI(serverUri));
    }

    //server WebSocketAPI code
    @OnMessage
    public void onBinaryMessage(byte[] message) {
        System.out.println("Recieve byte[] type message");
        receiveAndProcessSignal(message);
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connection success");
        this.session = session;
    }

    // onError
    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    //HamRadioClient code
    @Override
    public void sendCWSignal(String morseCode) {
        byte[] signal = parseMorseCodeToCW(morseCode);
        try {
            if (session != null && session.isOpen()) {
                session.getBasicRemote().sendBinary(ByteBuffer.wrap(signal));
                System.out.println("Signal is sent");
            } else {
                System.out.println("Socket connection is not openned yet");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void receiveAndProcessSignal(byte[] signal) {
        //parseFromCWSignalToMorse
        //play sound that morse
    }

    @Override
    public void setReceivingFrequency(double freq) {
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
        if (session != null && session.isOpen()) {
            try {
                session.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
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
