/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnsws.endpoint;

import br.com.dnsws.model.Server;
import br.com.dnsws.repository.ServerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jefferson Alves Reis (jefaokpta) < jefaokpta@hotmail.com >
 */
@RestController
@RequestMapping("v1/protected")
@Api(value="API REST Servidores")
public class ServerEndpoint {
    
    private final ServerRepository dao;
    @Autowired
    public ServerEndpoint(ServerRepository dao) {
        this.dao = dao;
    }
    
    @ApiOperation(value="Retorna todos Servidores")
    @GetMapping("/servers")
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
    }

    @ApiOperation(value="Cria um novo Servidor")
    @PostMapping("/servers")
    public ResponseEntity<?> save(@RequestBody Server server){
        return new ResponseEntity<>(dao.save(server), HttpStatus.CREATED);
    }
    
    @ApiOperation(value="Apaga um Servidor")
    @DeleteMapping("/servers/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @ApiOperation(value="Edita um Servidor")
    @PutMapping("/servers")
    public ResponseEntity<?> update(@RequestBody Server server){
        dao.save(server);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
