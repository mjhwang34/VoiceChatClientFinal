/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupchatclient;

import static groupchatclient.StartGroupCall.port_notice;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class GroupChatClient {
    public static boolean calling=false;
    public static DatagramSocket socket = null;
    public static DatagramSocket socket_name = null;
    public static DatagramSocket socket_notice=null;
    public static DatagramSocket socketplayer;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            socket = new DatagramSocket();
            socket_name =new DatagramSocket();
            socket_notice=new DatagramSocket(port_notice);
            socketplayer =new DatagramSocket(StartGroupCall.port_client_player);
        } catch (SocketException ex) {
            Logger.getLogger(GroupChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login fr=new Login();
        fr.setVisible(true);
    }
    
}
