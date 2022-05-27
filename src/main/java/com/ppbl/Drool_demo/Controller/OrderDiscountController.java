package com.ppbl.Drool_demo.Controller;

import com.ppbl.Drool_demo.Entity.OrderDiscount;
import com.ppbl.Drool_demo.Entity.OrderRequest;
import com.ppbl.Drool_demo.Service.OrderDiscountService;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = "com.ppbl.Drool_demo.Controller")
public class OrderDiscountController {

    @Autowired
    private OrderDiscountService orderDiscountService;
    private KieContainer kieContainer;

    @PostMapping("/discount")
    public OrderDiscount getDiscount(@RequestBody OrderRequest orderRequest){
        OrderDiscount discount=orderDiscountService.getDiscount(orderRequest);
        return discount;
    }
}
