package com.santos.hexagonal.adapters.in.consumer;

import com.santos.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.santos.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.santos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "santos")
    public void receive(CustomerMessage customerMessage){
        var customer = this.customerMessageMapper.toCustomer(customerMessage);
        this.updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
