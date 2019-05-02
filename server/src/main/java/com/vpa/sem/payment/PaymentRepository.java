package com.vpa.sem.payment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    //@Query("SELECT p FROM PAYMENTS p WHERE p.user_id LIKE %keyWord%")
    //List<Payment> FindUserPayments(@Param("keyWord") Integer userId);
}
