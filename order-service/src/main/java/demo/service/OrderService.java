package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.common.Payment;
import demo.common.TransactionRequest;
import demo.common.TransactionResponse;
import demo.common.*;
import demo.entity.Order;
import demo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;

	@Autowired
	private RestTemplate template;

	public TransactionResponse saveOrder(TransactionRequest request) {
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		//client-side load balancing
//		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment,
//				Payment.class);
//
//		response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful"
//				: "there is a failure";

		repository.save(order);

//		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(),
//				response);
		return new TransactionResponse();
	}
}
