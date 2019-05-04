package com.vpa.sem.role;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.name LIKE :roleName")
    List<Role> GetRole(@Param("roleName") String roleName);
}
