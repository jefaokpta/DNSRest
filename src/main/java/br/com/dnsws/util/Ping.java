/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dnsws.util;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Jefferson A. Reis < jefaokpta@hotmail.com >
 */
public class Ping {

    public boolean doPing(String ip){
        String[] ipArray=ip.split("\\.");
        InetAddress address = null;
        boolean res = false;
        try {
            address = Inet4Address.getByAddress(new byte[] {
                (byte)Integer.parseInt(ipArray[0].trim()),
                (byte)Integer.parseInt(ipArray[1].trim()),
                (byte)Integer.parseInt(ipArray[2].trim()),
                (byte)Integer.parseInt(ipArray[3].trim())
            });
            //System.out.println("IP RECONSTRUIDO "+address.getHostAddress());
            res=address.isReachable(3000); //Recupera o endereço boolean pingBemSucedido = address.isReachable(1000); //O parâmetro é o timeout.
        } catch (UnknownHostException ex) {
            Logger.getLogger(Ping.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ping.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
