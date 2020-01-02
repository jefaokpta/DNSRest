/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnsws.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jefaokpta
 */
@Entity @Table(name = "dnss")
public class Dnss implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iddnss")
    private int id;
    private int idclient;
    private String description;
    private String serverdns;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServerdns() {
        return serverdns;
    }

    public void setServerdns(String serverdns) {
        this.serverdns = serverdns;
    }
    
    
}
