/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupchatclient;

import static groupchatclient.StartGroupCall.set_notice;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ***
 */
public class ReceiveNotice_Thread extends Thread{
    public void run(){
        while(true){
            try {
                byte[] buffer=new byte[1024];
                DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
                GroupChatClient.socket_notice.receive(incoming);
                String notice= new String(incoming.getData());
                StartGroupCall.set_notice.setText(notice+"\n");
                
            } catch (IOException ex) {
                Logger.getLogger(StartGroupCall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
