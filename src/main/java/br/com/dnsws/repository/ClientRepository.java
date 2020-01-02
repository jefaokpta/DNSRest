/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnsws.repository;

import br.com.dnsws.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jefferson Alves Reis (jefaokpta) < jefaokpta@hotmail.com >
 */
public interface ClientRepository extends CrudRepository<Client, Integer>{
    
}
