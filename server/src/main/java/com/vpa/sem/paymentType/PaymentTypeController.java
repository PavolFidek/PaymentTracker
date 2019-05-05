package com.vpa.sem.paymentType;

import com.vpa.sem.DTOs.PaymentTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/paymentType")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping("/all")
    public List<PaymentTypeDto> GetPaymentTypes() {

        return paymentTypeService.GetPaymentTypes();
    }
}
