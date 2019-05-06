package com.vpa.sem.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.login LIKE :userLogin")
    User findByLogin(@Param("userLogin") String userLogin);

    @Query("SELECT u FROM User u WHERE u.id = :userId")
    User findByLongId(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.firstName = :firstName, u.lastName = :lastName, u.payoutAmount = :payout WHERE u.id = :id")
    void updateUser(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("payout") Double payout);
}
