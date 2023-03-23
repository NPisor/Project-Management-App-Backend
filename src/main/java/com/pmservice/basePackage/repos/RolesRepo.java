package com.pmservice.basePackage.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Role.Role;

public interface RolesRepo extends Repository<Role, Long> {

    Optional<Collection<Role>> findAll();

    Optional<Role> findByLabelAndClientId(String label, Long clientId);

    Optional<Role> findByIdAndClientId(Long roleId, Long clientId);

    Optional<Collection<Role>> findAllByClientId(Long clientId);

    Role save(Role role);

    Optional<Role> delete(Role role) throws Exception;

}
