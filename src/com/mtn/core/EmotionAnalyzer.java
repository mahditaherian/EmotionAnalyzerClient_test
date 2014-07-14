package com.mtn.core;

import com.mtn.messages.SensorMessage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @author Mahdi
 */
public class EmotionAnalyzer {


    public void receiveMessages() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(21211);

            while (true) {
                // Create the Client Socket
                Socket clientSocket = welcomeSocket.accept();
                System.out.println("##############################START##############################");
                // Create input and output streams to client
//                ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

                // Read modify
                // TODO here

            /* Create Message object and retrive information */
                List<SensorMessage> messages;
                messages = (List<SensorMessage>) inFromClient.readObject();

                for (SensorMessage message : messages){
                    System.out.println(message);
                }
                System.out.println("###############################END###############################");

            /* Modify the message object */

            /* Send the modified Message object back */
//                outToClient.writeObject(inMsg);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmotionAnalyzer emotionAnalyzer = new EmotionAnalyzer();
        emotionAnalyzer.receiveMessages();
    }
}
