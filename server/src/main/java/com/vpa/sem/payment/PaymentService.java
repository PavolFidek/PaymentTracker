package com.vpa.sem.payment;

import com.vpa.sem.DTOs.PaymentDto;
import com.vpa.sem.paymentType.PaymentTypeRepository;
import com.vpa.sem.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    private ModelMapper modelMapper;

    public PaymentService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Payment GetPayment(int paymentId) {
        Payment payment = paymentRepository.findById(paymentId).get();

        // TODO payment mapping to dto.

        return payment;
    }

    public List<Payment> GetUserPayments() {
        Integer currentUserId = 1;
        // User currentuser = SecurityContextHolder.getContext().getAuthentication().

        List<Payment> userPayments = (List<Payment>) paymentRepository.findAll();


        return userPayments;
    }

    public Payment AddPayment(PaymentDto paymentDto) {


        return new Payment();
    }
}
