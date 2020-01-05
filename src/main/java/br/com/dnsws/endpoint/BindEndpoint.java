/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnsws.endpoint;

import br.com.dnsws.model.Bind;
import br.com.dnsws.repository.BindRepository;
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
@RequestMapping("v1/admin")
@Api(value="API REST Binds")
public class BindEndpoint {
    
    private final BindRepository dao;
    @Autowired
    public BindEndpoint(BindRepository dao) {
        this.dao = dao;
    }
    
    @ApiOperation(value="Retorna todos Servidores Bind9")
    @GetMapping("/binds")
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
    }

    @ApiOperation(value="Cria novo Servidor Bind9")
    @PostMapping("/binds")
    public ResponseEntity<?> save(@RequestBody Bind bind){
        return new ResponseEntity<>(dao.save(bind), HttpStatus.CREATED);
    }
    
    @ApiOperation(value="Apaga um Servidor Bind9")
    @DeleteMapping("/binds/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @ApiOperation(value="Edita um Servidor Bind9")
    @PutMapping("/binds")
    public ResponseEntity<?> update(@RequestBody Bind bind){
        dao.save(bind);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
