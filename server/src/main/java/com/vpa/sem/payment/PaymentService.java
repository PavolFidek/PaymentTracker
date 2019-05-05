package com.vpa.sem.payment;

import com.vpa.sem.DTOs.PaymentDto;
import com.vpa.sem.paymentType.PaymentTypeRepository;
import com.vpa.sem.user.User;
import com.vpa.sem.user.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    //----------------------------------------------------------------------------------------------------------------//

    public PaymentDto GetPayment(Long paymentId) {
        Payment payment = paymentRepository.findByLongId(paymentId);
        User currentUser = userService.GetLoggedUser();

        if (payment == null || !payment.getUser().getId().equals(currentUser.getId())) {
            return new PaymentDto();
        }

        PaymentDto paymentDto = modelMapper.map(payment, PaymentDto.class);

        return paymentDto;
    }

    public List<PaymentDto> GetAllPayments() {
        User currentUser = userService.GetLoggedUser();

        List<Payment> userPayments = paymentRepository.findUserPayments(currentUser);

        Type listType = new TypeToken<List<PaymentDto>>() {}.getType();

        List<PaymentDto> paymentsDto = modelMapper.map(userPayments, listType);

        return paymentsDto;
    }

    public PaymentDto AddPayment(PaymentDto paymentDto) {
        Payment newPayment = modelMapper.map(paymentDto, Payment.class);
        newPayment.setUser(userService.GetLoggedUser());

        paymentRepository.save(newPayment);

        PaymentDto createdPayment = modelMapper.map(newPayment, PaymentDto.class);

        return createdPayment;
    }

    public PaymentDto RemovePayment(Long paymentId) {
        Payment paymentToDelete = paymentRepository.findByLongId(paymentId);

        if (paymentToDelete != null) {
            paymentRepository.delete(paymentToDelete);
        }

        PaymentDto paymentDto = modelMapper.map(paymentToDelete, PaymentDto.class);

        return paymentDto;
    }

    public PaymentDto UpdatePayment(PaymentDto paymentDto) {
        Payment editedPayment = modelMapper.map(paymentDto, Payment.class);
        editedPayment.setUser(userService.GetLoggedUser());

        // Edit payment in database by id
        paymentRepository.updatePaymentById(
                paymentDto.getId(),
                editedPayment.getAmount(),
                editedPayment.getNote(),
                editedPayment.getRealizationDate(),
                editedPayment.getType()
        );

        editedPayment = paymentRepository.findByLongId(paymentDto.getId());

        PaymentDto paymentToReturn = modelMapper.map(editedPayment, PaymentDto.class);

        return paymentToReturn;
    }
}
