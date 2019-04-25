package com.vpa.sem.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM Users u WHERE u.login like %keyWord%")
    User findByName(@Param("keyWord") String userLogin);
}
