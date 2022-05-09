package demo.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* demo.controller.OrderController.bookOrder(..))")
	public void addLogAtBeginning(JoinPoint joinPoint) {
		TransactionRequest req = (TransactionRequest) joinPoint.getArgs()[0];
		System.out.println(req.getOrder().getName());
	}

	@After("execution(*demo.controller.OrderController.bookOrder(TransactionRequest))")
	public void addLogAtLast(JoinPoint joinPoint) {
		System.out.println("At the end");
	}

	@After("execution(* demo.*.Order*.*(TransactionRequest))")
	public void addLogAtEnd(JoinPoint joinPoint) {// advice System.out.println("at the end");

	}

	@AfterThrowing(pointcut = "execution(*demo.controller.OrderController.bookOrder(..))", throwing = "ex")
	public void handleException(Exception ex) {
		System.out.println("Reason :" + ex.getMessage());
	}

	@AfterThrowing(pointcut = "execution(intdemo.controller.OrderController.bookOrder(..))", throwing = "ex")
	public void handleException2(Exception ex) {
		System.out.println("Reason :" + ex.getMessage());
	}

	@AfterThrowing(pointcut = "execution(Object demo.controller.OrderController.bookOrder(..))", throwing = "ex")
	public void handleException3(Exception ex) {
		System.out.println("Reason :" + ex.getMessage());
	}
}
