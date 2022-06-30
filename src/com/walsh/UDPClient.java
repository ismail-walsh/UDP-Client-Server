package com.walsh;

import java.io.*;
import java.net.*;
import java.nio.*;

public class UDPClient {
    private static final int bufferSize = 1024;
    private static final int port = 6789;
    private static final String host = "localhost";
    private static final int initialSequenceNumber = 1;

    public static void main(String args[]) throws Exception{
        // Create a socket
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.setSoTimeout(1000);

        // The message we're going to send converted to bytes
        Integer sequenceNumber = initialSequenceNumber;


        for (int counter = 0; counter < 5; counter++) {
            boolean timeOut = true;

            while(timeOut){
                sequenceNumber++;

                // Create a byte array for sending and receiving data
                byte[] sendData = new byte[bufferSize];
                byte[] receiveData = new byte[bufferSize];

                // Get the IP address of the server
                InetAddress IPAddress = InetAddress.getByName(host);

                System.out.println("Sending Packet (Sequence Number " + sequenceNumber + ")");
                // Get byte data for message
                sendData = ByteBuffer.allocate(4).putInt(sequenceNumber).array();

                try{
                    // Send the UDP Packet to the server
                    DatagramPacket packet = new DatagramPacket(sendData, sendData.length, IPAddress, 6789);
                    clientSocket.send(packet);

                    // Receive the server's packet
                    DatagramPacket received = new DatagramPacket(receiveData, receiveData.length);
                    clientSocket.receive(received);

                    // Get the message from the server's packet
                    int returnMessage = ByteBuffer.wrap( received.getData( ) ).getInt();

                    System.out.println( "FROM SERVER:" + returnMessage );
                    // If we receive an ack, stop the while loop
                    timeOut = false;
                } catch( SocketTimeoutException exception ){
                    // If we don't get an ack, prepare to resend sequence number
                    System.out.println("Timeout (Sequence Number " + sequenceNumber + ")");
                    sequenceNumber--;
                }
            }
        }

        clientSocket.close();
    }
}
