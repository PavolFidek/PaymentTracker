package com.vpa.sem.payment;

import com.vpa.sem.paymentType.PaymentType;
import com.vpa.sem.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    @Query("SELECT p FROM Payment p WHERE p.user = :user AND year(p.realizationDate) = year(CURRENT_DATE) AND month(p.realizationDate) = month(CURRENT_DATE)")
    List<Payment> findUserPayments(@Param("user") User user);

    @Query("SELECT p FROM Payment p WHERE p.id = :paymentId")
    Payment findByLongId(@Param("paymentId") Long paymentId);

    @Transactional
    @Modifying
    @Query("UPDATE Payment p SET p.amount = :amount, p.note = :note, p.realizationDate = :realizationDate, p.type = :paymentType WHERE p.id = :id")
    void updatePaymentById(@Param("id") Long id, @Param("amount") Double amount, @Param("note") String note, @Param("realizationDate") Date realizationDate, @Param("paymentType") PaymentType type);
}
