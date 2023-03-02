package com.liuqiang.controller;


import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    public static final String url = "http://localhost:8001/payment/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/insert")
    public ResponseEntity<Object> create( Payment payment){
        Integer post = restTemplate.postForObject(url+"insert?id="+payment.getId()+"&serial="+payment.getSerial(), "POST", Integer.class);
        if (post!=null){
            return ResponseEntity.status(200).body("插入数据成功");
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);

    }
    @GetMapping("/query/{id}")
    public ResponseEntity<Payment> queryPayment(@PathVariable("id") Long id){
        Payment payment= restTemplate.getForObject(url+"queryById/"+id, Payment.class);
        if (payment!=null){
            return ResponseEntity.status(200).body(payment);
        }
        return ResponseEntity.status(500).body(null);

    }
}
