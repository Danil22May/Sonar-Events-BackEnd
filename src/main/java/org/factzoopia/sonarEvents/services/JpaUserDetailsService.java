package org.factzoopia.sonarEvents.services;


import org.factzoopia.sonarEvents.models.SecurityAdmin;
import org.factzoopia.sonarEvents.repositories.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JpaUserDetailsService implements UserDetailsService{

    AdminRepository repository;

    
    public JpaUserDetailsService(AdminRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
            .findByEmail(username)
            .map(SecurityAdmin::new)
            .orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username));
    }

    
}