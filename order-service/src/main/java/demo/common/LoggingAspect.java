package demo.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import io.micrometer.core.ipc.http.HttpSender.Request;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* demo.controller.OrderController.bookOrder(..))")
	public void addLogAtBeginning(JoinPoint joinPoint) {
		TransactionRequest req = (TransactionRequest) joinPoint.getArgs()[0];
		System.out.println(req.getOrder().getName());
	}
	
	@After("execution(* demo.controller.OrderController.bookOrder(TransactionRequest))")
	public void addLogAtLast(JoinPoint joinPoint) {
		System.out.println("At the end");
	}
}
