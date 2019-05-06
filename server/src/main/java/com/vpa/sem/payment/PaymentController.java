package com.vpa.sem.payment;

import com.vpa.sem.DTOs.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getPayment/{paymentId}")
    public PaymentDto GetPayment(@PathVariable Long paymentId) {

        return paymentService.GetPayment(paymentId);
    }

    @GetMapping("/getAllPayments")
    public List<PaymentDto> GetAllPayments() {

        return paymentService.GetAllPayments();
    }

    @PostMapping("/new")
    public PaymentDto CreatePayment(@RequestBody PaymentDto newPaymentDto) {

        return paymentService.AddPayment(newPaymentDto);
    }

    @PostMapping("/delete")
    public PaymentDto DeletePayment(@RequestBody Long paymentId) {

        return paymentService.RemovePayment(paymentId);
    }

    @PostMapping("/update")
    public PaymentDto UpdatePayment(@RequestBody PaymentDto paymentDto) {

        return paymentService.UpdatePayment(paymentDto);
    }
}
