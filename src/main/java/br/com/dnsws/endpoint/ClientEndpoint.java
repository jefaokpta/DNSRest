/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnsws.endpoint;

import br.com.dnsws.model.Client;
import br.com.dnsws.repository.ClientRepository;
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
@Api(value="API REST Clientes")
public class ClientEndpoint {
    
    private final ClientRepository dao;
    @Autowired
    public ClientEndpoint(ClientRepository dao) {
        this.dao = dao;
    }
    
    @ApiOperation(value="Retorna todos os Clientes")
    @GetMapping("/clients")
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
    }

    @ApiOperation(value="Cria novo Cliente")
    @PostMapping("/clients")
    public ResponseEntity<?> save(@RequestBody Client client){
        return new ResponseEntity<>(dao.save(client), HttpStatus.CREATED);
    }
    
    @ApiOperation(value="Apaga um Cliente")
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @ApiOperation(value="Edita um Cliente")
    @PutMapping("/clients")
    public ResponseEntity<?> update(@RequestBody Client client){
        dao.save(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
