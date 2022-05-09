package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.common.*;
import demo.common.TransactionRequest;
import demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private OrderService service;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request)
	{
		System.out.println("bookorder");
		return service.saveOrder(request);
	}
	@GetMapping("/neworder")
	public void checkGetMapping() {
		System.out.println("Hello world");
	}
}
