package com.order.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.service.OrderService;
import com.order.util.TransactionRequest;
import com.order.util.TransactionResponse;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired(required = true)
	OrderService orderService;

	@PostMapping("/placeOrder")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest transactionRequest) {
		
		Order order = transactionRequest.getOrder();
		Order saveOrder = orderService.saveOrder(order);
		
		return new TransactionResponse();
	}
	
	@GetMapping("/placeOrder")
	public String saveOrder() {
		
		//Order order = transactionRequest.getOrder();
		//Order saveOrder = orderService.saveOrder(order);
		
		return "success";
	}

	
	@Scheduled(cron = "*/60 * * * * *")
	   public void cronJobSch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Java cron job expression:: " + strDate);
	   }
}
