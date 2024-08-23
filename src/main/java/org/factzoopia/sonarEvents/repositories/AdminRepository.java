package org.factzoopia.sonarEvents.repositories;


import java.util.Optional;

import org.factzoopia.sonarEvents.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>{

    public Optional<Admin> findByEmail(String email);

}
