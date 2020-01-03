/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnsws.endpoint;

import br.com.dnsws.util.Ping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jefferson Alves Reis (jefaokpta) < jefaokpta@hotmail.com >
 */
@RestController
@RequestMapping("ping")
public class PingEndpoint {
    
    @GetMapping("/{ip}")
    public boolean ping(@PathVariable String ip){
        return new Ping().doPing(ip);
    } 
}
