/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupchatclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author user
 */
public class Player_Thread extends Thread{
    public SourceDataLine audio_out;
    byte[] buffer=new byte[1024];
    @Override
    public void run(){
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        while(GroupChatClient.calling){
            try {
                GroupChatClient.socket.receive(incoming);
                buffer=incoming.getData();
                audio_out.write(buffer,0,buffer.length);
                System.out.println("playing");
            } catch (IOException ex) {
                Logger.getLogger(Player_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        audio_out.close();
        audio_out.drain();
        System.out.println("stop");
    }
    
}
