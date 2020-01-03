/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnsws.security;

import br.com.dnsws.model.User;
import br.com.dnsws.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author jefaokpta
 */
@Component
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository dao;

    @Autowired
    public CustomUserDetailsService(UserRepository dao) {
        this.dao = dao;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u=dao.findByUsername(username);
        
        if(u==null)
            throw new UsernameNotFoundException("NAO ENCONTRADO USUARIO: "+username);
        
        List<GrantedAuthority> authorityListAdmin=AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser=AuthorityUtils.createAuthorityList("ROLE_USER");
        
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), u.isAdmin() ? authorityListAdmin : authorityListUser);
    }

    
    
    
}
