package com.vpa.sem.paymentType;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType, Integer> {
}
