/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupchatclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ShowName extends Thread{
    @Override
    public void run(){
        while(true){
            try {
                byte[] buffer=new byte[1024];
                DatagramPacket nameincoming = new DatagramPacket(buffer, buffer.length);
                GroupChatClient.socket_name.receive(nameincoming);
                String names= new String(nameincoming.getData());
                StartGroupCall.names_area.setText(names+"\n");
            } catch (IOException ex) {
                Logger.getLogger(StartGroupCall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
