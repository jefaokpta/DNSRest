/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnsws.endpoint;

import br.com.dnsws.model.User;
import br.com.dnsws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jefferson Alves Reis (jefaokpta) < jefaokpta@hotmail.com >
 */
@RestController
@RequestMapping("v1")
public class UserEndpoint {
    
    private final UserRepository dao;
    @Autowired
    public UserEndpoint(UserRepository dao) {
        this.dao = dao;
    }
    
    @PostMapping("/users")
    public ResponseEntity<?> get(@RequestBody User user){
        return new ResponseEntity<>(dao.findByUsername(user.getUsername()), HttpStatus.OK);
    }
}
