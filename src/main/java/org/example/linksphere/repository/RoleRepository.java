package org.example.linksphere.repository;

import org.example.linksphere.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    RoleModel findByName(String name);
}
