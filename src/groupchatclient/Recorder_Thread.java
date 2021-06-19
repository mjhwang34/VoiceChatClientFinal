/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupchatclient;

import static groupchatclient.StartGroupCall.no_mute;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author user
 */
public class Recorder_Thread extends Thread{
    public TargetDataLine audio_in=null;
    public InetAddress server_ip;
    public int server_port;
    byte byte_buff[]=new byte[1024];
    @Override
    public void run(){
        int i=0;
        while(no_mute){
            try {
                audio_in.read(byte_buff, 0, byte_buff.length);
                DatagramPacket data=new DatagramPacket(byte_buff, 0, byte_buff.length, server_ip, server_port);
                GroupChatClient.socket.send(data);
            } catch (IOException ex) {
                Logger.getLogger(Recorder_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        audio_in.close();
        audio_in.drain();
        System.out.println("Thread stop");
    }
}
