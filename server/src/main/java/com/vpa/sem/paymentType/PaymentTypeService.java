package com.vpa.sem.paymentType;

import com.vpa.sem.DTOs.PaymentTypeDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    //----------------------------------------------------------------------------------------------------------------//

    public List<PaymentTypeDto> GetPaymentTypes() {
        List<PaymentType> types = (List<PaymentType>) paymentTypeRepository.findAll();

        Type listType = new TypeToken<List<PaymentTypeDto>>() {}.getType();

        List<PaymentTypeDto> typeDtos = modelMapper.map(types, listType);

        return typeDtos;
    }
}
