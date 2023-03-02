package com.liuqiang.controller;

import com.liuqiang.service.PaymentService;
import entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/queryById/{id}")
    public ResponseEntity<Payment> queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment){
            return ResponseEntity.status(HttpStatus.OK).body(payment);
        }
        return ResponseEntity.status(HttpStatus.valueOf("查询不到该数据")).body(null);

    }
    @PostMapping("/insert")
    public ResponseEntity<Payment> insert( Payment payment){
        int i = paymentService.create(payment);
        if (i!=0){
            return ResponseEntity.status(200).body(null);
        }
        return ResponseEntity.status(304).body(null);
    }

}
